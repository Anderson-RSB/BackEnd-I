package br.com.digitalhouse.ecommerce.repositories;

import br.com.digitalhouse.ecommerce.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}