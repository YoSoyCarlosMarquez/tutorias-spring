package com.example.tutorias.controller;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get/all")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("users", iUsuariosService.getAll());
        return map;
    }

    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody UserDTO data) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("user", iUsuariosService.crear(data));
        return map;
    }


}
