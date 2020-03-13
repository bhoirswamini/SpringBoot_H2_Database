package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    JdbcTemplate template;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = template.query("select id, name, salary from employee", (result, rowNum) -> new Employee(result.getInt("id"),
                result.getString("name"), result.getFloat("salary")));
        return employees;
    }

    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
        Employee employee = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Employee.class));
        return  employee;
    }

    public int addEmployee(int id,String name,float salary){
        String query = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
        return template.update(query,id,name,salary);
    }

    public int deleteEmployee(int id) {
        String query = "DELETE FROM EMPLOYEE WHERE ID=?";
        return template.update(query,id);
    }

    public Employee getEmployeeByName(String name) {
        String query = "SELECT * FROM EMPLOYEE WHERE NAME=?";
        Employee employee = template.queryForObject(query, new Object[]{name},new BeanPropertyRowMapper<>(Employee.class));
        return employee;
    }

}
