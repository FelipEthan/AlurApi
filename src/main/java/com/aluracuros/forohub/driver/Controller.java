/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aluracuros.forohub.driver;

import com.aluracuros.forohub.modelos.Autenticacion;
import com.aluracuros.forohub.modelos.Usuario;
import com.aluracuros.forohub.security.JWTtoken;
import com.aluracuros.forohub.security.ServiceToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class Controller {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private ServiceToken serviceToken;
    
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid Autenticacion autenticacion){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(
                autenticacion.username(),
                autenticacion.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JWTtoken = serviceToken.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTtoken(JWTtoken));
    }
}
