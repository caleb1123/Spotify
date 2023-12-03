package com.namphan.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int categoryId;

    @Column(columnDefinition = "varchar(20) not null")
    @JsonIgnore
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Collection<Song> songs;
}
