package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public ExpenseDAOImpl() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Expense> getExpenses() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> all = cq.select(rootEntry);

        TypedQuery<Expense> allQuery = session.createQuery(all);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public List<Expense> getExpenses(Employee employee) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> allEmployeeTransactions = cq.select(rootEntry)
                .where(
                        rootEntry.get("initiatedBy").in(employee.getId())
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeeTransactions);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public List<Expense> getDeclinedExpenses(Employee employee) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> allEmployeeDeclinedTransactions = cq.select(rootEntry)
                .where(
                        cb.and(
                                rootEntry.get("initiatedBy").in(employee.getId()),
                                rootEntry.get("approved").in(false),
                                rootEntry.get("pending").in(false)
                        )
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeeDeclinedTransactions);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public List<Expense> getPendingExpenses(Employee employee) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> allEmployeeDeclinedTransactions = cq.select(rootEntry)
                .where(
                        cb.and(
                                rootEntry.get("initiatedBy").in(employee.getId()),
                                rootEntry.get("pending").in(true)
                        )
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeeDeclinedTransactions);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public List<Expense> getPendingExpenses() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> allEmployeeDeclinedTransactions = cq.select(rootEntry)
                .where(
                        rootEntry.get("pending").in(true)
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeeDeclinedTransactions);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
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
