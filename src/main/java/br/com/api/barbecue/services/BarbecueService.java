package br.com.api.barbecue.services;

import br.com.api.barbecue.models.dtos.request.RecipeRequestDto;
import br.com.api.barbecue.models.dtos.response.RecipesResponseDto;
import br.com.api.barbecue.models.entities.Recipes;
import br.com.api.barbecue.repositories.BarbecueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbecueService {

    private BarbecueRepository barbecueRepository;

    public BarbecueService(BarbecueRepository barbecueRepository) {
        this.barbecueRepository = barbecueRepository;
    }

    public List<RecipesResponseDto> findAll() {
        return Recipes.toRecipesListDto(barbecueRepository.findAll());
    }

    public RecipesResponseDto findById(String id) {
        var result = barbecueRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Recipe not found");
        }

        return Recipes.toRecipesDto(result.get());
    }

    public List<RecipesResponseDto> findByName(String name) {
        var result = barbecueRepository.findByNomeContains(name);
        return Recipes.toRecipesListDto(result);
    }

    public List<RecipesResponseDto> findByIngredients(String ingredient) {
        var result = barbecueRepository.findByIngredientesContains(ingredient);
        return Recipes.toRecipesListDto(result);
    }

    public RecipesResponseDto save(RecipeRequestDto request) {
        var recipe = Recipes.builder()
                .nome(request.getNome())
                .ingredientes(request.getIngredientes())
                .instrucoes(request.getInstrucoes())
                .build();


        var result = barbecueRepository.save(recipe);
        return Recipes.toRecipesDto(result);
    }

    public void deleteById(String id) {
        barbecueRepository.deleteById(id);
    }

    public void deleteAll() {
        barbecueRepository.deleteAll();
    }


    public RecipesResponseDto update(String id, RecipeRequestDto request) {
        var recipe = Recipes.builder()
                .id(id)
                .nome(request.getNome())
                .ingredientes(request.getIngredientes())
                .instrucoes(request.getInstrucoes())
                .build();

        var result = barbecueRepository.save(recipe);
        return Recipes.toRecipesDto(result);
    }
}
