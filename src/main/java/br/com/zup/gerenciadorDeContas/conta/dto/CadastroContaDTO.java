package br.com.zup.gerenciadorDeContas.conta.dto;

import br.com.zup.gerenciadorDeContas.conta.enums.Tipo;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CadastroContaDTO {
    @Size(min = 2, message = "O nome deve conter pelo menos 2 caracteres")
    @NotBlank(message = "Campo Obrigatório!")
    private String nome;
    @DecimalMin("0.01")
    private double valor;
    @NotNull(message = "Campo Obrigatório!")
    private Tipo tipo;
    @NotNull(message = "Campo Obrigatório!")
    private LocalDate dataDeVencimento;

    public CadastroContaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}
