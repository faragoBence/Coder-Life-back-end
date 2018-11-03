package com.coderlife.repository.inventory;

import com.coderlife.domain.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
