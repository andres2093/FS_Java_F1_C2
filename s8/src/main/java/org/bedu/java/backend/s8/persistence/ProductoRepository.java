package org.bedu.java.backend.s8.persistence;

import org.bedu.java.backend.s8.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
