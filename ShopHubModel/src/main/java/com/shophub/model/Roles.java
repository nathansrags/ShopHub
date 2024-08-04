package com.shophub.model;

import com.shophub.model.constants.DBConstants;
import lombok.*;

import javax.persistence.*;

@Table(name = "roles", schema = DBConstants.SCHEMA)
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @Column(name = "access_type")
    private String accessType;




}
