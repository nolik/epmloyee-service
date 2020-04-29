package com.employee;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EmployeeService {

    public List<Employee> getEmployees() {
        return Employee.listAll();
    }

    public Employee getEmployee(Long id) {
        return Employee.findById(id);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        employee.persist();
        return employee;
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = Employee.findById(id);
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.persist();

        return employeeToUpdate;
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee.findByIdOptional(id).ifPresent(PanacheEntityBase::delete);
    }

    public List<Employee> getEmployeesByDepartment(Long id) {
        return Employee.list("department_id", id);
    }
}
