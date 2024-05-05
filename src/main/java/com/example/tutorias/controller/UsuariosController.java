package com.example.tutorias.controller;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.service.IUsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    //6 COMPROMISO: VALIDAR QUE LA CONTRASEÑA SEA ALFANUMERICA Y MÍNIMO 8 CARACTERES
    // MÁXIMO 32 CARACTERES
    //7 COMPROMISO: VALIDAR QUE EL USUARIO INGRESADO NO SE REPITA EN LA BASE DE DATOS
    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody UserDTO data) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("user", iUsuariosService.crear(data));
        return map;
    }

    //1 COMPROMISO: VALIDAR QUE SI EL USUARIO NO EXISTE ME RETORNE UN MENSAJE
    // DE USUARIO NO ENCONTRADO EN LUGAR DE DATA CON VALORES EN NULL
    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Integer id) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("user", iUsuariosService.getById(id));
        return map;
    }

    //2 COMPROMISO: IMPLEMENTAR FILTRO POR ESTADO
    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("users", iUsuariosService.getAll());
        return map;
    }

    //3 COMPROMISO: VALIDAR QUE AL ACTUALIZAR SOLO NOMBRE Y APELLIDO
    // EL RESTO DE LA INFORMACIÓN NO SEA VACIA
    //4 COMPROMISO: UNIFICAR LOS MÉTODOS CREAR Y ACTUALIZAR USUARIO
    //5 COMPRIMISO: VALIDAR CON NOTACIONES QUE EL ID RECIBIDO NO SEA NULL NI VACIO
    // Y QUE SEA MAYOR O IGUAL A UNO (1)
    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (bindingResult.hasErrors()) {
            map.put("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            map.put("user", iUsuariosService.update(userDTO));
        }
        return map;
    }

}
