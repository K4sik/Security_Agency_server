package com.kas.security_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Position")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Position name cannot be blank")
    private String name;

    private String description;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<Employee> employees;

}
