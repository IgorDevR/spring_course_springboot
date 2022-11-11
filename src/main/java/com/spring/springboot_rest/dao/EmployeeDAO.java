package com.spring.springboot_rest.dao;



import com.spring.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public  void saveEmployee(Employee employee);

    Employee getEmployee(long id);
    void deleteEmployee(long id);
}

