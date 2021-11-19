package br.com.zup.gerenciadorDeContas.conta.dto;

import br.com.zup.gerenciadorDeContas.conta.enums.Status;

public class AtualizarContaDTO {
    private Status status;

    public AtualizarContaDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
