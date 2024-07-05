package com.sansilvestre.desktop.app.branch.data.source;

public class BranchQuery {

    public static final String SELECT_GENERATED_TIMESTAMP =
            "SELECT updated_date FROM branches WHERE id = ?;";

    public static final String SELECT_BRANCH_BY_ID =
            "SELECT * FROM branches WHERE id = ?;";

    public static final String SELECT_BRANCHES =
            "SELECT * FROM branches;";

    public static final String SELECT_BRANCHES_BY_SEARCH =
            "SELECT * FROM branches WHERE name LIKE ? OR address LIKE ? ORDER BY CASE " +
                    "WHEN name = ? THEN 1 " +
                    "WHEN address = ? THEN 2 " +
                    "WHEN name LIKE ? THEN 3 " +
                    "WHEN address LIKE ? THEN 4 " +
                    "ELSE 5 END, name;";

    public static final String INSERT_BRANCH =
            "INSERT INTO branches (name, address, user_id) VALUES (?, ?, ?);";

    public static final String SYNC_INSERT_BRANCH =
            "INSERT INTO branches (name, address, user_id, added_date, updated_date) VALUES (?, ?, ?, ?, ?);";

    public static final String UPDATE_BRANCH =
            "UPDATE branches SET name = ?, address = ?, user_id = ? WHERE id = ?;";

    public static final String SYNC_UPDATE_BRANCH =
            "UPDATE branches SET name = ?, address = ?, user_id = ?, updated_date = ? WHERE id = ?;";

    public static final String DELETE_BRANCH_BY_ID =
            "DELETE FROM branches WHERE id = ?;";

}