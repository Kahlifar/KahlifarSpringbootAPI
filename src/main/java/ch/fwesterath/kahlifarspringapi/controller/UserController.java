package ch.fwesterath.kahlifarspringapi.controller;

import ch.fwesterath.kahlifarspringapi.models.User;
import ch.fwesterath.kahlifarspringapi.repository.DiscordUserRepository;
import ch.fwesterath.kahlifarspringapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DiscordUserRepository discordUserRepository;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

//    @GetMapping("/users/byDiscordId/{id}")
//    public User getUserByDiscordId(@PathVariable("id") String id) {
//        return discordUserRepository.findBy("discordId", id).getUser(), Long.class));
//    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this username already exists");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        try {
            User userToUpdate = userRepository.findById(id).get();
            System.out.println(userToUpdate.getUsername());
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setBirthday(user.getBirthday());
            userToUpdate.setDiscordUsers(user.getDiscordUsers());
            System.out.println(user.getDiscordUsers());
            return userToUpdate;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
