package com.example.tutorias.service.impl;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;
import com.example.tutorias.repository.UsuarioRepository;
import com.example.tutorias.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity crear(UserDTO dto) {
        UserDTO user = new UserDTO();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsuario(dto.getUser());
        usuario.setPassword(dto.getPassword());
        usuario.setEstado("A");
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public List<UsuarioEntity> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public String login() {
        return "login";
    }

    @Override
    public String getByUsername() {
        return "getByUsername";
    }

    @Override
    public String getById() {
        return "getById";
    }

    @Override
    public String getByStatus() {
        return "getByStatus";
    }

}
