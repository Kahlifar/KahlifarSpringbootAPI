package ch.fwesterath.kahlifarspringapi.repository;

import ch.fwesterath.kahlifarspringapi.models.DiscordUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscordUserRepository extends JpaRepository<DiscordUser, Integer> {
}
