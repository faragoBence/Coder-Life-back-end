package com.coderlife.repository.inventory;

import com.coderlife.domain.inventory.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
