package com.projeto.Carros.controllers.docs;

import com.projeto.Carros.dtos.CarroDTO;
import com.projeto.Carros.entidades.Carro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jdk.jfr.ContentType;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CarroControllerDocs {

    @Operation(summary = "Criando um novo Carro",
            description = "Salvando um novo Carro no Banco de Dados",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = CarroDTO.class))),
                    @ApiResponse(description = "Not Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public CarroDTO save(@RequestBody CarroDTO carroDTO);


    @Operation(summary = "Atualiza um Carro já existente",
            description = "Atualizando um carro que já pertence ao Banco",
            tags = "Carro",
            responses = {
                    @ApiResponse(description = "Succes", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = CarroDTO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)

            })
    public CarroDTO update(@RequestBody CarroDTO carroDTO);

    @Operation(summary = "Deletando um Carro",
            description = "Deleta um Carro que está cadastrado no banco!",
            tags = "Carro",
            responses = {
                    @ApiResponse(description = "Succes", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CarroDTO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> delete(Long id);


    @Operation(summary = "Encontrando todos os carros por página", description = "Encontrar as páginas de todos os carros"
            , tags = "Carros",
            responses = {
                @ApiResponse(description = "Succes", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = CarroDTO.class))),
                @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<PagedModel<EntityModel<CarroDTO>>> findAll(Integer size, Integer page, String direction);
}
