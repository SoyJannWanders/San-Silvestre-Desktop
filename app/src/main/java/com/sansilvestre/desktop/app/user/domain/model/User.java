package com.sansilvestre.desktop.app.user.domain.model;

import com.sansilvestre.desktop.app.user.data.source.UserDatabase;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class User {

    private int userId;
    private String name;
    private String surname;
    private String password;
    private String phone;
    private double salary;
    private Role role;
    private LocalDateTime addedDate;
    private LocalDateTime updatedDate;


    private int branchId;

    public User(ResultSet result) throws SQLException {
        userId = result.getInt(UserDatabase.ID.getColumnName());
        name = result.getString(UserDatabase.NAME.getColumnName());
        surname = result.getString(UserDatabase.SURNAME.getColumnName());
        password = result.getString(UserDatabase.PASSWORD.getColumnName());
        phone = result.getString(UserDatabase.PHONE.getColumnName());
        salary = result.getDouble(UserDatabase.SALARY.getColumnName());
        role = Role.valueOf(result.getString(UserDatabase.ROLE.getColumnName()));
        branchId = result.getInt(UserDatabase.OFFICE.getColumnName());
        addedDate = result.getTimestamp(UserDatabase.ADDED_DATE.getColumnName()).toLocalDateTime();
        updatedDate = result.getTimestamp(UserDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
    }

    public User(String name, String surname, String password, String phone, double salary, Role role, int branchId) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.salary = salary;
        this.role = role;
        this.branchId = branchId;
    }

    public void populateStatement(PreparedStatement statement) throws Exception {
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, password);
        statement.setString(4, phone);
        statement.setDouble(5, salary);
        statement.setString(6, role.name());
        statement.setInt(7, branchId);
    }

    @Override
    public String toString() {
        return getCompleteName();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompleteName() {
        return name + " " + surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}