package ch.fwesterath.kahlifarspringapi.controller.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyInventory;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyWallet;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyInventoryRepository;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/economy")
public class EconomyInverntoryController {
    @Autowired
    EconomyInventoryRepository economyInventoryRepository;
    @Autowired
    private EconomyWalletRepository economyWalletRepository;

    @GetMapping("/inventories")
    public List<EconomyInventory> getAllWallets() {
        return economyInventoryRepository.findAll();
    }

    @GetMapping("/inventories/{id}")
    public EconomyInventory getInventoryById(@PathVariable("id") Long id) {
        return economyInventoryRepository.findById(id).get();
    }

    @PostMapping("/inventories")
    public EconomyInventory createInventory(@RequestBody EconomyInventory economyInventory) {
        try {
            return economyInventoryRepository.save(economyInventory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }


}
