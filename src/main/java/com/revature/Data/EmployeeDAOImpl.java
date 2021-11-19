package com.revature.Data;

import com.revature.Classes.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAOImpl implements EmployeeDAO{
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public EmployeeDAOImpl() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
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
}
