package com.spront.spront.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryInfo {
    private String query;
    private int pageNum = 1;
    private int pageSize = 1;
}
