package com.kas.security_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "ContractPayment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

//    @NotBlank(message = "Amount cannot be blank")
    private double amount;

}
