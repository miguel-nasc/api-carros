package com.projeto.Carros.servicos;

import com.projeto.Carros.controllers.CarroController;
import com.projeto.Carros.dtos.CarroDTO;
import com.projeto.Carros.entidades.Carro;
import com.projeto.Carros.repositorios.CarroRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;

import static com.projeto.Carros.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CarroService {

    private final Logger logger = LoggerFactory.getLogger(CarroService.class);

    private CarroRespository respository;
    CarroService(CarroRespository respository) {
        this.respository = respository;
    }

    private PagedResourcesAssembler<CarroDTO> assembler;
    CarroService(PagedResourcesAssembler<CarroDTO> assembler) {this.assembler = assembler;}

    //Metodos
    public CarroDTO create(CarroDTO carroDTO) {
        logger.info("Creating a new Car!");
        if (carroDTO != null) {
            respository.save(parseObject(carroDTO, Carro.class));
        }

        return carroDTO;
    }

    public void delete(Long id) {
        logger.info("Deleting a person!");
        var carro = respository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Id não registrado no banco!"));
        respository.delete(carro);
    }

    public CarroDTO update(CarroDTO carroDTO) {
        logger.info("Updating a Car!");
        Carro carro = respository.findById(carroDTO.getId())
                .orElseThrow(() -> new InvalidParameterException("Id não registrado para nenhum Carro"));
        carro.setAno(carroDTO.getAno());
        carro.setCor(carroDTO.getCor());
        carro.setModelo(carroDTO.getModelo());
        carro.setPlaca(carroDTO.getPlaca());
        carro.setMotorizacao(carroDTO.getMotorizacao());
        respository.save(carro);
        return carroDTO;
    }

    public CarroDTO findById(Long id) {
        logger.info("Finding a Car!");
        Carro carro =  respository.findById(id).orElseThrow(() -> new InvalidParameterException("Id não válido!"));
        return parseObject(carro, CarroDTO.class);
    }

    public PagedModel<EntityModel<CarroDTO>> findAll(Pageable pageable) {
        logger.info("Find All Cars!");
        var cars = respository.findAll(pageable);
        return buildPagedModel(pageable, cars);
    }

    //Métodos Construtivos
    private PagedModel<EntityModel<CarroDTO>> buildPagedModel(Pageable pageable, Page<Carro> cars) {
        var carWithLinks = cars.map(c -> {
            var carro = parseObject(c, CarroDTO.class);
            addHateoasLinks(carro);
            return carro;
        });
        Link findAllLinks = linkTo(WebMvcLinkBuilder.methodOn(CarroController.class)
                .findAll(pageable.getPageNumber(), pageable.getPageSize(),
                        String.valueOf(pageable.getSort()))).withSelfRel();
        return assembler.toModel(carWithLinks, findAllLinks);
    }

    private void addHateoasLinks(CarroDTO carro) {
        carro.add(linkTo(methodOn(CarroController.class).findAll(0, 12, "asc"))
                .withSelfRel().withType("GET"));
        carro.add(linkTo(methodOn(CarroController.class).save(carro)).withRel("save").withType("POST"));
        carro.add(linkTo(methodOn(CarroController.class).update(carro)).withRel("update").withType("PUT"));
        carro.add(linkTo(methodOn(CarroController.class).delete(carro.getId())).withRel("delete").withType("DELETE"));
    }

}
