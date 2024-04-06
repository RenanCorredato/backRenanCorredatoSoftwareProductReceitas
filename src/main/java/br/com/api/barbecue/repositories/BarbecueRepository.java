package br.com.api.barbecue.repositories;

import br.com.api.barbecue.models.entities.Recipes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbecueRepository extends MongoRepository<Recipes, String> {

    public List<Recipes> findByNomeContains(String name);

    public List<Recipes> findByIngredientesContains(String ingredientes);

}
