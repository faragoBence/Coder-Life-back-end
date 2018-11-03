package com.coderlife.repository.inventory;

import com.coderlife.domain.inventory.Consumable;
import org.springframework.data.repository.CrudRepository;

public interface ConsumableRepository extends CrudRepository<Consumable, Integer> {
}
