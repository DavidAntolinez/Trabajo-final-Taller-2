package com.example.api_taller2.Models.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotEmpty
    // @Column(name = "contraseña")
    private String Password;

    @NotNull
    @NotEmpty
    // @Column(name = "usuario")
    private String Username;
    
    public Usuario(@NotNull @NotEmpty String password, @NotNull @NotEmpty String username) {
        Password = password;
        Username = username;
    }

    public Usuario() {

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    
}
