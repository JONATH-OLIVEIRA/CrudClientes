package com.dvsuperiorProjeto.crudClient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvsuperiorProjeto.crudClient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
