package com.zavadimka.models.delayed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zavadimka.models.ResponseSupportModel;
import com.zavadimka.models.ResponseUserModel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DelayedResponseModel {

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<ResponseUserModel> data;
    private ResponseSupportModel support;
}
