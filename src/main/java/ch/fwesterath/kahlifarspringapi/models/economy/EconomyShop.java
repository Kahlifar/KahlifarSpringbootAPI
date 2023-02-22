package ch.fwesterath.kahlifarspringapi.models.economy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "eco_shop")
public class EconomyShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isOpen;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "eco_shop_items",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<EconomyItem> items;

    public EconomyShop() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isOpen")
    public Boolean getOpen() {
        return isOpen;
    }

    @JsonProperty("isOpen")
    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Set<EconomyItem> getItems() {
        return items;
    }

    public void setItems(Set<EconomyItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EconomyShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isOpen=" + isOpen +
                ", items=" + items +
                '}';
    }
}
