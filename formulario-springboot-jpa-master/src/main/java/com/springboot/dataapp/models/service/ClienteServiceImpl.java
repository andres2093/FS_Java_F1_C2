package com.springboot.dataapp.models.service;

import com.springboot.dataapp.models.dao.IClienteDao;
import com.springboot.dataapp.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/*
 * Una clase service, esta basada en el patrón de diseño fascade (o fachada). Un unico punto de acceso hacia
 * distintos DAOS o repositorios. Dentro de una clase service, podemos operar con diferentes clases DAOS*/
@Service
public class ClienteServiceImpl implements IclienteService {

    //inyectamos la interfaz para utilizar los metodos del CRUD
    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> listar() {
        return clienteDao.listar();
    }

    @Transactional
    @Override
    public void guardar(Cliente cliente) {
        clienteDao.guardar(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente porId(Long id) {
        return clienteDao.porId(id);
    }

    @Transactional
    @Override
    public void eliminar(Long id) {
        clienteDao.eliminar(id);
    }
}
