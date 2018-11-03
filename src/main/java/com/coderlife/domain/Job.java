package com.coderlife.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int salary;

    @NotNull
    @Column(name = "min_level")
    private int minimumLevel;

    @OneToMany(mappedBy = "job")
    private List<PlayerData> workers;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
}
