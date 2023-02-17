package ch.fwesterath.kahlifarspringapi.controller.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyInventory;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyItem;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyWallet;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyInventoryRepository;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyItemRepository;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/economy/inventories")
public class EconomyInverntoryController {
    @Autowired
    EconomyInventoryRepository economyInventoryRepository;

    @Autowired
    EconomyItemRepository economyItemRepository;

    @GetMapping
    public List<EconomyInventory> getAllInventories() {
        return economyInventoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public EconomyInventory getInventoryById(@PathVariable("id") Long id) {
        return economyInventoryRepository.findById(id).get();
    }

    @PostMapping
    public EconomyInventory createInventory(@RequestBody EconomyInventory economyInventory) {
        try {
            return economyInventoryRepository.save(economyInventory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PutMapping("/{id}")
    public EconomyInventory updateInventory(@PathVariable("id") Long id, @RequestBody EconomyInventory economyInventory) {
        try {
            economyInventory.setId(id);
            System.out.println(economyInventory);
            return economyInventoryRepository.save(economyInventory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable("id") Long id) {
        economyInventoryRepository.deleteById(id);
    }

//  Inventory Items

    @GetMapping("/{id}/items")
    public List<EconomyItem> getInventoryItems(@PathVariable("id") Long id) {
        try {
            EconomyInventory inventory = economyInventoryRepository.findById(id).get();
            return inventory.getItems();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @PostMapping("/{id}/items/{itemId}")
    public EconomyInventory addItemToInventory(@PathVariable("id") Long id, @PathVariable("itemId") Long itemId) {
        try {
            EconomyInventory inventory = economyInventoryRepository.findById(id).get();
            EconomyItem item = economyItemRepository.findById(itemId).get();
            inventory.getItems().add(item);
            return economyInventoryRepository.save(inventory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @DeleteMapping("/{id}/items/{itemId}")
    public EconomyInventory removeItemFromInventory(@PathVariable("id") Long id, @PathVariable("itemId") Long itemId) {
        try {
            EconomyInventory inventory = economyInventoryRepository.findById(id).get();
            inventory.getItems().removeIf(item -> item.getId().equals(itemId));
            return economyInventoryRepository.save(inventory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }


}
