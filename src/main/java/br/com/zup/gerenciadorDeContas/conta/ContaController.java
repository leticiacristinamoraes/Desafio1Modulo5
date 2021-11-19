package br.com.zup.gerenciadorDeContas.conta;

import br.com.zup.gerenciadorDeContas.conta.dto.CadastroContaDTO;
import br.com.zup.gerenciadorDeContas.conta.dto.SaidaContaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
