package com.zcy.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfilerResult {
    private List<ProfilerItem> itemList = new ArrayList<>();
}
