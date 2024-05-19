package com.example.tutorias.controller;

import com.example.tutorias.dto.ResponseDto;
import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;
import com.example.tutorias.exception.ResourceNotFoundException;
import com.example.tutorias.service.IUsuariosService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    IUsuariosService iUsuariosService;

    @GetMapping("/parametros1/{name}/{lastname}/{program}")
    public Map<String, Object> helloWorld2(
            @PathVariable("name") String name,
            @PathVariable("lastname") String lastname,
            @PathVariable("program") String program) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("name", name);
        map.put("lastname", lastname);
        map.put("program", program);
        return map;
    }

    @GetMapping("/parametros2")
    public Map<String, Object> helloWorld3(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("program") String program
    ) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("name", name);
        map.put("lastname", lastname);
        map.put("program", program);
        return map;
    }

    //DTO -> Data Transfer Objects

    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody UserDTO data) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("user", iUsuariosService.crear(data));
        return map;
    }

    @GetMapping("/{id}")
    public ResponseDto<Map<String, Object>> getById(@PathVariable Integer id) {

        UsuarioEntity user = iUsuariosService.getById(id);

        Map<String, Object> map = new ConcurrentHashMap<>();
        if (user.getId() != null) {
            map.put("user", iUsuariosService.getById(id));
        } else {
            map.put("message", "Usuario no encontrado");
        }
        return ResponseDto.create(map);
    }

    @GetMapping("/all/{estado}")
    public Map<String, Object> getAll(@PathVariable String estado) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("users", iUsuariosService.getAll(estado));
        return map;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult)
            throws ResourceNotFoundException {
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (bindingResult.hasErrors()) {
            map.put("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            map.put("user", iUsuariosService.update(userDTO));
        }
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody @Valid UserDTO data, BindingResult bindingResult) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (bindingResult.hasErrors()) {
            map.put("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
                map.put("user", iUsuariosService.save(data));
            } catch (Exception e) {
                map.put("message", e.getMessage());
            }
        }
        return map;
    }

    //COMPROMISO:

    //IMPLEMENTAR SEGURIDAD CON TOKEN JWT

}
