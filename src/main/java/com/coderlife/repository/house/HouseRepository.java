package com.coderlife.repository.house;

import com.coderlife.domain.house.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Integer> {
}
