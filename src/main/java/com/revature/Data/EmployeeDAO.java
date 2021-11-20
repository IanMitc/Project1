package com.revature.Data;

import com.revature.Classes.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployee(int id);

    Employee getEmployee(String username);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    List<Employee> getEmployees();

    void close();
}
