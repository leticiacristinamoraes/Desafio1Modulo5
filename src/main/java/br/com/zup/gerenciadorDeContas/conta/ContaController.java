package br.com.zup.gerenciadorDeContas.conta;

import br.com.zup.gerenciadorDeContas.conta.dto.CadastroContaDTO;
import br.com.zup.gerenciadorDeContas.conta.dto.ResumoContaDTO;
import br.com.zup.gerenciadorDeContas.conta.dto.SaidaContaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaContaDTO cadastrarConta(@RequestBody @Valid CadastroContaDTO cadastroContaDTO) {
        Conta conta = modelMapper.map(cadastroContaDTO, Conta.class);
        SaidaContaDTO saidaContaDTO = modelMapper.map
                (contaService.cadastrarConta(conta), SaidaContaDTO.class);

        return saidaContaDTO;
    }

    @GetMapping
    public List<ResumoContaDTO> exibirContas() {
        List<ResumoContaDTO> resumoContaDTO = new ArrayList<>();
        List<Conta> contas = contaService.exibirContas();
        for (Conta contaReferencia : contas) {
            ResumoContaDTO resumo = modelMapper.map(contaReferencia, ResumoContaDTO.class);
            resumoContaDTO.add(resumo);
        }
        return resumoContaDTO;
    }
}
