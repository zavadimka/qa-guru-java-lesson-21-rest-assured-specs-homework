package com.zavadimka.models.resources;

import com.zavadimka.models.ResponseResourceModel;
import com.zavadimka.models.ResponseSupportModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SingleResourceResponseModel {

    private ResponseResourceModel data;
    private ResponseSupportModel support;
}
