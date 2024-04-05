package com.zavadimka.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseResourceModel {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;
}
