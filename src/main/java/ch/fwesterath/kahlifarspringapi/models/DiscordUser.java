package ch.fwesterath.kahlifarspringapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dc_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DiscordUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date firstJoinDate;

    @Column(nullable = false)
    private Date lastJoinDate;

    @Column(nullable = true)
    private Date leaveDate;

    @Column(unique = true)
    private Long discord_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public DiscordUser() {
    }

    @Override
    public String toString() {
        return "DiscordUser{" +
                "id=" + id +
                ", firstJoinDate=" + firstJoinDate +
                ", lastJoinDate=" + lastJoinDate +
                ", leaveDate=" + leaveDate +
                ", discord_id=" + discord_id +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstJoinDate() {
        return firstJoinDate;
    }

    public void setFirstJoinDate(Date firstJoinDate) {
        this.firstJoinDate = firstJoinDate;
    }

    public Date getLastJoinDate() {
        return lastJoinDate;
    }

    public void setLastJoinDate(Date lastJoinDate) {
        this.lastJoinDate = lastJoinDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Long getDiscord_id() {
        return discord_id;
    }

    public void setDiscord_id(Long discord_id) {
        this.discord_id = discord_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
