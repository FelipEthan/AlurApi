
package com.aluracuros.forohub.driver;

import com.aluracuros.forohub.servicios.TopicosServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/topicos")
public class Topicos {
    
    @Autowired
    private TopicosServicio service;

    @GetMapping
    public ResponseEntity<List<com.aluracuros.forohub.modelos.Topicos>>findAll(){
        List <com.aluracuros.forohub.modelos.Topicos> respuestaHttp = service.findAll();
        return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<com.aluracuros.forohub.modelos.Topicos> findById(@PathVariable Integer id){
        com.aluracuros.forohub.modelos.Topicos respuestaHttp = service.findByID(id);
        return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<com.aluracuros.forohub.modelos.Topicos> save(@RequestBody com.aluracuros.forohub.modelos.Topicos topicos){
        com.aluracuros.forohub.modelos.Topicos respuestaHttp = service.save(topicos);
        return new ResponseEntity<>(respuestaHttp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.aluracuros.forohub.modelos.Topicos> update(@PathVariable Integer id, @RequestBody com.aluracuros.forohub.modelos.Topicos topicos){
    topicos.setId(id);
    com.aluracuros.forohub.modelos.Topicos respuestaHttp = service.save(topicos);
    return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
