package com.coderlife.repository.inventory;

import com.coderlife.domain.inventory.InventoryConsumable;
import org.springframework.data.repository.CrudRepository;

public interface InventoryConsumableRepository extends CrudRepository<InventoryConsumable, Integer> {
}
