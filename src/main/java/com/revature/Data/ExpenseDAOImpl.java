package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {
    private static ExpenseDAOImpl expenseDAO;
    private final Configuration configuration;
    private final SessionFactory sessionFactory;

    private ExpenseDAOImpl() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static ExpenseDAOImpl getInstance() {
        if (expenseDAO == null) {
            expenseDAO = new ExpenseDAOImpl();
        }
        return expenseDAO;
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
        CriteriaQuery<Expense> allEmployee = cq.select(rootEntry)
                .where(
                        rootEntry.get("initiatedBy").in(employee.getId())
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployee);
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
        CriteriaQuery<Expense> allEmployeeDeclined = cq.select(rootEntry)
                .where(
                        cb.and(
                                rootEntry.get("initiatedBy").in(employee.getId()),
                                rootEntry.get("approved").in(false),
                                rootEntry.get("pending").in(false)
                        )
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeeDeclined);
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
        CriteriaQuery<Expense> allEmployeePending = cq.select(rootEntry)
                .where(
                        cb.and(
                                rootEntry.get("initiatedBy").in(employee.getId()),
                                rootEntry.get("pending").in(true)
                        )
                );

        TypedQuery<Expense> allQuery = session.createQuery(allEmployeePending);
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
        CriteriaQuery<Expense> allPending = cq.select(rootEntry)
                .where(
                        rootEntry.get("pending").in(true)
                );

        TypedQuery<Expense> allQuery = session.createQuery(allPending);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public List<Expense> getExpensesProcessedBy(Manager manager) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> allManagerProcessed = cq.select(rootEntry)
                .where(
                        rootEntry.get("processedBy").in(manager.getId())
                );

        TypedQuery<Expense> allQuery = session.createQuery(allManagerProcessed);
        List<Expense> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public Expense getExpense(int id) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> rootEntry = cq.from(Expense.class);
        CriteriaQuery<Expense> expense = cq.select(rootEntry)
                .where(
                        rootEntry.get("id").in(id)
                );

        TypedQuery<Expense> allQuery = session.createQuery(expense);
        Expense result = allQuery.getSingleResult();

        session.close();
        return result;
    }

    @Override
    public void saveExpense(Expense expense) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(expense);

        transaction.commit();
        session.close();
    }

    @Override
    public void updateExpense(Expense expense) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(expense);

        transaction.commit();
        session.close();
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Expense expense : expenses) {
            session.save(expense);
        }

        transaction.commit();
        session.close();
    }

    @Override
    public void updateExpenses(List<Expense> expenses) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Expense expense : expenses) {
            session.update(expense);
        }

        transaction.commit();
        session.close();
    }

    @Override
    public void close() {
        expenseDAO = null;
    }
}
