package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExpenseDAOImplTest {
    EmployeeDAO employeeDAO;
    ExpenseDAO expenseDAO;

    public void beforeEach() {
        employeeDAO = DaoFactory.getEmployeeDAO();
        expenseDAO = DaoFactory.getExpenseDAO();

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
        int j = 1;
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(123.45, "Approved Memo " + j++, employee));
            expenseList.add(new Expense(643.21, "Approved Memo " + j++, employee));
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
        j = 1;
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(999.99, "Denied Memo " + j++, employee));
            expenseList.add(new Expense(1.25, "Denied Memo " + j++, employee));
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
        j = 1;
        for (Employee employee : employeeList) {
            expenseList.add(new Expense(999.99, "Pending Memo " + j++, employee));
            expenseList.add(new Expense(1.25, "Pending Memo " + j++, employee));
        }

        for (Expense expense : expenseList) {
            expenseDAO.saveExpense(expense);
        }
    }

    public void afterEach(){
        employeeDAO.close();
        expenseDAO.close();
    }

    @Test
    public void getExpenses() {
        beforeEach();

        List<Expense> expenseListTest = expenseDAO.getExpenses();

        Assert.assertEquals("Approved Memo 1", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Approved Memo 2", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void GetExpensesByEmployee() {
        beforeEach();

        Employee employee = employeeDAO.getEmployee("bob");
        List<Expense> expenseListTest = expenseDAO.getExpenses(employee);

        Assert.assertEquals("Approved Memo 9", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Approved Memo 10", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void getDeclinedExpenses() {
        beforeEach();

        Employee employee = employeeDAO.getEmployee("bob");
        List<Expense> expenseListTest = expenseDAO.getDeclinedExpenses(employee);

        Assert.assertEquals("Denied Memo 9", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Denied Memo 10", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void getPendingExpenses() {
        beforeEach();

        List<Expense> expenseListTest = expenseDAO.getPendingExpenses();

        Assert.assertEquals("Pending Memo 1", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Pending Memo 2", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void GetPendingExpensesByEmployee() {
        beforeEach();

        Employee employee = employeeDAO.getEmployee("bob");
        List<Expense> expenseListTest = expenseDAO.getPendingExpenses(employee);

        Assert.assertEquals("Pending Memo 9", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Pending Memo 10", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void getExpensesProcessedBy() {
        beforeEach();

        Manager manager = (Manager) employeeDAO.getEmployee("emm");
        List<Expense> expenseListTest = expenseDAO.getExpensesProcessedBy(manager);

        Assert.assertEquals("Approved Memo 8", expenseListTest.get(0).getMemo());
        Assert.assertEquals("Approved Memo 9", expenseListTest.get(1).getMemo());

        afterEach();
    }

    @Test
    public void getExpense() {
        beforeEach();

        Expense expense = expenseDAO.getExpense(30);

        assertEquals("Denied Memo 3", expense.getMemo());

        afterEach();
    }

    @Test
    public void saveExpense() {
        beforeEach();

        Employee employee = employeeDAO.getEmployee(4);

        Expense expense = new Expense(123, "Test Expense", employee);
        expenseDAO.saveExpense(expense);

        Expense expenseTest = expenseDAO.getExpense(expense.getId());

        assertEquals("Test Expense", expenseTest.getMemo());

        afterEach();
    }

    @Test
    public void updateExpense() {
        beforeEach();

        Employee employee = employeeDAO.getEmployee(4);

        Expense expense = new Expense(123, "Test Expense", employee);
        expenseDAO.saveExpense(expense);

        expense.setMemo("Test Update Expense");
        expenseDAO.updateExpense(expense);

        Expense expenseTest = expenseDAO.getExpense(expense.getId());

        assertEquals("Test Update Expense", expenseTest.getMemo());

        afterEach();
    }
}