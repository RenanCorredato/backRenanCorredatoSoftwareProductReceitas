package br.com.api.barbecue.controllers;

import br.com.api.barbecue.models.dtos.request.RecipeRequestDto;
import br.com.api.barbecue.models.dtos.response.RecipesResponseDto;
import br.com.api.barbecue.services.BarbecueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barbecues")
public class BarbecueController {

    private BarbecueService barbecueService;

    public BarbecueController(BarbecueService barbecueService) {
        this.barbecueService = barbecueService;
    }

    @GetMapping
    public ResponseEntity<List<RecipesResponseDto>> findAll(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) String ingredient) {

        if(name != null && !name.isEmpty()){
            var response = this.barbecueService.findByName(name);
            return ResponseEntity.ok().body(response);
        }

        if (ingredient != null && !ingredient.isEmpty()){
            var response = this.barbecueService.findByIngredients(ingredient);
            return ResponseEntity.ok().body(response);
        }

        var response = this.barbecueService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public RecipesResponseDto findById(@PathVariable String id) {
        return this.barbecueService.findById(id);
    }

    @PostMapping
    public RecipesResponseDto save(@RequestBody RecipeRequestDto request) {
        return this.barbecueService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        this.barbecueService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RecipesResponseDto update(@PathVariable String id, @RequestBody RecipeRequestDto request) {
        return this.barbecueService.update(id, request);
    }

}
