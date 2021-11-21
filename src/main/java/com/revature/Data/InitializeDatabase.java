package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;

import java.util.ArrayList;
import java.util.List;
/*
public class InitializeDatabase {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
        ExpenseDAO expenseDAO = DaoFactory.getExpenseDAO();

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Peter Linz", "ernie", "password"));
        employeeList.add(new Manager("Eric Jacobson", "bert", "password"));
        employeeList.add(new Employee("John Smith", "jon", "jon"));
        employeeList.add(new Employee("Ann Jones", "ann", "ann"));
        employeeList.add(new Employee("Bob Brown", "bob", "bob"));
        employeeList.add(new Employee("Carly Baker", "car", "car"));
        employeeList.add(new Employee("Dave Toomes", "dave", "dave"));
        employeeList.add(new Manager("Emma Vexal", "emm", "emm"));
        employeeList.add(new Manager("Fred Kasper", "kas", "kas"));

        for (Employee employee : employeeList) {
            employeeDAO.saveEmployee(employee);
        }

        List<Expense> expenseList = new ArrayList<>();

        //create expenses to be approved
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(123.45, "For Stuff", employee));
            expenseList.add(new Expense(643.21, "Duck Food", employee));
        }

        for (int i = 0; i < expenseList.size(); i++) {
            if (i <= expenseList.size() / 3) {
                expenseList.get(i).approveExpense((Manager) employeeDAO.getEmployee(2), "Sure thing");
            } else if (i > expenseList.size() / 3 && i <= 2 * expenseList.size() / 3) {
                expenseList.get(i).approveExpense((Manager) employeeDAO.getEmployee(8), "Sure thing");
            } else if (i > 2 * expenseList.size() / 3) {
                expenseList.get(i).approveExpense((Manager) employeeDAO.getEmployee(9), "Sure thing");
            }
        }

        for (Expense expense : expenseList) {
            expenseDAO.saveExpense(expense);
        }

        expenseList.clear();

        //Create expenses to be Denied
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(999.99, "New Leather Jacket", employee));
            expenseList.add(new Expense(1.25, "Duck Burial", employee));
        }

        for (int i = 0; i < expenseList.size(); i++) {
            if (i <= expenseList.size() / 3) {
                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(2), "Umm... NO!");
            } else if (i > expenseList.size() / 3 && i <= 2 * expenseList.size() / 3) {
                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(8), "Umm... NO!");
            } else if (i > 2 * expenseList.size() / 3) {
                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(9), "Umm... NO!");
            }
        }

        for (Expense expense : expenseList) {
            expenseDAO.saveExpense(expense);
        }

        expenseList.clear();

        //create expenses to leave as pending
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(999.99, "New Leather Jacket", employee));
            expenseList.add(new Expense(1.25, "Duck Burial", employee));
        }

        for (Expense expense : expenseList) {
            expenseDAO.saveExpense(expense);
        }
    }
}*/
