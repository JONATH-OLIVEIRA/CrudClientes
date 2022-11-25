package com.dvsuperiorProjeto.crudClient.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = ("tb_client"))
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String cpf;
	private Double income;
	private Integer children;

	//@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	//private Instant createdAt;

	//@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	//private Instant updatedAt;

	//public Instant getCreatedAt() {
	//	return createdAt;
	//}

	//public Instant getUpdatedAt() {
	//	return updatedAt;
	//}

	public Client() {

	}

	public Client(long id, String name, String cpf, Double income, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
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

	@Override
	public int hashCode() {
		return Objects.hash(children, cpf, id, income, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(children, other.children) && Objects.equals(cpf, other.cpf) && id == other.id
				&& Objects.equals(income, other.income) && Objects.equals(name, other.name);
	}

	//@PrePersist
	//public void prePersint() {
	//	createdAt = Instant.now();
	//}

	//@PreUpdate
	//public void preUpdate() {
	//	updatedAt = Instant.now();
	//}

}
