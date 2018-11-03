package com.coderlife.domain.computer;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "psus")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Psu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    @Column(name = "power_unit")
    private int powerUnit;

    @OneToMany(mappedBy = "psu")
    private List<Computer> computers;
}
