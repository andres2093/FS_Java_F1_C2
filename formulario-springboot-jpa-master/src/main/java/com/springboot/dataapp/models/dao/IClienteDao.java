package com.springboot.dataapp.models.dao;

import com.springboot.dataapp.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    List<Cliente> listar();
    void guardar(Cliente cliente);
    Cliente porId(Long id);
    void eliminar(Long id);

}
