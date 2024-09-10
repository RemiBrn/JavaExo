package org.example.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.entity.Vente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private int id;
    private String description;
    private float prix;
    private int quantiteEnStock;
    private LocalDate dateRestock;

    @ManyToMany(mappedBy = "articles")
    private List<Vente> ventes;

}
