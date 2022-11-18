package com.dvsuperiorProjeto.crudClient.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findaById(@PathVariable Long id) {
		ClientDto dto = service.findaById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ClientDto> insert(@RequestBody ClientDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
