package com.coderlife.domain.inventory;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Inventory {


    @OneToMany(mappedBy = "inventoryConsumables")
    private List<InventoryConsumable> inventoryConsumables;

    @OneToMany(mappedBy = "inventoryBooks")
    private List<InventoryBook> inventoryBooks;

    @NotNull
    private int capacity;
}
