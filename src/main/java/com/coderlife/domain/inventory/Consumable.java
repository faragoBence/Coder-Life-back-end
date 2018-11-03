package com.coderlife.domain.inventory;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "consumables")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Consumable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @Column(name = "hunger_refill")
    private int hungerRefill;

    @Column(name = "energy_refill")
    private int energyRefill;

    @OneToMany(
            mappedBy = "consumable",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<InventoryConsumable> inventoryConsumables;


}
