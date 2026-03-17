package com.ClienteProjeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ClienteProjeto.entities.Cliente;
import com.ClienteProjeto.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public Cliente salvar (Cliente cliente) {
		return repository.save(cliente);
	}
		public List <Cliente>Listar (){
			return repository.findAll();
			
		}
		
		public Cliente buscarPorId (Long id) {
			return repository.findById(id)
					.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		}
		 public Cliente atualizar (Long id, Cliente cliente) {
			 Cliente existente = buscarPorId(id);
			 
			 existente.setNome(cliente.getNome());
			 existente.setEmail(cliente.getEmail());
			 existente.setTelefone(cliente.getTelefone());
			 existente.setCidade(cliente.getCidade());
			 
			 return repository.save(existente);
		 }
		 
		 public void deletar (Long id) {
			 repository.deleteById(id);
		 }
	}


