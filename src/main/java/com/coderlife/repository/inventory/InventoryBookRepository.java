package com.coderlife.repository.inventory;

import com.coderlife.domain.inventory.InventoryBook;
import org.springframework.data.repository.CrudRepository;

public interface InventoryBookRepository extends CrudRepository<InventoryBook, Integer> {
}
