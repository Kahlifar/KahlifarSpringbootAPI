package ch.fwesterath.kahlifarspringapi.repository.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyWalletRepository extends JpaRepository<EconomyWallet, Long> {
}
