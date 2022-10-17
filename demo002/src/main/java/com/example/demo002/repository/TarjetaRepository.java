
package com.example.demo002.repository;

import com.example.demo002.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository <Tarjeta, Long> {
   
    
    
}
