package com.abc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class personallearn {
    private Integer studentid;
    private String studentname;
    private String gender;
    private String adminclass;
    private String coursename;
    private double peacescore;
    private double finalscore;
    private double totalscore;
}
