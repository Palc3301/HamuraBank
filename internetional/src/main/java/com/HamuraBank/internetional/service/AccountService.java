package com.HamuraBank.internetional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.HamuraBank.internetional.Sp.SimpleRest;
import com.HamuraBank.internetional.Sp.User;
import com.HamuraBank.internetional.entity.Account;
import com.HamuraBank.internetional.repository.AccountRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Validated
@Getter
@Setter
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	private final SimpleRest simpleRest = new SimpleRest();

	public List<Account> listAllAccounts() {
		return  (List<Account>) accountRepository.findAll();
	}

	public Account getAccountById(long id) {
		Account account = accountRepository.findById(id);
		if (accountRepository.findById(id) != null) {
			return account;
		} else
			return null;
	}

	public Account insertAccount(Account account) {
		if (!existsInWantedList(account.getName())) {
			return accountRepository.save(account);
		}
		return new Account();

	}

	public Account updateAccount(long id, Account accountUpdate) {
		Account account = this.accountRepository.findById(id);
		account.setName(accountUpdate.getName());
		account.setAgencia(accountUpdate.getAgencia());
		return accountRepository.save(account);
	}

	public void deleteAccount(long id) {
		accountRepository.deleteById(id);
	}

	private boolean existsInWantedList(String nome) {
		User[] users = simpleRest.listWantedPersons();
		boolean pessoaEncontrada = false;

		for (User user : users) {
			if (user.getName().equals(nome)) {
				pessoaEncontrada = true;
				break;
			}
		}
		return pessoaEncontrada;
	}

}
