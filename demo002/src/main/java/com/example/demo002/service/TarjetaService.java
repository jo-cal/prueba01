
package com.example.demo002.service;

import com.example.demo002.model.Tarjeta;
import com.example.demo002.repository.TarjetaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional    //  => agregado
public class TarjetaService implements iTarjetaService {
    
    @Autowired
    public TarjetaRepository tarjeRepo;
    
    @Override
    public List<Tarjeta> getTarjeta() { List<Tarjeta> listaTarjeta = tarjeRepo.findAll();return listaTarjeta;}
    
                          //public List<Tarjeta> verTarjeta() {return tarjeRepo.findAll();}
    @Override
    public void saveTarjeta(Tarjeta tarj) {tarjeRepo.save(tarj);}     
    
                             //public void crearTarjeta(Tarjeta tarj) {tarjeRepo.save(tarj);}
    @Override
    public void deleteTarjeta(Long id) {tarjeRepo.deleteById(id);}
    
                           //public void eliminarTarjeta(Long id) {tarjeRepo.deleteById(id);}
    @Override
    public Tarjeta findTarjeta(Long id) {Tarjeta tarj = tarjeRepo.findById(id).orElse(null);return tarj; }
    
    @Override // =>agregado
    public Tarjeta buscarTarjeta(Long id) {return tarjeRepo.findById(id). orElse(null);}
    
    
   
}