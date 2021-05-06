package com.kas.security_agency.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/client")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String clientAccess() {
        return "Client Content.";
    }

    @GetMapping("/contract")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String contractAccess() {
        return "Contract Content.";
    }

    @GetMapping("/document")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String documentAccess() {
        return "Document Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String employeeAccess() {
        return "Employee Board.";
    }

    @GetMapping("/team")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String teamAccess() {
        return "Team Board.";
    }

    @GetMapping("/position")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String positionAccess() {
        return "Position Board.";
    }

    @GetMapping("/product")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String productAccess() {
        return "Product Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/client_type")
    @PreAuthorize("hasRole('ADMIN')")
    public String client_typeAccess() {
        return "Client Type Board.";
    }

    @GetMapping("/document_type")
    @PreAuthorize("hasRole('ADMIN')")
    public String document_typeAccess() {
        return "Document type Board.";
    }

    @GetMapping("/status")
    @PreAuthorize("hasRole('ADMIN')")
    public String statusAccess() {
        return "Status Board.";
    }

    @GetMapping("/type_of_security")
    @PreAuthorize("hasRole('ADMIN')")
    public String type_of_securityAccess() {
        return "Type of security Board.";
    }
}
