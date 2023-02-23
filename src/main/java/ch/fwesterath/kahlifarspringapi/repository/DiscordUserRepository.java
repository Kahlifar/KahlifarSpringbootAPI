package ch.fwesterath.kahlifarspringapi.repository;

import ch.fwesterath.kahlifarspringapi.models.DiscordUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiscordUserRepository extends JpaRepository<DiscordUser, Integer> {
//    DiscordUser by Discord id
    @Query(value = "SELECT u FROM DiscordUser u WHERE u.discord_id = ?1")
    DiscordUser findByDiscordId(Long discordId);
}