package org.formation.repository;

import org.formation.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("select c from Account c where c.client.code=:x")
	public Page<Account> listAccount(@Param("x")Long codeCte,Pageable Page);
}
