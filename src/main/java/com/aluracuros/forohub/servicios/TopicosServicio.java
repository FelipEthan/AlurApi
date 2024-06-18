package com.aluracuros.forohub.servicios;
import com.aluracuros.forohub.modelos.Topicos;
import java.util.List;

import com.aluracuros.forohub.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicosServicio implements Topicos_crud {
    
    @Autowired
    private TopicRepo repositorio;
    
    private Integer id;
    
    @Override
    public List<Topicos> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Topicos findByID(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Topicos save(Topicos topicos) {
        return repositorio.save(topicos);
    }

    @Override
    public Topicos update(Integer id, Topicos topicos) {
        topicos.setId(id);
        return repositorio.save(topicos);
    }

    @Override
    public void deleteById(Integer id) {
        repositorio.deleteById(id);
    }
    
}
