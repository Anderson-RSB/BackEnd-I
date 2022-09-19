package br.com.digitalhouse.ecommerce.repositories;

import br.com.digitalhouse.ecommerce.entities.Grape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends JpaRepository<Grape, Integer> {
}