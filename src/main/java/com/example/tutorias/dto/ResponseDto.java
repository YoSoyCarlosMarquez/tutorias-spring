package com.example.tutorias.dto;

//import javax.validation.Valid;

import com.example.tutorias.dto.exception.ErrorInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor(staticName = "create")
public class ResponseDto<T> {

    @Valid
    @NonNull
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseDto(T data) {
        this.data = data;
    }

    // Método estático (generado por staticName = "create")
    public static <T> ResponseDto<T> create(T data) {
        return new ResponseDto<>(data);
    }

    /*public static ResponseDto<T> create(T data) {
        ResponseDto<T> dto = new ResponseDto<>();
        dto.setData(data);
        return dto;
    }*/
}
