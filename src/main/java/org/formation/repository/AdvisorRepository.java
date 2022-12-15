package org.formation.repository;

import java.util.List;

import org.formation.entity.Advisor;
import org.formation.entity.ClientOnly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
	List<Advisor> findByAdvisors(String nom);
	List<ClientOnly> findByLastname(String lastname);
	List<ClientOnly> findByAge(int age);

}
