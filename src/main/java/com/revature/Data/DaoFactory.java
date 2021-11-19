package com.revature.Data;

public class DaoFactory {
    private static EmployeeDAO employeeDAO;
    private static ExpenseDAO expenseDAO;

    public static EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null){
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    public static ExpenseDAO getExpenseDAO() {
        if(expenseDAO == null){
            expenseDAO = new ExpenseDAOImpl();
        }
        return expenseDAO;
    }
}
