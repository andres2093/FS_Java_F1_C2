package com.springboot.dataapp.models.dao;

import com.springboot.dataapp.models.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

//La anotacion @Repository indica que se trata de una clase DAO o repositorio, es una manera
//semantica para darse cuenta de que trata la clase. @Repository es un tipo @Componente y no
//hay ningun cambio relevante si se anotara como @component. Al igual que @Service, es un @component
@Repository
public class ClienteDaoImpl implements IClienteDao {

    //Entity Manager y contexto de persistencia
    //El entity manager guarda internamente todas las entidades que gestiona y las utiliza
    // como una caché de los datos en la base de datos
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> listar() {
        //creamos una query a la tabla clientes y listamos todos los resultados
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void guardar(Cliente cliente) {
        //Si el ID es distinto de null o es mayor a 0, quiere decir el cliente ya existe, entonces se modifica
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            //Guarda un nuevo usuario mediante el metodo de persistencia persist
            em.persist(cliente);
        }
    }

    @Override
    public Cliente porId(Long id) {
        //busca el objeto. Primero indicando la clase del objeto a buscar y luego el parametro ID
        return em.find(Cliente.class, id);
    }

    @Override
    public void eliminar(Long id) {
        //Elimina el objeto pasandp el id del mismos
        Cliente cliente = porId(id);
        em.remove(cliente);
    }
}
