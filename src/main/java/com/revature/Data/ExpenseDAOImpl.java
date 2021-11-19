package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO{
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public ExpenseDAOImpl() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Expense> getExpenses() {
        return null;
    }

    @Override
    public List<Expense> getExpenses(Employee employee) {
        return null;
    }

    @Override
    public List<Expense> getDeclinedExpenses(Employee employee) {
        return null;
    }

    @Override
    public List<Expense> getPendingExpenses(Employee employee) {
        return null;
    }

    @Override
    public List<Expense> getPendingExpenses() {
        return null;
    }

    @Override
    public List<Expense> getExpensesProcessedBy(Manager manager) {
        return null;
    }

    @Override
    public Expense getExpense(int id) {
        return null;
    }

    @Override
    public void saveExpense(Expense expense) {

    }

    @Override
    public void updateExpense(Expense expense) {

    }

    @Override
    public void saveExpenses(List<Expense> expenses) {

    }

    @Override
    public void updateExpenses(List<Expense> expenses) {

    }
}
