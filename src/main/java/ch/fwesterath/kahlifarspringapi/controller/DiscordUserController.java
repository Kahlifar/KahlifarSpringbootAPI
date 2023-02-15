package ch.fwesterath.kahlifarspringapi.controller;

import ch.fwesterath.kahlifarspringapi.models.DiscordUser;
import ch.fwesterath.kahlifarspringapi.repository.DiscordUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DiscordUserController {

    @Autowired
    DiscordUserRepository discordUserRepository;

    @GetMapping("/dcusers")
    public Iterable<DiscordUser> getAllDiscordUsers() {
        return discordUserRepository.findAll();
    }

    @GetMapping("/dcusers/{id}")
    public DiscordUser getDiscordUserById(@PathVariable("id") Integer id) {
        return discordUserRepository.findById(id).get();
    }

    @PostMapping("/dcusers")
    public DiscordUser createDiscordUser(@RequestBody DiscordUser discordUser) {
        try {
            return discordUserRepository.save(discordUser);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DiscordUser whith this discord id already exists");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @PutMapping("/dcusers/{id}")
    public DiscordUser updateDiscordUser(@PathVariable("id") Integer id, @RequestBody DiscordUser discordUser) {
        try {
            DiscordUser discordUserToUpdate = discordUserRepository.findById(id).get();

            System.out.println(discordUser.getUser());
            System.out.println(discordUserToUpdate.getUser());

            discordUserToUpdate.setDiscord_id(discordUser.getDiscord_id());
            discordUserToUpdate.setFirstJoinDate(discordUser.getFirstJoinDate());
            discordUserToUpdate.setLastJoinDate(discordUser.getLastJoinDate());
            discordUserToUpdate.setLeaveDate(discordUser.getLeaveDate());
            discordUserToUpdate.setUser(discordUser.getUser());

            return discordUserToUpdate;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }
}
