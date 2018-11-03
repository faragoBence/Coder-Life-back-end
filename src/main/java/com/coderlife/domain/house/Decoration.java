package com.coderlife.domain.house;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "decorations")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    @Column(name = "click_multiplier")
    private double clickMultiplier;

    @ManyToMany(mappedBy = "houses")
    private List<Decoration> decorations;

}
