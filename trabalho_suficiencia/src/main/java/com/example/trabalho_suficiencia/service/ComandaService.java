package com.example.trabalho_suficiencia.service;

import com.example.trabalho_suficiencia.entity.ComandaEntity;

import com.example.trabalho_suficiencia.repository.ComandaRepository;
import com.example.trabalho_suficiencia.dto.ComandaDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ComandaEntity buscarComandaPorId(Long id) {
        return comandaRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ComandaDTO> buscarComandas() {
        List<ComandaDTO> comandasDTO = new ArrayList<>();
        List<ComandaEntity> comandas = comandaRepository.findAll();
        comandas.forEach(comanda -> comandasDTO.add(new ComandaDTO(comanda)));
        return comandasDTO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ComandaEntity saveNewComanda(ComandaEntity comanda) {
        if(comanda.getIdUsuario() == null || comanda.getNomeUsuario() == null || comanda.getTelefoneUsuario() == null || comanda.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        return comandaRepository.save(comanda);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ComandaEntity alterarComanda(Long id, ComandaEntity comanda) {
        ComandaEntity comandaExistente = comandaRepository.findById(id).orElse(null);
        if (comandaExistente != null) {
            Hibernate.initialize(comandaExistente.getProdutos());
            comandaExistente.setProdutos(comanda.getProdutos());
            comandaRepository.save(comandaExistente);
        }
        return comandaExistente;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deletarComanda(Long id) {
        ComandaEntity comandaExistente = comandaRepository.findById(id).orElse(null);
        if (comandaExistente != null) {
            comandaRepository.delete(comandaExistente);
            return true;
        } else {
            return false;
        }
    }
}
