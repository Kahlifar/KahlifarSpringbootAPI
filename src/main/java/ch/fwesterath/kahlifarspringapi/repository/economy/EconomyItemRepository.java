package ch.fwesterath.kahlifarspringapi.repository.economy;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyItemRepository extends JpaRepository<EconomyItem, Long> {

}
