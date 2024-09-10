package org.example.build01.batiment;

public class Chateau implements Batiment{

    private String style;
    private String taille;

    public Chateau(String style, int taille) {
        this.style = style;
        this.taille = taille;
    }


    @Override
    public void construire() {
        System.out.println(("Chateau de style " + style + " et de taille " + taille + " en construction");
    }

    @Override
    public String getDescription() {
        return String.format("Chateau de style %s et de taille %d", style, taille);
    }
}
