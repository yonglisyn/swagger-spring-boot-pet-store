package com.sample.repository;

import com.sample.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreRepository {
    private static List<Pet> inventory = new ArrayList<>();

    public List<Pet> getInventory() {
        return inventory;
    }

    public void add(Pet pet) {
        inventory.add(pet);
    }

    public void delete(Long id) {
        inventory.removeIf(x -> x.getId() == id);
    }

    public Pet get(Long id) {
        if (inventory.isEmpty()) {
            return null;
        }
        return inventory.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

}
