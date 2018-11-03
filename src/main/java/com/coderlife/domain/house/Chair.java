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
@Table(name = "chairs")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    @Column(name = "max_energy_value")
    private int MaxEnergyValue;

    @OneToMany(mappedBy = "chair")
    private List<House> houses;
}
