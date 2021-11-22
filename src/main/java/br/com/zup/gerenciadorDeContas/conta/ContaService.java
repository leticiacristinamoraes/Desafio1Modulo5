package br.com.zup.gerenciadorDeContas.conta;

import br.com.zup.gerenciadorDeContas.conta.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Conta cadastrarConta(Conta conta) {
        LocalDate dataAtual = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataAtual)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return contaRepository.save(conta);
    }

    public List<Conta> exibirContas() {
        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }

    public Conta buscarContaById(int id){
        for (Conta contaReferencia : contaRepository.findAll()){
            if (contaReferencia.getId() == id){
                return contaReferencia;
            }
        }
        throw new RuntimeException("A conta informada não foi encontrada!");
    }

    public Conta atualizarConta(int id){
        Conta contaAtualizar = buscarContaById(id);
        contaAtualizar.setStatus(Status.PAGO);
        contaAtualizar.setDataDePagamento(LocalDateTime.now());

        contaRepository.save(contaAtualizar);

        return contaAtualizar;
    }
}
