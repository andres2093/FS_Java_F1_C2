package com.springboot.dataapp.models.service;

import com.springboot.dataapp.models.entity.Cliente;

import java.util.List;

public interface IclienteService {
    List<Cliente> listar();
    void guardar(Cliente cliente);
    Cliente porId(Long id);
    void eliminar(Long id);
}
