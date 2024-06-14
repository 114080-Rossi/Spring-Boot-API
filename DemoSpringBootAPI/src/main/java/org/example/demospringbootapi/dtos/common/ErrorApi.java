package org.example.demospringbootapi.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorApi {

    private String timestamp; //La hora del error

    private Integer status; //El estado del error

    private String error;//El string del error

    private String message;//El mensaje del error
}
