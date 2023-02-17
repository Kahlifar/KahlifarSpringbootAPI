package ch.fwesterath.kahlifarspringapi.models.economy;

import ch.fwesterath.kahlifarspringapi.models.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "eco_inventory")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EconomyInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    EconomyWallet wallet;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "eco_inventory_items",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<EconomyItem> items;

    public EconomyInventory() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EconomyWallet getWallet() {
        return wallet;
    }

    public void setWallet(EconomyWallet wallet) {
        this.wallet = wallet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<EconomyItem> getItems() {
        return items;
    }

    public void setItems(List<EconomyItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EconomyInventory{" +
                "id=" + id +
                ", wallet=" + wallet +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
