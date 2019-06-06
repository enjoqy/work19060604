package org.junhi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author junhi
 * @Date 2019/6/6 11:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private int cid;
    private String cityName;
}
