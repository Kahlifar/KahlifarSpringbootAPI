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
@RequestMapping("/dcusers")
public class DiscordUserController {

    @Autowired
    DiscordUserRepository discordUserRepository;

    @GetMapping
    public Iterable<DiscordUser> getAllDiscordUsers() {
        return discordUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public DiscordUser getDiscordUserById(@PathVariable("id") Integer id) {
        return discordUserRepository.findById(id).get();
    }

    @GetMapping("/byDiscordId/{discordId}")
    public DiscordUser getDiscordUserByDiscordId(@PathVariable("discordId") Long discordId) {
        return discordUserRepository.findByDiscordId(discordId);
    }

    @PostMapping
    public DiscordUser createDiscordUser(@RequestBody DiscordUser discordUser) {
        try {
            return discordUserRepository.save(discordUser);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DiscordUser whith this discord id already exists");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @PutMapping("/{id}")
    public DiscordUser updateDiscordUser(@PathVariable("id") Long id, @RequestBody DiscordUser discordUser) {
        try {
            discordUser.setId(id);
            return discordUserRepository.save(discordUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }
}
