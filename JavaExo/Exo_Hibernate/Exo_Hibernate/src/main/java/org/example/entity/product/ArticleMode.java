package org.example.entity.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.util.Categorie;

import javax.persistence.Entity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class ArticleMode extends Article{
    private String size;
    private Categorie categorie;




}
