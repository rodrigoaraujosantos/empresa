package org.soulcodeacademy.empresa.domain.dto;

import org.soulcodeacademy.empresa.domain.Projeto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @NotNull(message = "Campo salário é obrigatório")
    private Double salario;


    @NotBlank(message = "Campo endereço é obrigatório")
    private String endereco;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
