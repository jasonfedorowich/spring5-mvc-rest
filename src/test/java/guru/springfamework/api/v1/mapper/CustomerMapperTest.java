package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    @Test
    public void customerMapperTest() {
        Customer customer = new Customer();
        customer.setFirstName("Jason");
        customer.setLastName("Fedorowich");

        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        assertEquals(customerDTO.getFirstName(), customer.getFirstName());
    }

}