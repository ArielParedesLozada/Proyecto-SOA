package com.grupo5.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles")
public class Perfil {
    @Id
    private String email;

    private String nombreFull;
    private String password;
    private boolean esAdmin;
}
