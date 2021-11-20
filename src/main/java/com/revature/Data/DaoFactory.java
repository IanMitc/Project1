package com.revature.Data;

public class DaoFactory {
//    private static EmployeeDAO employeeDAO;
//    private static ExpenseDAO expenseDAO;

    public static EmployeeDAO getEmployeeDAO() {
//        if (employeeDAO == null){
//            employeeDAO = EmployeeDAOImpl.getInstance();
//        }
        return EmployeeDAOImpl.getInstance();
    }

    public static ExpenseDAO getExpenseDAO() {
//        if(expenseDAO == null){
//            expenseDAO = ExpenseDAOImpl.getInstance();
//        }
        return ExpenseDAOImpl.getInstance();
    }
}
