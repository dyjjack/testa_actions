package com.zcy.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Template {

    private List<List<Number>> values = new ArrayList<>();

}