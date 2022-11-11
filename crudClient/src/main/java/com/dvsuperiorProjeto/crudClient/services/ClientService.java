package com.dvsuperiorProjeto.crudClient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperiorProjeto.crudClient.entities.Client;
import com.dvsuperiorProjeto.crudClient.repositories.ClientRepository;

import java.util.*;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository; 
	
	public List<Client> findAll(){
		
		return repository.findAll();
	}

}
