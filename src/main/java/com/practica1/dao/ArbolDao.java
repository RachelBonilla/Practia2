package com.practica1.dao;

import com.practica1.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbolDao extends JpaRepository<Arbol, Long> {
    // Aquí puedes agregar métodos adicionales si es necesario
}
