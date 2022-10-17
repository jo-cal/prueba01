
package com.example.demo002.service;

import com.example.demo002.model.Tarjeta;
import java.util.List;


public interface iTarjetaService {
    
    // métodos sin su implementacion, porque es una inter-face. 
    // se implementan en TarjetaServide
    
     public List<Tarjeta> getTarjeta ();
    
    //public List<Tarjeta> verTarjeta ();
     
    public void saveTarjeta (Tarjeta tarj);
    
    //public void addTarjeta (Tarjeta tarj);
    //public Tarjeta addTarjeta (Tarjeta tarj);
     
     public void deleteTarjeta (Long id);
    
    //public void eliminarTarjeta (Long id);
    
    public Tarjeta buscarTarjeta(Long id);
    
    public Tarjeta findTarjeta (Long id);
    
}
