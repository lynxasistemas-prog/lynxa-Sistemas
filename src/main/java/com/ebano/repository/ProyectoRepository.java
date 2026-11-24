package com.ebano.repository;

import com.ebano.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByVisibleTrueOrderByOrdenAscIdAsc();
    List<Proyecto> findAllByOrderByOrdenAscIdAsc();
}
