package org.formation.repository;

import java.util.List;
import java.util.Optional;

import org.formation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{

    @Override
    Optional<Client> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
