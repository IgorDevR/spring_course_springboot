package com.spring.springboot_rest.dao;


import com.spring.springboot_rest.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;


    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = session.createQuery("from Employee"
//                        , Employee.class)
//                .getResultList();

        Query query = entityManager.createQuery(("from Employee"));
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }


    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);

//        session.saveOrUpdate(employee);
      Employee newEmployee = entityManager.merge(employee);
      employee.setId(newEmployee.getId());

    }


    public Employee getEmployee(long id) {

//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, (long) id);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }


    public void deleteEmployee(long id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where  id =:employeeId");
//        query.setParameter("employeeId", (long) id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee " +
                "where  id =:employeeId");
        query.setParameter("employeeId", (long) id);
        query.executeUpdate();
    }
}
