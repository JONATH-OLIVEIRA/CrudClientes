package com.dvsuperiorProjeto.crudClient.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperiorProjeto.crudClient.entities.Client;



@RestController
@RequestMapping(value ="/clients")

public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>>findaAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client (1L,"Paulo","123",2.2, 1));
		return ResponseEntity.ok().body(list);
	}
}
