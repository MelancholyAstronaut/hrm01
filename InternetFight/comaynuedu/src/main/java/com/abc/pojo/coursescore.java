package com.abc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class coursescore {
    private Integer studentid;
    private String studentname;
    private Integer courseid;
    private double peacescore;
    private double finalscore;
    private double totalscore;
}
