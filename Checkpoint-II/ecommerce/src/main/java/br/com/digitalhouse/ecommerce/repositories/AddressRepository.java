package br.com.digitalhouse.ecommerce.repositories;

import br.com.digitalhouse.ecommerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}