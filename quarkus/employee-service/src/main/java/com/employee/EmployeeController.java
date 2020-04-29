package com.employee;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @GET
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @POST
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PUT
    @Path("/{id}")
    public Employee updateEmployee(@PathParam("id") Long id, Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DELETE
    @Path("{id}")
    public void deleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
