package guru.springfamework.api.v1.controllers;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CategoryListDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CategoryService;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getCustomers(){
        return new ResponseEntity<>(new CustomerListDTO(customerService.getCustomers()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String name){
        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.OK);
    }

    @PutMapping({"id"})
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        return new ResponseEntity<>(customerService.saveCustomerByDTO(id, customerDTO), HttpStatus.OK);
    }
    @PatchMapping({"id"})
    public ResponseEntity<CustomerDTO> patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        return new ResponseEntity<>(customerService.patchCustomer(id, customerDTO), HttpStatus.OK);
    }

    @DeleteMapping({"id"})
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
