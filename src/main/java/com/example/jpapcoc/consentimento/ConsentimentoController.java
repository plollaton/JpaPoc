package com.example.jpapcoc.consentimento;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsentimentoController {

    private final ConsentimentoRepository repo;

    public ConsentimentoController(ConsentimentoRepository repo) {
        this.repo = repo;
    }

    @PostMapping("consentimento")
    public String postConsentimento(@RequestBody Consentimento consentimento) {

        ConsentimentoEntity consentimentoEntity = new ConsentimentoEntity();
        consentimentoEntity.setConsentId(consentimento.getConsentId());
        consentimentoEntity.setValor(consentimento.getValor());


        RejeicaoEntity rejeicao = new RejeicaoEntity();
        rejeicao.setDescricao(consentimento.getRejeicao().getDescricao());
        rejeicao.setNivel(consentimento.getRejeicao().getNivel());
        rejeicao.setConsentimento(consentimentoEntity);

        consentimentoEntity.setRejeicao(rejeicao);
        this.repo.save(consentimentoEntity);

        return consentimentoEntity.toString();
    }
}
