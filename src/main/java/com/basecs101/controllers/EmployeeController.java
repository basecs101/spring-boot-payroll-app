package com.basecs101.controllers;

import com.basecs101.customexception.EmployeeNotFoundException;
import com.basecs101.model.Employee;
import com.basecs101.model.EmployeeModelAssembler;
import com.basecs101.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController("empCtrl")
public class EmployeeController {

    private final EmployeeRepository repository;

    private final EmployeeModelAssembler employeeModelAssembler;

    EmployeeController(EmployeeRepository repository, EmployeeModelAssembler employeeModelAssembler) {
        this.employeeModelAssembler = employeeModelAssembler;
        log.info("EmployeeRepository bean : " + repository.toString());
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]

    @GetMapping("/employees")
    public CollectionModel<EntityModel<Employee>> all() {

        List<EntityModel<Employee>> employees = (List<EntityModel<Employee>>) repository.findAll()
                .stream()
                .map(employeeModelAssembler::toModel)
                .toList();

        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    // Single item

//    @RequestMapping(method = {RequestMethod.GET}, path = "/employees/{id}")
    @GetMapping("/employees/{id}")

    public EntityModel<Employee> one(@PathVariable(name = "id", required = true) Long id) {
        Employee employee = repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));

        return employeeModelAssembler.toModel(employee);
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }




    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
