package ch.fwesterath.kahlifarspringapi.repository.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyInventoryRepository extends JpaRepository<EconomyInventory, Long> {
}
