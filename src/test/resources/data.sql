USE serveeasy;

INSERT INTO Cliente (ID, t_o_a) VALUES ('tavolo1',0);
INSERT INTO IngredientePrincipale (ID, nome) VALUES ('CAARA','carota arancione');
INSERT INTO Piatto (ID,ID_ingr_princ,descrizione,prezzo,t_preparazione) VALUES ('ZUDICA','CAARA','zuppa di carote arancioni con panna',10,300);
INSERT INTO Piatto (ID,ID_ingr_princ,descrizione,prezzo,t_preparazione) VALUES ('CAJULI','CAARA','carote alla Julienne',10,300);