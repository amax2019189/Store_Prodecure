package com.alejandromax.procedimientos.repository;

import com.alejandromax.procedimientos.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    List<Persona> listar();
    Optional<Persona> buscarPorId(Long id);
    void crear(Persona persona);
    int actualizar(Long id, Persona persona);
    int eliminar(Long id);
}