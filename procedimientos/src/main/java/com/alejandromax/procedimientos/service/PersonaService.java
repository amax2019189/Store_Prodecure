package com.alejandromax.procedimientos.service;

import com.alejandromax.procedimientos.entity.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> listar();
    Persona buscarPorId(Long id);
    void crear(Persona persona);
}