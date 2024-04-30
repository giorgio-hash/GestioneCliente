DELETE FROM Ordine;
DELETE FROM Comanda;
DELETE FROM Piatto;
DELETE FROM IngredientePrincipale;
DELETE FROM Cliente;


INSERT INTO Cliente (ID, t_o_a) VALUES ('tavolo1',0);
INSERT INTO Cliente (ID, t_o_a) VALUES ('tavolo2',0);
INSERT INTO IngredientePrincipale (ID, nome) VALUES ('ZUCCVE','zucchina verde');
INSERT INTO Piatto (ID, ID_ingr_princ, descrizione, prezzo, t_preparazione) VALUES ('ZUCCLES','ZUCCVE','Zucchine lesse',10,400);
INSERT INTO IngredientePrincipale (ID, nome) VALUES ('CAARA','carota arancione');
INSERT INTO Piatto (ID, ID_ingr_princ, descrizione, prezzo, t_preparazione) VALUES ('ZUDICA','CAARA','zuppa di carote arancioni con panna',10,300);
