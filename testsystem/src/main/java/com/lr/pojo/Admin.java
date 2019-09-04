package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin{
    private static final long serialVersionUID = 352373434284905129L;

    private Integer id;
    private String username;
    private String password;

}
