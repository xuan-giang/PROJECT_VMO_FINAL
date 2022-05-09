package com.example.ex1_managementapartmentbuilding.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private Long timeStamp;
}
