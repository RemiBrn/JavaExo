package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.entity.product.Article;
import org.example.util.StatusVente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vente")
    private int id;
    private LocalDate dateVente;

    @Enumerated(EnumType.STRING)
    private StatusVente statusVente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "vente_article"
            ,joinColumns = @JoinColumn(name = "id_vente")
            ,inverseJoinColumns = @JoinColumn(name = "id_article"))
    private List<Article> articles;
}
