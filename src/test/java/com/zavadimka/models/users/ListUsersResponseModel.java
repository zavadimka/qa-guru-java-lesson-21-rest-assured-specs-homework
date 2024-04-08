package com.zavadimka.models.users;

import com.zavadimka.models.ResponseSupportModel;
import com.zavadimka.models.ResponseUserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListUsersResponseModel {

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<ResponseUserModel> data;
    private ResponseSupportModel support;
}
