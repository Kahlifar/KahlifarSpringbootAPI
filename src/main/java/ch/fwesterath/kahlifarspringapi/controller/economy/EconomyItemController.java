package ch.fwesterath.kahlifarspringapi.controller.economy;

import ch.fwesterath.kahlifarspringapi.helper.economy.ItemType;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyInventory;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyItem;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyInventoryRepository;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("economy/items")
public class EconomyItemController {
    @Autowired
    EconomyItemRepository economyItemRepository;

    @GetMapping
    public List<EconomyItem> getAllItems() {
        return economyItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public EconomyItem getItemById(@PathVariable Long id) {
//        try {
            return economyItemRepository.findById(id).get();
//        }
    }

    @PostMapping
    public EconomyItem createItem(@RequestBody EconomyItem ecoItem) {
        if (!ItemType.isValid(ecoItem.getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item type: " + ecoItem.getType());
        }
        return economyItemRepository.save(ecoItem);
    }

    @PutMapping("/{id}")
    public EconomyItem updateItem(@PathVariable Long id, @RequestBody EconomyItem ecoItem) {
        if (!ItemType.isValid(ecoItem.getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item type: " + ecoItem.getType());
        }
        ecoItem.setId(id);
        return economyItemRepository.save(ecoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        economyItemRepository.deleteById(id);
    }
}
