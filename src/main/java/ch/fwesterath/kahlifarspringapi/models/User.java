package ch.fwesterath.kahlifarspringapi.models;

import ch.fwesterath.kahlifarspringapi.models.economy.EconomyInventory;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private Date birthday;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<DiscordUser> discordUsers;

    @OneToOne(mappedBy = "user")
    private EconomyInventory economyInventory;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", discordUsers=" + discordUsers +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<DiscordUser> getDiscordUsers() {
        return discordUsers;
    }

    public void setDiscordUsers(Set<DiscordUser> discordUsers) {
        this.discordUsers = discordUsers;
    }

    public EconomyInventory getEconomyInventory() {
        return economyInventory;
    }

    public void setEconomyInventory(EconomyInventory economyInventory) {
        this.economyInventory = economyInventory;
    }
}
