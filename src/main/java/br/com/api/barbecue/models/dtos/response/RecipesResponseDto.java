package br.com.api.barbecue.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipesResponseDto {
    private String id;
    private String nome;
    private String ingredientes;
    private String instrucoes;
}
