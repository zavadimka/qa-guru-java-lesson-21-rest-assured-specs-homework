package com.zavadimka.models.management;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateResponseModel {

    private String name;
    private String job;
    private int id;
    private String createdAt;
}
