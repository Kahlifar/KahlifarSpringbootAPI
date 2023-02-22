package ch.fwesterath.kahlifarspringapi.repository.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyShopRepository extends JpaRepository<EconomyShop, Long> {
}
