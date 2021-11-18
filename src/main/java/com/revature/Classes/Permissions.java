package com.revature.Classes;

public class Permissions {
    private static Permissions permissions;
    private static Employee loggedInEmployee;

    private Permissions() {
    }

    public static Permissions getPermissions() {
        if (permissions == null) {
            permissions = new Permissions();
        }
        return permissions;
    }

    public boolean login(Employee employee, String attempted_password) {
        if (employee.checkPassword(attempted_password)) {
            loggedInEmployee = employee;
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        loggedInEmployee = null;
        permissions = null;
    }

    public UserRole getCurrentRole() {
        return loggedInEmployee.getUserRole();
    }

    public enum UserRole {
        EMPLOYEE,
        MANAGER
    }
}
