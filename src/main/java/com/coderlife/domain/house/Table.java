package com.coderlife.domain.house;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@javax.persistence.Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    @Column(name = "offline_earnings_duration")
    private int offlineEarningsDuration;

    @OneToMany(mappedBy = "table")
    private List<House> houses;
}
