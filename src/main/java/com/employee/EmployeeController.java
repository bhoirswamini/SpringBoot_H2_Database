package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
   EmployeeRepository employeeRepository;
    @RequestMapping("/getAllEmp")
    public List<Employee> getAllEmployees() {

        return employeeRepository.getAllEmployees();
    }

    @RequestMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return employeeRepository.getEmployeeById(id);
    }

    @RequestMapping("getEmployee/{name}")
    public Employee getEmployeeByName(@PathVariable String name){

        return employeeRepository.getEmployeeByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value="/addEmployees")
    public int addEmployee(@RequestParam("id") int id,@RequestParam("name") String name,
         @RequestParam("salary") float salary) {
         return employeeRepository.addEmployee(id, name, salary) ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteEmployees")
    public int deleteEmployee(@RequestParam("id") int id) {
        return employeeRepository.deleteEmployee(id);

    }

}
