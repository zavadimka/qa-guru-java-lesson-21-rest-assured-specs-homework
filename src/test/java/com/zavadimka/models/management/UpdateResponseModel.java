package com.zavadimka.models.management;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateResponseModel {

    private String name;
    private String job;
    private String updatedAt;
}
