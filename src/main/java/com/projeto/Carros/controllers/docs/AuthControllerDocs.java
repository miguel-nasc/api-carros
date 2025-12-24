package com.projeto.Carros.controllers.docs;

import com.projeto.Carros.dtos.security.AccountCredentialsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthControllerDocs {

    @Operation(summary = "Cadastra um usuário", description = "Realiza o cadastramento, " +
            "para um usuário autenticado poder se logar no sistema", tags = "Auth",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> signin(AccountCredentialsDTO credentials);

    @Operation(summary = "Recarrega um token autenticado",
            description = "Realiza a atualização do token de autorização " +
                    "para um usuário autenticado poder se logar no sistema", tags = "Auth",
            responses = {
                    @ApiResponse(description = "Success ", responseCode = "200", content = @Content),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> refresh(String username, String refreshToken);

}
