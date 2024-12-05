package com.av3poo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    @NotBlank
    @Size(min = 4, max = 255)
    private String nome;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(min = 1, max = 255)
    private String email;

}
