package org.bedu.java.backend.s8.persistence;

import org.bedu.java.backend.s8.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
