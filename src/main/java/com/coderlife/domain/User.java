package com.coderlife.domain;

import com.coderlife.domain.computer.Computer;
import com.coderlife.domain.house.House;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @OneToOne(mappedBy = "user_player_data")
    private PlayerData playerData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "computer_id")
    private Computer computer;


    @OneToOne(mappedBy = "houseOwner", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private House house;


    @ElementCollection
    @CollectionTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username")
    )
    @Column(name = "authority")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> authorities;


}
