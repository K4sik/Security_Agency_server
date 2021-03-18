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
@Table(name = "TypeOfSecurity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeOfSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;

    @OneToMany(mappedBy = "typeOfSecurity", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Contract> contracts;
}
