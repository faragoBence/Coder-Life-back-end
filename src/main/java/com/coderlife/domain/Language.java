package com.coderlife.domain;


import com.coderlife.domain.inventory.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "programming_languages")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;


    @OneToMany(mappedBy = "language")
    private List<Book> books;
}
