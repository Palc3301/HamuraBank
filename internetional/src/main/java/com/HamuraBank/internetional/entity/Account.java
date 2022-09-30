package com.HamuraBank.internetional.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue
	private long account;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private int agencia;

	@Column(length = 50)
	private double saldo;

}
