package com.zavadimka.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseResourceModel {
    private int id;
    private String name;
    private int year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
