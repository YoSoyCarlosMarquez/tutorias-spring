package com.example.tutorias.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    String user;
    String password;

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
}
