package com.basecs101.controllers;

import com.basecs101.customexception.EmployeeNotFoundException;
import com.basecs101.model.Employee;
import com.basecs101.assemblers.EmployeeModelAssembler;
import com.basecs101.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@Qualifier("empCtrl")
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
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

        EntityModel<Employee> entityModel = employeeModelAssembler.toModel(repository.save(newEmployee));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }




    @PutMapping("/employees/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        Employee updatedEmployee = repository.findById(id) //
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                }) //
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });

        EntityModel<Employee> entityModel = employeeModelAssembler.toModel(updatedEmployee);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/employees/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
