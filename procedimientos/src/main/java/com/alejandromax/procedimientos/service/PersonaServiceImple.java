package com.alejandromax.procedimientos.service;

import com.alejandromax.procedimientos.entity.Persona;
import com.alejandromax.procedimientos.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImple implements PersonaService{

    private final PersonaRepository repo;

    @Override
    public List<Persona> listar() {
        return repo.listar();
    }

    @Override
    public Persona buscarPorId(Long id) {
        return repo.buscarPorId(id).orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
    }

    @Transactional
    @Override
    public void crear(Persona persona) {
        repo.crear(persona);
    }
}