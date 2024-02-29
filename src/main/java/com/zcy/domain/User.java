package com.zcy.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2566816725396650300L;

    private long id;
    private String name;
    private int sex;
    private LocalDate birthday;
    private String email;
    private String mobile;
    private String address;
    private String icon;
    private List<Integer> permissions;
    private int status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}

