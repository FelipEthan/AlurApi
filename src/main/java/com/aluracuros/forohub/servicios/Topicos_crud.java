package com.aluracuros.forohub.servicios;

import com.aluracuros.forohub.modelos.Topicos;
import java.util.List;

public interface Topicos_crud {
    // Metodo GET
    List<Topicos> findAll();
    Topicos findByID(Integer id);

    // Metodo POST
    Topicos save(Topicos topicos);

    //Metodo PUT
    Topicos update(Integer id, Topicos topicos);

    //Metodo DELETE
    void deleteById(Integer id);
}
