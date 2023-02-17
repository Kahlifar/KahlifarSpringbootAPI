package ch.fwesterath.kahlifarspringapi.models.economy;

import ch.fwesterath.kahlifarspringapi.models.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "eco_wallet")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EconomyWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coins")
    private Float coins;

    @Column(name = "emeralds")
    private Integer emeralds;

    @OneToOne(mappedBy = "wallet")
    EconomyInventory inventory;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    User user;

    public EconomyWallet() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCoins() {
        return coins;
    }

    public void setCoins(Float coins) {
        this.coins = coins;
    }

    public Integer getEmeralds() {
        return emeralds;
    }

    public void setEmeralds(Integer emeralds) {
        this.emeralds = emeralds;
    }

    public EconomyInventory getInventory() {
        return inventory;
    }

    public void setInventory(EconomyInventory inventory) {
        this.inventory = inventory;
    }
}
