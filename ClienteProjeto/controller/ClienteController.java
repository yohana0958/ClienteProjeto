package com.ClienteProjeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClienteProjeto.entities.Cliente;
import com.ClienteProjeto.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	 private final ClienteService service;

	    @PostMapping
	    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente) {
	        return ResponseEntity.status(201).body(service.salvar(cliente));
	    }

	    @GetMapping
	    public ResponseEntity<List<Cliente>> listar() {
	        return ResponseEntity.ok(service.Listar());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
	        return ResponseEntity.ok(service.buscarPorId(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
	        return ResponseEntity.ok(service.atualizar(id, cliente));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        service.deletar(id);
	        return ResponseEntity.noContent().build();
	    }

}
