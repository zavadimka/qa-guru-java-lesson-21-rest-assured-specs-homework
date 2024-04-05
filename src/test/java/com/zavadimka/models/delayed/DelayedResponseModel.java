package com.zavadimka.models.delayed;

import com.zavadimka.models.ResponseSupportModel;
import com.zavadimka.models.ResponseUserModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DelayedResponseModel {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<ResponseUserModel> data;
    private ResponseSupportModel support;
}
