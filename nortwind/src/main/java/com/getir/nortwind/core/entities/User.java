package com.getir.nortwind.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// bu user pakedi sade getir.nortwind projesi deil ilerde başka
// projelerde kullanılacak kullanılacağı için bu core katmanına ekledik
@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Email
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @NotBlank
    @NotNull
    private String password;

}
