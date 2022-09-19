package br.com.digitalhouse.ecommerce.repositories;

import br.com.digitalhouse.ecommerce.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}