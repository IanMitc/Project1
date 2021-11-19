package com.revature.Data;

import com.revature.Classes.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }
}
