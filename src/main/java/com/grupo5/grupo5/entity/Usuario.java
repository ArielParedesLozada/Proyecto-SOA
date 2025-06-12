package com.grupo5.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    public String email;
    public String password;
    public String nombreFull;
    public String role;
}
