package com.employee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/departments")
@Produces("application/json")
public class DepartmentController {

    @Inject
    EmployeeService employeeService;

    @GET
    @Path("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathParam("id") Long id) {
        return employeeService.getEmployeesByDepartment(id);
    }
}
