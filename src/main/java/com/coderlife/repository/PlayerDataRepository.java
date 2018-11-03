package com.coderlife.repository;

import com.coderlife.domain.PlayerData;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDataRepository extends CrudRepository<PlayerData, Integer> {
}
