set search_path to exo02;

show search_path;


CREATE TABLE animaux (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(25) NOT NULL,
    race VARCHAR(50),
    description TEXT,
    habitat VARCHAR(100),
    age INT
);


INSERT INTO animaux (nom, race, description, habitat, age) VALUES
('Noisette', 'lion', 'Un grand félin carnivore', 'Savane africaine', 8),
('Goliath', 'éléphant', 'Le plus grand mammifère terrestre', 'Savane africaine', 25),
('Blizzard', 'pingouin', 'Oiseau marin incapable de voler', 'Antarctique', 15),
('Bambou', 'panda', 'Mammifère emblématique de la Chine', 'Forêts de bambous', 5),
('Echo', 'dauphin', 'Cétacé très intelligent et sociable', 'Océans et mers', 12);

DELETE FROM animaux WHERE id = 9;


select * from animaux


-- Insérer des repas pour chaque animal

CREATE TABLE IF NOT EXISTS repas (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    animal_id INT NOT NULL,
    race_animal VARCHAR(50) NOT NULL,
    gardien_id INT NOT NULL,
    date_repas DATE NOT NULL,
    heure_repas TIME NOT NULL,
    details_nourriture TEXT NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animaux(id),
    FOREIGN KEY (race_animal) REFERENCES animaux(race),
    FOREIGN KEY (gardien_id) REFERENCES gardiens(id)
);


INSERT INTO repas (animal_id, race_animal, gardien_id, date_repas, heure_repas, details_nourriture) VALUES
-- Pour Noisette (lion)
(1, 'lion', 1, '2024-08-20', '09:00:00', 'Viande de boeuf fraîche'),
-- Pour Goliath (éléphant)
(2, 'éléphant', 2, '2024-08-20', '11:00:00', 'Fruits variés et légumes'),
-- Pour Blizzard (pingouin)
(3, 'pingouin', 3, '2024-08-21', '10:30:00', 'Poissons congelés'),
-- Pour Bambou (panda)
(4, 'panda', 1, '2024-08-22', '14:00:00', 'Bambou frais et fruits'),
-- Pour Echo (dauphin)
(5, 'dauphin', 2, '2024-08-22', '16:00:00', 'Poissons et calamars'),
-- Pour Alphonse (hérisson)
(8, 'hérisson', 3, '2024-08-23', '08:00:00', 'Insectes et fruits'),
-- Pour Léon (lion)
(10, 'lion', 1, '2024-08-23', '12:00:00', 'Viande de poulet fraîche');




