package com.kas.security_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ClientType")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @OneToMany(mappedBy = "clientType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Client> clients;

}
