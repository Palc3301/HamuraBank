package com.HamuraBank.internetional.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HamuraBank.internetional.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findById(long id);

}
