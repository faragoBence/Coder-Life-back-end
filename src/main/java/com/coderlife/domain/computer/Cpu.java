package com.coderlife.domain.computer;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "cpus")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Cpu {

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
    @Column(name = "offline_earnings_multiplier")
    private double offlineEarningsMultiplier;

    @OneToMany(mappedBy = "cpu")
    private List<Computer> computers;
}
