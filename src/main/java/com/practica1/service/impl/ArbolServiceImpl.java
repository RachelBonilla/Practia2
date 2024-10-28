package com.practica1.service.impl;

import com.practica1.dao.ArbolDao;
import com.practica1.domain.Arbol;
import com.practica1.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArbolServiceImpl implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(boolean activos) {
        List<Arbol> lista = arbolDao.findAll();
        if (activos) {
            lista.removeIf(arbol -> !arbol.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getId()).orElse(null);
    }

    @Override
    @Transactional
    public Arbol save(Arbol arbol) {
        return arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
}

