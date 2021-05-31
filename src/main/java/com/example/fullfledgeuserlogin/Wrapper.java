package com.example.fullfledgeuserlogin;

import lombok.Data;

import java.util.List;

@Data
public class Wrapper {
    private List<UserInfo> data;
    private int recordsTotal;
    private int pageLength;
    private int recordsFiltered;
    public Wrapper(){}
    public Wrapper(List<UserInfo> data, int recordsTotal, int pageLength, int recordsFiltered) {
        this.data = data;
        this.recordsTotal = recordsTotal;
        this.pageLength = pageLength;
        this.recordsFiltered = recordsFiltered;
    }
}
