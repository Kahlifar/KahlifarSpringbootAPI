package ch.fwesterath.kahlifarspringapi.controller.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyWallet;
import ch.fwesterath.kahlifarspringapi.repository.economy.EconomyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/economy")
public class EconomyWalletController {

    @Autowired
    EconomyWalletRepository economyWalletRepository;

    @GetMapping("/wallets")
    public List<EconomyWallet> getAllWallets() {
        return economyWalletRepository.findAll();
    }

    @PostMapping("/wallets")
    public EconomyWallet createWallet(@RequestBody EconomyWallet economyWallet) {
        return economyWalletRepository.save(economyWallet);
    }
}
