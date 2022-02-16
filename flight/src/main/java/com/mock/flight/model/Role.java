package com.mock.flight.model;

import com.mock.flight.common.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role{

    @Id
    @Column(name = "role_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;


    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
