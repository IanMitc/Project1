package com.revature.Data;

import com.revature.Classes.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

public class EmployeeDAOImplTest {
    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() throws Exception {
        employeeDAO = DaoFactory.getEmployeeDAO();
    }

    @Test
    @Transactional
    public void saveEmployee() {
        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        Employee testEmployee = employeeDAO.getEmployee(1);

        Assert.assertEquals(employee.getUsername(), testEmployee.getUsername());
    }

    @Test
    @Transactional
    public void updateEmployee() {
        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        employee.setUsername("aslkdfjklsdjf");
        employeeDAO.updateEmployee(employee);

        Employee testEmployee = employeeDAO.getEmployee(1);

        Assert.assertEquals(employee.getUsername(), testEmployee.getUsername());
    }
}