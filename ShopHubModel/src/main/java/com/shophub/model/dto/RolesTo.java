package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesTo implements Serializable {

    private Long roleId;
    private String role;
    private String accessType;
}
