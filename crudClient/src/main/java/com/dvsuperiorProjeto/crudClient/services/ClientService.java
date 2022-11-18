package com.dvsuperiorProjeto.crudClient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperiorProjeto.crudClient.dto.ClientDto;
import com.dvsuperiorProjeto.crudClient.entities.Client;
import com.dvsuperiorProjeto.crudClient.repositories.ClientRepository;
import com.dvsuperiorProjeto.crudClient.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public List<ClientDto> findAll() {
		
		List<Client> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());

	}
	@Transactional
	public ClientDto findaById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()-> new EntityNotFoundException("Nao Encontrado"));
		return new ClientDto(entity);
	}
	public ClientDto insert(ClientDto dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);
		return new ClientDto(entity);
	}

}
