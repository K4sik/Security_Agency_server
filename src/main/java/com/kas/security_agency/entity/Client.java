package com.kas.security_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "Client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", nullable = false)
    private ClientType clientType;

    @NotBlank(message = "First name cannot be blank")
    private String first_name;

    @NotBlank(message = "Second name cannot be blank")
    private String second_name;

    @NotBlank(message = "Company name cannot be blank")
    private String company_name;

    @NotBlank(message = "Phone number cannot be blank")
    private String phone_number;

//    @NotBlank(message = "Date of Birth cannot be blank")
    private Date birthday;

    @NotBlank(message = "Address number cannot be blank")
    private String address;


}
