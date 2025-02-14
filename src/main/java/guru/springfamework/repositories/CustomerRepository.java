package guru.springfamework.repositories;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByFirstName(String firstName);

}
