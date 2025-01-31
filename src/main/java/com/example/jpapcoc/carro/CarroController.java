package com.example.jpapcoc.carro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarroController {

    private final CarroRepository carroRepo;

    public CarroController(CarroRepository carroRepo) {
        this.carroRepo = carroRepo;
    }

    @PostMapping("carro")
    public String carro(@RequestBody Carro carro) {

        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setNome(carro.getPessoaNome());


        CarroEntity carroEntity = new CarroEntity();
        carroEntity.setMarca( carro.getMarca());
        carroEntity.setModelo(carro.getModelo());
        carroEntity.setAno(carro.getAno());
        carroEntity.setPlaca(carro.getPlaca());
        carroEntity.setPessoa(pessoa);



        this.carroRepo.save(carroEntity);


        return carroEntity.toString();
    }

    @GetMapping("carros")
    public List<Carro> getAllCarros(){
        List<CarroEntity> carros = this.carroRepo.findAll();

        return carros.stream().map(c -> {
            Carro carro = new Carro();
            carro.setMarca(c.getMarca());
            carro.setModelo(c.getModelo());
            carro.setAno(c.getAno());
            carro.setPlaca(c.getPlaca());
            if (c.getPessoa() != null) {
                carro.setPessoaNome(c.getPessoa().getNome());
            }

            return carro;
        }).toList();

    }
}
