package com.example.tutorias.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class UsuariosController {

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

    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody Map<String, Integer> datos) {

        Integer edad = 2024 - datos.get("year");

        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("age", edad);
        return map;
    }


}
