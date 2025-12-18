package com.projeto.Carros.controllers;

import com.projeto.Carros.controllers.docs.CarroControllerDocs;
import com.projeto.Carros.dtos.CarroDTO;
import com.projeto.Carros.servicos.CarroService;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.PageRequest;
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
    CarroController(CarroService service) {
        this.service = service;
    }

    @Override
    public CarroDTO save(CarroDTO carroDTO) {
        return service.create(carroDTO);
    }

    @Override
    public CarroDTO update(CarroDTO carroDTO) {
        return service.update(carroDTO);
    }

    @Override
    @DeleteMapping()
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
        SortDirection sortDirection = direction.equalsIgnoreCase("desc") ? SortDirection.DESCENDING :
                SortDirection.ASCENDING;
        var pageable = PageRequest.of(page, size, Sort.by(String.valueOf(sortDirection), "modelo"));
        return ResponseEntity.ok(service.findAll(pageable));
    }

}
