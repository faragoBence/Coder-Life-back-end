package com.coderlife.domain.computer;


import com.coderlife.domain.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ides")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Ide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @NotNull
    private String title;

    @NotNull
    @Column(name = "req_space")
    private int requiredSpace;

    @NotNull
    @Column(name = "click_multiplier")
    private double clickMultiplier;

    @ManyToMany(mappedBy = "ides")
    private List<Computer> computers = new ArrayList<>();
}
