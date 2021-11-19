package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Manager;
import com.revature.Classes.Permissions;

import java.util.ArrayList;
import java.util.List;

public class InitializeDatabase {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Peter Linz", "ernie", "password"));
        employeeList.add(new Manager("Eric Jacobson", "bert","password"));
        employeeList.add(new Employee("John Smith", "jon", "jon"));
        employeeList.add(new Employee("Ann Jones", "ann", "ann"));
        employeeList.add(new Employee("Bob Brown", "bob", "bob"));
        employeeList.add(new Employee("Carly Baker", "car", "car"));
        employeeList.add(new Employee("Dave Toomes", "dave", "dave"));
        employeeList.add(new Manager("Emma Vexal", "emm", "emm"));
        employeeList.add(new Manager("Fred Kasper", "kas", "kas"));

        for (Employee employee : employeeList){
            employeeDAO.saveEmployee(employee);
        }


    }
}
