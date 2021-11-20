package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Manager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplTest {

    @Test
    public void saveEmployee() {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        Employee testEmployee = employeeDAO.getEmployee(1);

        Assert.assertEquals(employee.getUsername(), testEmployee.getUsername());
        employeeDAO.close();
    }

    @Test
    public void updateEmployee() {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        employee.setUsername("aslkdfjklsdjf");
        employeeDAO.updateEmployee(employee);

        Employee employeeTest = employeeDAO.getEmployee(1);

        Assert.assertEquals(employee.getUsername(), employeeTest.getUsername());
        employeeDAO.close();
    }

    @Test
    public void getEmployeeById() {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        Employee employeeTest = employeeDAO.getEmployee(employee.getId());

        Assert.assertEquals(employee.getName(), employeeTest.getName());
        employeeDAO.close();
    }

    @Test
    public void GetEmployeeByUsername() {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        Employee employee = new Employee("Peter Linz", "ernie", "password");
        employeeDAO.saveEmployee(employee);

        Employee employeeTest = employeeDAO.getEmployee(employee.getUsername());

        Assert.assertEquals(employee.getName(), employeeTest.getName());
        employeeDAO.close();
    }

    @Test
    public void getEmployees() {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Peter Linz", "ernie", "password"));
        employeeList.add(new Manager("Eric Jacobson", "bert", "password"));

        for (Employee employee : employeeList) {
            employeeDAO.saveEmployee(employee);
        }

        List<Employee> employeeListTest = employeeDAO.getEmployees();

        Assert.assertEquals(employeeList.get(0).getUsername(), employeeListTest.get(0).getUsername());
        Assert.assertEquals(employeeList.get(1).getUsername(), employeeListTest.get(1).getUsername());
        employeeDAO.close();
    }
}