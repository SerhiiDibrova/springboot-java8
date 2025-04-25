package com.example.model.dto;

import javax.validation.constraints.NotBlank;

public class UserCreateRequest {
    @NotBlank
    private String value;

    public UserCreateRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}