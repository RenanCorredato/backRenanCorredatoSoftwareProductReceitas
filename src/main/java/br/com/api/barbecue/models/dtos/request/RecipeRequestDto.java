package br.com.api.barbecue.models.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequestDto {
    private String nome;
    private String ingredientes;
    private String instrucoes;
}
