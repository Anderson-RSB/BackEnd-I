package br.com.digitalhouse.ecommerce.repositories;

import br.com.digitalhouse.ecommerce.entities.Harmony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarmonyRepository extends JpaRepository<Harmony, Integer> {
}