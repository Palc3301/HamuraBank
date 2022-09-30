package com.HamuraBank.internetional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HamuraBank.internetional.entity.Account;
import com.HamuraBank.internetional.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<List<Account>> listAllAccount() {

		ResponseEntity<List<Account>> checkList;
		List<Account> allAccounts = accountService.listAllAccounts();

		if (allAccounts != null && allAccounts.isEmpty()) {
			checkList = new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		} else {
			checkList = new ResponseEntity<List<Account>>(allAccounts, HttpStatus.OK);
		}
		return checkList;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable long id) {
		Account account = accountService.getAccountById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PostMapping("/createAccount")
	public ResponseEntity<Account> insertAccount(@RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.insertAccount(account), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account accountUpdated) {
		Account account = accountService.updateAccount(id, accountUpdated);
		return new ResponseEntity<Account>(account, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable long id) {
		accountService.deleteAccount(id);

		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}

}
