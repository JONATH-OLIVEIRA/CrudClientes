package com.dvsuperiorProjeto.crudClient.services;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperiorProjeto.crudClient.dto.ClientDto;
import com.dvsuperiorProjeto.crudClient.entities.Client;
import com.dvsuperiorProjeto.crudClient.repositories.ClientRepository;
import com.dvsuperiorProjeto.crudClient.services.exceptions.DatabaseException;
import com.dvsuperiorProjeto.crudClient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDto> findAll() {

		List<Client> list = repository.findAll();

		return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public ClientDto findaById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Nao Encontrado"));
		return new ClientDto(entity);
	}

	@Transactional(readOnly = true)
	public ClientDto insert(ClientDto dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);
		return new ClientDto(entity);
	}

	@Transactional(readOnly = true)
	public ClientDto update(ClientDto dto, Long id) {
		try {
			Client entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setChildren(dto.getChildren());
			entity = repository.save(entity);
			return new ClientDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id nao encontrado" + " " + id);
		}
		
		

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id nao encontrado" + " " +id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violacao de Integridade");			
		}
		
	}

}
