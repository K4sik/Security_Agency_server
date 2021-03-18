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
@Table(name = "PaymentType")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @OneToMany(mappedBy = "paymentType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContractPayment> contractPayments;

}
