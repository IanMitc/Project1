package com.revature.Data;

import com.revature.Classes.Employee;

public interface EmployeeDAO {
    Employee getEmployee(int id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);

}
