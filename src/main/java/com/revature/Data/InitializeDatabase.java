package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Manager;

import java.util.ArrayList;
import java.util.List;

public class InitializeDatabase {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Peter Linz", "ernie", "password"));
        employeeList.add(new Manager("Eric Jacobson", "bert","password"));

        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();

        for (Employee employee : employeeList){
            employeeDAO.saveEmployee(employee);
        }


    }
}
