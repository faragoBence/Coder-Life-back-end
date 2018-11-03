package com.coderlife.domain.house;


import com.coderlife.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class House {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "houses_decorations",
            joinColumns = {@JoinColumn(name = "house_id")},
            inverseJoinColumns = {@JoinColumn(name = "decoration_id")}
    )
    List<House> houses;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @NotNull
    private int level;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User houseOwner;
    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;
    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;
    @ManyToOne
    @JoinColumn(name = "refrigerator_id")
    private Refrigerator refrigerator;
    @ManyToOne
    @JoinColumn(name = "table_id")
    private com.coderlife.domain.house.Table table;

}
