package com.aluracuros.forohub.repo;
import com.aluracuros.forohub.modelos.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TopicRepo extends JpaRepository<Topicos, Integer> {
    
}
