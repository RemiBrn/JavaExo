set search_path to exo02;

select * from adresse;


select * from student;

select * from examen;

select * from examen
	where 1 = 1 and id_student = 2;
	

DELETE FROM adresse
WHERE id_adresse = 1;

select * from product;

select * from produit_food;

select * from housing;

SELECT pf.*, pe.*, h.*, p.name, p.price
FROM product p
LEFT JOIN produit_food pf ON p.id = pf.id
LEFT JOIN product_electronic pe ON p.id = pe.id
LEFT JOIN housing h ON p.id = h.id;




