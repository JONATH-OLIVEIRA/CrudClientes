package com.dvsuperiorProjeto.crudClient.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.dvsuperiorProjeto.crudClient.entities.Client;

public class ClientDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String cpf;
	private Double income;
	private Integer children;
	private LocalDate birthDate;

	public ClientDto() {

	}

	public ClientDto(long id, String name, String cpf, Double income, Integer children, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
		this.birthDate = birthDate;
	}

	public ClientDto(Client entity) {

		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.children = entity.getChildren();
		this.birthDate = entity.getBirthDate();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
