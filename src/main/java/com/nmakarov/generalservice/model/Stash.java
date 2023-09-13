package com.nmakarov.generalservice.model;

import javax.persistence.* ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "stash")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Stash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "stash")
    private List<Item> items;
}
