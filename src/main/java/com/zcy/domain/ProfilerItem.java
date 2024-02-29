package com.zcy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilerItem {

    private String name;

    private String offset;

    private String usage;

    private String percent;

    private String parent;
}
