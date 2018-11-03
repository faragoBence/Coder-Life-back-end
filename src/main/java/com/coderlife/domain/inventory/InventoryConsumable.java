package com.coderlife.domain.inventory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inventories_consumables")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class InventoryConsumable {

    @Id
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventoryConsumables;

    @Id
    @ManyToOne
    @JoinColumn(name = "consumable_id")
    private Consumable consumable;

    @NotNull
    private int amount;
}
