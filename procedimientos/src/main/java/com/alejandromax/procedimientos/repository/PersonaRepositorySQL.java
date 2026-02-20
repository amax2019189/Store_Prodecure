package com.alejandromax.procedimientos.repository;

import com.alejandromax.procedimientos.entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositorySQL implements PersonaRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Persona> listar() {
        StoredProcedureQuery query = em.createStoredProcedureQuery("verPersonas", Persona.class);
        return query.getResultList();
    }

    @Override
    public Optional<Persona> buscarPorId(Long id) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("buscarPersona", Persona.class);
        query.registerStoredProcedureParameter("id_persona", Integer.class, ParameterMode.IN);
        query.setParameter("id_persona", id.intValue());

        List<Persona> result = query.getResultList();
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public void crear(Persona persona) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("insertarPersona");
        query.registerStoredProcedureParameter("nombre_persona", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("apellido_persona", String.class, ParameterMode.IN);

        query.setParameter("nombre_persona", persona.getNombre());
        query.setParameter("apellido_persona", persona.getApellido());

        query.execute();
    }

    @Override
    public int actualizar(Long id, Persona persona) {
        return 0;
    }

    @Override
    public int eliminar(Long id) {
        return 0;
    }
}