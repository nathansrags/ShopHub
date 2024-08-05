package com.shophub.model.entity;

import com.shophub.model.constants.DBConstants;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "roles", schema = DBConstants.SCHEMA)
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @Column(name = "access_type")
    private String accessType;




}
