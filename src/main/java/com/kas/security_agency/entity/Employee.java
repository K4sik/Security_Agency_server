package com.kas.security_agency.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", nullable = false)
//    @NotBlank(message = "Position cannot be blank")
    private Position position;

    @NotBlank(message = "First name cannot be blank")
    private String first_name;

    @NotBlank(message = "Last name cannot be blank")
    private String last_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id", nullable = false)
//    @NotBlank(message = "Team cannot be blank")
    private Team team;

    @NotBlank(message = "Phone number cannot be blank")
    private String phone_number;

    //    @NotBlank(message = "Date of Birth cannot be blank")
    private Date birthday;

    @NotBlank(message = "Address number cannot be blank")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Contract> contracts;

}
