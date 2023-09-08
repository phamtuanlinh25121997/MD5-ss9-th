package ss5.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ss5.th.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
