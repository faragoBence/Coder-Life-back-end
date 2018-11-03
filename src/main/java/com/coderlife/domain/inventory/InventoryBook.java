package com.coderlife.domain.inventory;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "inventories_books")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class InventoryBook {

    @Id
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventoryBooks;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull
    private int amount;
}
