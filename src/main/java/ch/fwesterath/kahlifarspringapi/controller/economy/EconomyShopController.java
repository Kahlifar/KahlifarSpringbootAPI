package ch.fwesterath.kahlifarspringapi.controller.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyItem;
import ch.fwesterath.kahlifarspringapi.models.economy.EconomyShop;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyItemRepository;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/economy/shops")
public class EconomyShopController {

    @Autowired
    EconomyShopRepository economyShopRepository;
    @Autowired
    private EconomyItemRepository economyItemRepository;

    @GetMapping
    public List<EconomyShop> getAllShops() {
        return economyShopRepository.findAll();
    }

    @GetMapping("/{id}")
    public EconomyShop getShopById(@PathVariable("id") Long id) {
        return economyShopRepository.findById(id).get();
    }

    @PostMapping
    public EconomyShop createShop(@RequestBody EconomyShop economyShop) {
        System.out.println(economyShop);
        return economyShopRepository.save(economyShop);
    }

    @PutMapping("/{id}")
    public EconomyShop updateShop(@PathVariable("id") Long id, @RequestBody EconomyShop economyShop) {
        economyShop.setId(id);
        return economyShopRepository.save(economyShop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable("id") Long id) {
        economyShopRepository.deleteById(id);
    }

//    Items
    @GetMapping("/{id}/items")
    public Set<EconomyItem> getShopItems(@PathVariable("id") Long id) {
        return economyShopRepository.findById(id).get().getItems();
    }

    @PostMapping("/{id}/items/{itemid}")
    public EconomyShop addShopItem(@PathVariable("id") Long id, @PathVariable("itemid") Long itemId) {
        EconomyShop economyShop = economyShopRepository.findById(id).get();
        economyShop.getItems().add(economyItemRepository.findById(itemId).get());
        return economyShopRepository.save(economyShop);
    }

    @DeleteMapping("/{id}/items/{itemId}")
    public EconomyShop deleteShopItem(@PathVariable("id") Long id, @PathVariable("itemId") Long itemId) {
        EconomyShop economyShop = economyShopRepository.findById(id).get();
        economyShop.getItems().removeIf(item -> item.getId().equals(itemId));
        return economyShopRepository.save(economyShop);
    }

}