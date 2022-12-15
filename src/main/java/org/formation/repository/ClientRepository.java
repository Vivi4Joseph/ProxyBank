package org.formation.repository;

import java.util.List;

import org.formation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findByNom(String nom);
	List<Client> findByLogin(String login);

	
}
