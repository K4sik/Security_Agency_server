package com.kas.security_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private ClientType clientType;

    @NotBlank(message = "First name cannot be blank")
    private String first_name;

    @NotBlank(message = "Last name cannot be blank")
    private String last_name;

    @NotBlank(message = "Company name cannot be blank")
    private String company_name;

    @NotBlank(message = "Phone number cannot be blank")
    private String phone_number;

    //    @NotBlank(message = "Date of Birth cannot be blank")
    private Date birthday;

    @NotBlank(message = "Address number cannot be blank")
    private String address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonBackReference(value = "documents")
    private List<Document> documents;

    @OneToMany(mappedBy = "client")
    @JsonBackReference(value = "contracts")
    private List<Contract> contracts;


}
