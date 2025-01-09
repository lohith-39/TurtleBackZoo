package com.app.tbz.Controller;

import com.app.tbz.DTO.EmployeeDTO;
import com.app.tbz.Entity.Employee;
import com.app.tbz.Exception.EmployeeNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Request.EmployeeRequest;
import com.app.tbz.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeRequest request) throws InsertCannotBeDoneException {
        EmployeeDTO response = employeeService.createEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{e_id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer e_id) throws EmployeeNotFoundException {
        EmployeeDTO response = employeeService.getEmployee(e_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{e_id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Integer e_id, @RequestBody EmployeeRequest request) throws EmployeeNotFoundException, UpdateCannotBeDoneException {
        EmployeeDTO response = employeeService.updateEmployee(e_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAnimals(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);

    }
}
