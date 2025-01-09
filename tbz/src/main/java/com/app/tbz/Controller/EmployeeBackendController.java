package com.app.tbz.Controller;

import com.app.tbz.Exception.EmployeeNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Request.EmployeeRequest;
import com.app.tbz.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeBackendController {

    private EmployeeService employeeService;

    public EmployeeBackendController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/employeemanagement")
    public String employeemanagementPage() {
        return "employeemanagement";
    }

    @GetMapping("/createEmployee")
    public String addEmployeeForm() {
        return "createEmployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(Model model, @ModelAttribute EmployeeRequest employeeRequest) throws InsertCannotBeDoneException {
        model.addAttribute("createEmployee", employeeService.createEmployee(employeeRequest));
        return "redirect:/getAllEmployees";
    }

    @GetMapping("/getAllEmployees")
    public String listEmployees(Model model) {
        model.addAttribute("getAllEmployees", employeeService.getAllEmployees());
        return "getAllEmployees";
    }

    @GetMapping("/editEmployee/{e_id}")
    public String getEmployeeById(Model model, @PathVariable("e_id") Integer e_id) throws EmployeeNotFoundException {
        model.addAttribute("employee", employeeService.getEmployee(e_id));
        return "updateEmployee";
    }

    @PostMapping("/updateEmployee/{e_id}")
    public String updateEmployee(@PathVariable("e_id") Integer e_id, @ModelAttribute("employee") EmployeeRequest employeeRequest) throws UpdateCannotBeDoneException, EmployeeNotFoundException {
        employeeService.updateEmployee(e_id, employeeRequest);
        return "redirect:/getAllEmployees";
    }
}
