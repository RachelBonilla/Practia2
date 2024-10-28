package com.practica1.service;

import com.practica1.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    List<Arbol> getArboles(boolean activos);
    
    Arbol getArbol(Arbol arbol);
    
    Arbol save(Arbol arbol);
    
    void delete(Arbol arbol);
}
