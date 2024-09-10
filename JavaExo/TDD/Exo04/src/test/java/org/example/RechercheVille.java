package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private RechercheVille rechercheVille;

    @BeforeAll
    public void setUp() {
        List<String> villes = List.of(
                "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
                "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
                "Hong Kong", "Dubaï", "Rome", "Istanbul"; "Tokyo", "Osaka", "Bruxelles"
        );
        rechercheVille = new RechercheVille(villes);
    }

    @Test
    public void testRechercheMoinsDeDeuxCaracteres() {

    }

    @Test
    public void testRechercheAvecDeuxCaracteres() {
        String

        // Vérifie les villes commençant par "Va"
        List<String> result = rechercheVille.rechercher("Va");
        assertEquals(Arrays.asList("Valence", "Vancouver"), result);
    }


}
