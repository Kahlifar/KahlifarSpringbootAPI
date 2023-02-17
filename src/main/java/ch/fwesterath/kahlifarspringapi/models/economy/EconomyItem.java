package ch.fwesterath.kahlifarspringapi.models.economy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import ch.fwesterath.kahlifarspringapi.helper.economy.ItemType;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "eco_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EconomyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String value;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<EconomyInventory> inventories;

    public EconomyItem() {}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<EconomyInventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<EconomyInventory> inventories) {
        this.inventories = inventories;
    }

    public void addInventory(EconomyInventory inventory) {
        this.inventories.add(inventory);
    }

    public void removeInventory(EconomyInventory inventory) {
        this.inventories.remove(inventory);
    }

    @Override
    public String toString() {
        return "EconomyItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
