package org.formation.repository;

import java.util.List;

import org.formation.entity.ClientOnly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOnlyRepository extends JpaRepository<ClientOnly, Long>{
	
	List<ClientOnly> findByLastname(String lastname);
	List<ClientOnly> findByAge(int age);

	
}
