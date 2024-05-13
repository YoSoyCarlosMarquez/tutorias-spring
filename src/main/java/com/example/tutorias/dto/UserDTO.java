package com.example.tutorias.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    //@Min(value = 0, message = "")
    Integer id;
    //@NotNull(message = "El usuario no puede ser nulo")
    //@NotEmpty(message = "El usuario no puede ser vacio")
    @NotBlank(message = "El usuario no puede ser vacio")
    String user;
    @Pattern(
            regexp = "^(?=.*\\d).{8,32}$",
            flags = Pattern.Flag.UNICODE_CASE,
            message = "La contraseña debe ser alfanúmerica, contener entre 8 y 32 caracteres")
    String password;
    String name;
    String lastname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
