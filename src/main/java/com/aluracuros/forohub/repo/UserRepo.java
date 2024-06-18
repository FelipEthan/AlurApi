package com.aluracuros.forohub.repo;
import com.aluracuros.forohub.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
public interface UserRepo extends JpaRepository<Usuario, Long>{

    UserDetails findByUsername(String username);
    
}
