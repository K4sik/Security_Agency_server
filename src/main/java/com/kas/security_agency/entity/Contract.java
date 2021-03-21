package com.kas.security_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Contract")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @NotBlank(message = "First name cannot be blank")
    private String first_name;

    @NotBlank(message = "Last name cannot be blank")
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Date agreement_date;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private Date date_begin;

    private Date date_end;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "type_of_security_id", nullable = false)
    private TypeOfSecurity typeOfSecurity;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference(value = "listOfProducts")
    private List<ListOfProduct> listOfProducts;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference(value = "contractPayments")
    private List<ContractPayment> contractPayments;
}
