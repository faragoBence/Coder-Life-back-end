package com.coderlife.domain.computer;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "rams")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Ram {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    @Column(name = "req_power")
    private int requiredPower;

    @NotNull
    @Column(name = "experience_multiplier")
    private double experienceMultiplier;

    @OneToMany(mappedBy = "psu")
    private List<Computer> computers;
}
