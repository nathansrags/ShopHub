package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTo implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private List<RolesTo> roles;
}
