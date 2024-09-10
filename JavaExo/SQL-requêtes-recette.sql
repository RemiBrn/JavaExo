set search_path to exo03recette;
show search_path;

SERIAL PRIMARY KEY : Utilisé pour générer automatiquement un identifiant unique pour chaque entrée dans les tables.
Clés étrangères (REFERENCES ...) : Elles créent des relations entre les tables. Par exemple, recette_id dans Etape fait référence à id dans Recette. La clause ON DELETE CASCADE permet de supprimer automatiquement les étapes, commentaires ou relations d'ingrédients associés lorsqu'une recette est supprimée.
Table de jointure Recette_Ingredient : Utilisée pour gérer la relation plusieurs-à-plusieurs entre les recettes et les ingrédients.

CREATE TABLE Categorie (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE Recette (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    temps_prep INT NOT NULL,
    temps_cuisson INT NOT NULL,
    difficulte VARCHAR(50),
    categorie_id INT REFERENCES Categorie(id) ON DELETE SET NULL
);

CREATE TABLE Ingredient (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE Recette_Ingredient (
    recette_id INT REFERENCES Recette(id) ON DELETE CASCADE,
    ingredient_id INT REFERENCES Ingredient(id) ON DELETE CASCADE,
    PRIMARY KEY (recette_id, ingredient_id)
);

CREATE TABLE Etape (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    recette_id INT REFERENCES Recette(id) ON DELETE CASCADE
);

CREATE TABLE Commentaire (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    recette_id INT REFERENCES Recette(id) ON DELETE CASCADE
);





