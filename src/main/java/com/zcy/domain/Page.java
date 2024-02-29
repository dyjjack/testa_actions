package com.zcy.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -7529237188686406553L;

    private int pageNo;
    private int total;
    private List<T> result;

}
