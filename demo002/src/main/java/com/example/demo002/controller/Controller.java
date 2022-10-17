
package com.example.demo002.controller;

import com.example.demo002.model.Tarjeta;
import com.example.demo002.service.TarjetaService;
import com.example.demo002.service.iTarjetaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
    @Autowired
    private iTarjetaService tarjeServ;
    
    @GetMapping ("/tarjetas")
    public List<Tarjeta> getTarjeta() {return tarjeServ.getTarjeta();}
    
    /*@GetMapping("/tarjeta/ver")
    @ResponseBody
    public List<Tarjeta> verTarjeta() {return tarjeServ.verTarjeta();}*/
    
    @GetMapping("/tarjetas/{id}")
    public ResponseEntity <Tarjeta> addTarjeta(@PathVariable("id") Long id){Tarjeta tarjeta = tarjeServ.buscarTarjeta(id);return new ResponseEntity<>(tarjeta, HttpStatus.OK);}
    //public ResponseEntity <Tarjeta> encontrarTarjeta(@PathVariable("id") Long id){Tarjeta tarjeta = tarjeServ.findTarjeta(id);return new ResponseEntity<>(tarjeta, HttpStatus.OK);}
    
  
    @PostMapping ("/tarjetas")
    //public String saveTarjeta /* o addTarjeta*/ (@RequestBody Tarjeta tarj) {tarjeServ.saveTarjeta(tarj);return "La tarjeta fue creada correctaente";}
    public void saveTarjeta(@RequestBody Tarjeta tarj){tarjeServ.saveTarjeta(tarj);}
    //public ResponseEntity<Tarjeta>addTarjeta(@RequestBody Tarjeta tarj){Tarjeta newTarjeta = tarjeServ.addTarjeta(tarj);return     new ResponseEntity<>(newTarjeta,HttpStatus.CREATED);}
    // public void crearTarjeta(@RequestBody Tarjeta tarj){tarjeServ.agregarTarjeta(tar
    
    @DeleteMapping ("/tarjetas/{id}")
    //public String deleteTarjeta (@PathVariable Long id) {tarjeServ.deleteTarjeta(id);return "La tarjeta fue borrada correctamente";}
    public ResponseEntity<?> deleteTarjeta(@PathVariable("id") Long id){tarjeServ.deleteTarjeta(id); return new ResponseEntity<>(HttpStatus.OK); }         
    //public void deleteTarjeta(@PathVariable Long id){tarjeServ.eliminarTarjeta(id); }
    
    
    
    /*@PutMapping("/tarjeta/editar/{id}")
    public Tarjeta editTarjeta(@PathVariable Long id,
                               
                               @RequestParam ("title") String nuevoTitle,
                               @RequestParam ("description") String nuevoDescription,
                               @RequestParam ("image") String nuevoImage){
       Tarjeta tarj = tarjeServ.findTarjeta(id);
       tarj.setTitle(nuevoTitle);
       tarj.setDescription(nuevoDescription);
       tarj.setImage(nuevoImage);
       
       tarjeServ.saveTarjeta(tarj);
       return tarj;}*/
    
        @PutMapping("/tarjetas/{id}")
        public Tarjeta updateTarjeta(@PathVariable long id,@RequestBody Tarjeta tarjetaDetails) {
        Tarjeta updateTarjeta = tarjeServ.findTarjeta(id);

        updateTarjeta.setTitle(tarjetaDetails.getTitle());
        updateTarjeta.setDescription(tarjetaDetails.getDescription());
        updateTarjeta.setImage(tarjetaDetails.getImage());

        tarjeServ.saveTarjeta(updateTarjeta);return updateTarjeta;}
    
     
    
}
