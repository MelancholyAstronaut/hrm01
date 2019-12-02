package com.abc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class student {
    private Integer id;
    private String name;
    private String gender;
    private String college;
    private String adminclass;
    private int mobile;
}
