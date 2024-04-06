package br.com.api.barbecue.models.entities;

import br.com.api.barbecue.models.dtos.response.RecipesResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Recipes {

    @Id
    private String id;
    private String nome;
    private String ingredientes;
    private String instrucoes;

    public static List<RecipesResponseDto> toRecipesListDto(List<Recipes> recipes) {

        List<RecipesResponseDto> recipesDtos = new ArrayList<>();

        for (Recipes recipe : recipes) {
            RecipesResponseDto recipesDto = new RecipesResponseDto();
            recipesDto.setId(recipe.getId());
            recipesDto.setNome(recipe.getNome());
            recipesDto.setIngredientes(recipe.getIngredientes());
            recipesDto.setInstrucoes(recipe.getInstrucoes());
            recipesDtos.add(recipesDto);
        }

        return recipesDtos;
    }

    public static RecipesResponseDto toRecipesDto(Recipes recipe) {
        RecipesResponseDto recipesDto = new RecipesResponseDto();
        recipesDto.setId(recipe.getId());
        recipesDto.setNome(recipe.getNome());
        recipesDto.setIngredientes(recipe.getIngredientes());
        recipesDto.setInstrucoes(recipe.getInstrucoes());
        return recipesDto;
    }
}
