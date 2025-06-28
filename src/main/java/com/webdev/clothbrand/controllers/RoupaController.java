package com.webdev.clothbrand.controllers;

import com.webdev.clothbrand.dto.RoupaDTO;
import com.webdev.clothbrand.model.Roupa;
import com.webdev.clothbrand.model.TipoRoupa;
import com.webdev.clothbrand.repository.RoupaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roupas")
public class RoupaController {

    @Autowired
    private RoupaRepository roupaRepository;

    @GetMapping
    public List<Roupa> listarRoupas() {
        return roupaRepository.findAll();
    }

    @PostMapping
    public Roupa adicionarRoupa(@RequestBody RoupaDTO dto) {
        Roupa roupa = new Roupa();
        roupa.setNome(dto.getNome());
        roupa.setTamanho(dto.getTamanho());
        roupa.setPreco(dto.getPreco());
        roupa.setTipo(TipoRoupa.fromId(dto.getTipoId())); // converte int para enum
        return roupaRepository.save(roupa);
    }

    @GetMapping("/{id}")
    public Optional<Roupa> buscarPorId(@PathVariable Long id) {
        return roupaRepository.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
    	if (!roupaRepository.existsById(id)) {
    		throw new RuntimeException("Produto não encontrado");
    	}
    	roupaRepository.deleteById(id);
    }
}
