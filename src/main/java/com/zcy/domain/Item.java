package com.zcy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PC
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String serialization;

    private String protocol;

    private Long time;

    private Double score;
}
