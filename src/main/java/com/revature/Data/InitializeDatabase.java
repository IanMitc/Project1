package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;

import java.util.ArrayList;
import java.util.List;

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

        expenseList.add(new Expense(123.45, "Southbound Uber", employeeDAO.getEmployee(1)));
        expenseList.add(new Expense(643.21, "Duck Food", employeeDAO.getEmployee(1)));
        expenseList.add(new Expense(5421.23, "Hired Howard to look for Percy", employeeDAO.getEmployee(1)));
        expenseList.add(new Expense(1.25, "Duck Burial", employeeDAO.getEmployee(8)));
        expenseList.add(new Expense(15.23, "Cheese and quackers", employeeDAO.getEmployee(4)));
        expenseList.add(new Expense(47.51, "Pâté", employeeDAO.getEmployee(8)));
        expenseList.add(new Expense(999.99, "New Leather Jacket", employeeDAO.getEmployee(3)));
        expenseList.add(new Expense(772.33, "Locksmith for Maison du Canard", employeeDAO.getEmployee(8)));
        expenseList.add(new Expense(152.39, "Lunch with Launchpad", employeeDAO.getEmployee(1)));
        expenseList.add(new Expense(1544.22, "First Aid after getting a ride home with Launchpad", employeeDAO.getEmployee(1)));


        expenseList.get(0).approveExpense((Manager) employeeDAO.getEmployee(2), "When you gotta go, you gotta go.");
        expenseList.get(1).approveExpense((Manager) employeeDAO.getEmployee(8), "Hopefully you actually fed it to the ducklings this time.");
        expenseList.get(2).denyExpense((Manager) employeeDAO.getEmployee(9), "Percy can take care of himself.");
//        expenseList.get(3).approveExpense((Manager) employeeDAO.getEmployee(9), "Dear God, not Jonty!!!");
        expenseList.get(4).approveExpense((Manager) employeeDAO.getEmployee(8), "Man, that was a great party.");
//        expenseList.get(5).denyExpense((Manager) employeeDAO.getEmployee(2), "What in the world is wrong with you!");
        expenseList.get(6).denyExpense((Manager) employeeDAO.getEmployee(2), "Umm... NO!");
        expenseList.get(7).denyExpense((Manager) employeeDAO.getEmployee(8), "You should of had Drake let you in.");

        for (Expense expense : expenseList) {
            expenseDAO.saveExpense(expense);
        }

//        for (int i = 0; i < expenseList.size(); i++) {
//            if (i <= expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(2), "Umm... NO!");
//            } else if (i > expenseList.size() / 3 && i <= 2 * expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(8), "Umm... NO!");
//            } else if (i > 2 * expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(9), "Umm... NO!");
//            }
//        }
//
//        for (Expense expense : expenseList) {
//            expenseDAO.saveExpense(expense);
//        }
//
//        expenseList.clear();
//
//        //Create expenses to be Denied
//        for (Employee employee : employeeList) {
//            expenseList.add(new Expense(999.99, "New Leather Jacket", employee));
//            expenseList.add(new Expense(1.25, "Duck Burial", employee));
//        }
//
//        for (int i = 0; i < expenseList.size(); i++) {
//            if (i <= expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(2), "Umm... NO!");
//            } else if (i > expenseList.size() / 3 && i <= 2 * expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(8), "Umm... NO!");
//            } else if (i > 2 * expenseList.size() / 3) {
//                expenseList.get(i).denyExpense((Manager) employeeDAO.getEmployee(9), "Umm... NO!");
//            }
//        }
//
//        for (Expense expense : expenseList) {
//            expenseDAO.saveExpense(expense);
//        }
//
//        expenseList.clear();
//
//        //create expenses to leave as pending
//        for (Employee employee : employeeList) {
//            expenseList.add(new Expense(15.23, "Cheese and quackers", employee));
//            expenseList.add(new Expense(772.33, "Locksmith for Maison du Canard", employee));
//        }
//
//        for (Expense expense : expenseList) {
//            expenseDAO.saveExpense(expense);
//        }
    }
}
