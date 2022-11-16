package com.dvsuperiorProjeto.crudClient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperiorProjeto.crudClient.dto.ClientDto;
import com.dvsuperiorProjeto.crudClient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")

public class ClientResource {
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDto>> findaAll() {
		List<ClientDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
