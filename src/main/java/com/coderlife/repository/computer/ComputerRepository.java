package com.coderlife.repository.computer;

import com.coderlife.domain.computer.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepository extends CrudRepository<Computer, Integer> {
}
