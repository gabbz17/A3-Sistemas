package com.example.A3_Sistemas_Distribuidos.documentation;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioResponseDTO;
import com.example.A3_Sistemas_Distribuidos.web.dto.TarefaResponseDTO;
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

@Tag(name = "Tarefa", description = "Documentação da entidade Tarefa")
public interface TarefaDocs {

    @Operation(summary = "Cria uma nova Tarefa", description = "Http para criar uma nova Tarefa",
            responses = {@ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "409", description = "Erro ao criar Tarefa!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<Tarefa> create(@Valid @RequestBody Tarefa tarefa);

    @Operation(summary = "Retorna todas as Tarefas", description = "Http para retornar todas as Tarefas",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao listar todas as Tarefas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao retornar todas as Tarefas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<Tarefa>> findAll();

    @Operation(summary = "Retorna Tarefa pelo uid", description = "Http para retornar Tarefa pelo uid",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Tarefa pelo uid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Tarefa pelo uid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<Tarefa> findByUid(@PathVariable String uid);

    @Operation(summary = "Retorna Tarefa pelo status atribuído", description = "Http para retornar Tarefa pelo status atribuído",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Tarefa pelo status", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Tarefa pelo status", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<Tarefa>> findByStatus(@PathVariable String status);

    @Operation(summary = "Retorna Tarefa pelo nome do supervisor", description = "Http para retornar Tarefa pelo nome do supervisor",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Tarefa pelo nome do supervisor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Tarefa pelo nome do supervisor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<Tarefa>> findBySupervisor(@PathVariable String supervisor);

    @Operation(summary = "Retorna Tarefa pelo nome do atendente", description = "Http para retornar Tarefa pelo nome do atendente",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar Tarefa pelo nome do atendente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar Tarefa pelo nome do atendente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<Tarefa>> findByAtendente(@PathVariable String atendente);

    @Operation(summary = "Altera status da Tarefa pelo uid", description = "Http para alterar status da Tarefa pelo uid",
            responses = {@ApiResponse(responseCode = "201", description = "Sucesso ao alterar status da Tarefa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "204", description = "Erro ao alterar status da Tarefa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<Tarefa> update(@PathVariable String uid, @Valid @RequestBody TarefaResponseDTO status);

    @Operation(summary = "Deleta Tarefa pelo uid", description = "Http para deletar Tarefa pelo uid",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao deletar Tarefa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "204", description = "Erro ao deletar Tarefa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<Void> delete(@PathVariable String uid);
}
