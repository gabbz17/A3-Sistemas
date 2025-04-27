package com.example.A3_Sistemas_Distribuidos.documentation;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioDTO;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Funcionario", description = "Documentação da entidade de Funcionario")
public interface FuncionarioDocs {

    @Operation(summary = "Cria um novo Funcionário", description = "Http para criar um novo Funcionário",
            responses = {@ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "409", description = "Erro ao criar Funcionário!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody Funcionario funcionario);

    @Operation(summary = "Retorna todos os Funcionários", description = "Http para retornar todos os Funcionários",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao listar todos os Funcionários", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao retornar todos os Funcionários", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<FuncionarioDTO>> findAll();

    @Operation(summary = "Retorna Funcionário pelo id", description = "Http para retornar Funcionário pelo id",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Funcionário pelo id", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Funcionário pelo id", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id);

    @Operation(summary = "Retorna Funcionário pelo cargo", description = "Http para retornar Funcionário pelo cargo",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Funcionário pelo cargo", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Funcionário pelo cargo", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<FuncionarioDTO>> findByCargo(@PathVariable String cargo);

    @Operation(summary = "Retorna Funcionário pelo nome", description = "Http para retornar Funcionário pelo nome",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Funcionário pelo nome", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Funcionário pelo nome", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<FuncionarioDTO> findByNome(@PathVariable String nome);

    @Operation(summary = "Altera cargo do Funcionário pelo id", description = "Http para alterar cargo do Funcionário pelo id",
            responses = {@ApiResponse(responseCode = "201", description = "Sucesso ao alterar cargo do Funcionário", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "204", description = "Erro ao alterar cargo do Funcionário", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioResponseDTO cargo);

    @Operation(summary = "Deleta Funcionário pelo id", description = "Http para deletar Funcionário pelo id",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao deletar Funcionário", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "204", description = "Erro ao deletar Funcionário", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<Void> delete(@PathVariable Long id);
}
