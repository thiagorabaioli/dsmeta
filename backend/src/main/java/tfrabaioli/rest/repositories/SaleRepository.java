package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.entity.Sale;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
