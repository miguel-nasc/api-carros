package com.projeto.Carros.controllers;

import com.projeto.Carros.controllers.docs.CarroControllerDocs;
import com.projeto.Carros.dtos.CarroDTO;
import com.projeto.Carros.servicos.CarroService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "http://localhost:8080")
public class CarroController implements CarroControllerDocs {

    CarroService service;
    public CarroController(CarroService service) {this.service = service;}

    @Override
    @PostMapping
    public ResponseEntity<CarroDTO> save(@RequestBody CarroDTO carroDTO) {
        service.create(carroDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping
    public CarroDTO update(CarroDTO carroDTO) {
        return service.update(carroDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping(value = "/findAll",
            produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findAll(pageable));
    }



    @Override
    @GetMapping(value = "/{id}",
    produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE })
    public CarroDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findByModelo(
            @PathVariable(value = "modelo") String modelo,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "direction") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findByModelo(modelo, pageable));
    }

    @Override
    @GetMapping("/cor/{cor}")
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findByCor(
            @PathVariable(value = "cor") String cor,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "direction") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findByCor(cor, pageable));
    }

    @Override
    @GetMapping("/motorizacao/{motor}")
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findByMotorizacao(
            @PathVariable("motor") String motor,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "direction") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findByMotorizacao(motor, pageable));
    }

    @Override
    @GetMapping("/marca/{marca}")
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findByMarca(
            @PathVariable(value = "marca") String marca,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "direction") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findByMarca(marca, pageable));
    }

    @Override
    @GetMapping("/ano/{ano}")
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findByAno(
            @PathVariable(value = "ano") String ano,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "direction") String direction) {
        Sort.Direction sortDirection = getSortDirection(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "modelo"));
        return ResponseEntity.ok(service.findByAno(ano, pageable));
    }


    private static Sort.Direction getSortDirection(String direction) {
        return direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC
                : Sort.Direction.ASC;
    }

}
