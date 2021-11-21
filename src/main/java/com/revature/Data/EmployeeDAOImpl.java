package com.revature.Data;

import com.revature.Classes.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static EmployeeDAOImpl employeeDAO;
    private final Configuration configuration;
    private final SessionFactory sessionFactory;

    private EmployeeDAOImpl() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static EmployeeDAOImpl getInstance() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        transaction.commit();
        session.close();

        return employee;
    }

    @Override
    public Employee getEmployee(String username) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> rootEntry = cq.from(Employee.class);
        CriteriaQuery<Employee> allEmployee = cq.select(rootEntry)
                .where(
                        rootEntry.get("username").in(username)
                );

        TypedQuery<Employee> allQuery = session.createQuery(allEmployee);

        Employee result = null;
        try {
            result = allQuery.getSingleResult();
        } catch (NoResultException noResultException) {
            System.out.println(noResultException.getMessage());
        }

        session.close();
        return result;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
        session.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(employee);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> rootEntry = cq.from(Employee.class);
        CriteriaQuery<Employee> all = cq.select(rootEntry);

        TypedQuery<Employee> allQuery = session.createQuery(all);
        List<Employee> results = allQuery.getResultList();

        session.close();
        return results;
    }

    @Override
    public void close() {
        employeeDAO = null;
    }
}
