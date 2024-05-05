package com.example.tutorias.service.impl;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;
import com.example.tutorias.repository.UsuarioRepository;
import com.example.tutorias.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity crear(UserDTO dto) {
        UserDTO user = new UserDTO();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsuario(dto.getUser());
        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
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
    public UsuarioEntity getById(Integer id) {
        Optional<UsuarioEntity> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        UsuarioEntity usuario = new UsuarioEntity();
        return usuario;
    }

    @Override
    public String getByStatus() {
        return "getByStatus";
    }

    @Override
    public UsuarioEntity update(UserDTO dto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(dto.getId());
        usuario.setUsuario(dto.getUser());
        usuario.setPassword(dto.getPassword());
        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
        usuario.setEstado("A");
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

}
