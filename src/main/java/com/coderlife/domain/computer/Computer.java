package com.coderlife.domain.computer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "computers")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Computer {

    @ManyToOne
    @JoinColumn(name = "vga_id")
    private Vga vga;

    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private Cpu cpu;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Ram ram;

    @ManyToOne
    @JoinColumn(name = "psu_id")
    private Psu psu;

    @ManyToOne
    @JoinColumn(name = "hdd_id")
    private Hdd hdd;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "computers_ides",
            joinColumns = @JoinColumn(name = "ide_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id",
                    referencedColumnName = "id"))
    private List<Ide> ides;
}
