package com.dummy.demo;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEmployee(Employee employee) {
        String query = "INSERT INTO Employee ( id,name, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getSalary());


    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET name = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(query, employee.getName(), employee.getSalary(), employee.getId());


    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

//    public Employee getEmployeeById(int id) {
//        String query = "SELECT * FROM employee WHERE id = ?";
//        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> {
//            int empId = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            double salary = resultSet.getDouble("salary");
//            return new Employee(empId, name, salary);
//        });
    }

