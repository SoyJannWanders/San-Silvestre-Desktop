package com.sansilvestre.desktop.app.user.data.source;

import com.sansilvestre.desktop.app.user.domain.util.exception.InvalidUpdateQueryException;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

public class UserQuery {

    public static final String SELECT_USERS =
            "SELECT * FROM users";

    public static final String SELECT_USERS_BY_SEARCH =
            "SELECT * FROM users WHERE name LIKE ? OR surname LIKE ? ORDER BY CASE " +
                    "WHEN name = ? THEN 1 " +
                    "WHEN surname = ? THEN 2 " +
                    "WHEN name LIKE ? THEN 3 " +
                    "WHEN surname LIKE ? THEN 4 " +
                    "ELSE 5 END, name;";

    public static final String SELECT_USERS_BY_ROLE =
            "SELECT * FROM users WHERE role = ?;";

    public static final String SELECT_USERS_BY_BRANCH_ID =
            "SELECT * FROM users WHERE branch_id = ?;";

    public static final String INSERT_USER =
            "INSERT INTO users (name, surname, password, phone, salary, role, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?);";

    public static final String UPDATE_USER =
            "UPDATE users SET name = ?, surname = ?, password = ?, phone = ?, salary = ?, role = ?, branch_id = ? WHERE id = ?;";

    public static final String UPDATE_USER_SALARY_BY_ID =
            "UPDATE users SET salary = ? WHERE id = ?;";

    public static final String UPDATE_USERS_SALARIES_FIXED =
            "UPDATE users SET salary = salary + ? WHERE branch_id != 1;";


    public static final String UPDATE_USERS_SALARIES_PERCENTAGE =
            "UPDATE users SET salary = salary * (1 + ? / 100) WHERE branch_id != 1;";

    public static final String UPDATE_USERS_SALARIES_BY_BRANCH_ID_FIXED =
            "UPDATE users SET salary = salary + ? WHERE branch_id = ?;";

    public static final String UPDATE_USERS_SALARIES_BY_BRANCH_ID_PERCENTAGE =
            "UPDATE users SET salary = salary * (1 + ? / 100) WHERE branch_id = ?;";

    public static final String DELETE_USER_BY_ID =
            "DELETE FROM users WHERE id = ?;";

    public static String getUpdateUsersSalariesQuery(IncreaseType increaseType, int branchId) throws InvalidUpdateQueryException {
        System.out.println(branchId);
        switch (increaseType) {
            case FIXED -> {
                if (branchId != 1)
                    return UserQuery.UPDATE_USERS_SALARIES_BY_BRANCH_ID_FIXED;
                else
                    return UserQuery.UPDATE_USERS_SALARIES_FIXED;
            }
            case PERCENTAGE -> {
                if (branchId != 1)
                    return UserQuery.UPDATE_USERS_SALARIES_BY_BRANCH_ID_PERCENTAGE;
                else
                    return UserQuery.UPDATE_USERS_SALARIES_PERCENTAGE;
            }
            default ->
                throw new InvalidUpdateQueryException();
        }
    }

}