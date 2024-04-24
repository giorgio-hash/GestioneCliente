CREATE SCHEMA IF NOT EXISTS serveeasy;
SET SCHEMA serveeasy;

CREATE TABLE IF NOT EXISTS Cliente(
                                      ID VARCHAR(10) PRIMARY KEY,
                                      t_o_a BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Comanda (
                                       ID INT AUTO_INCREMENT,
                                       ID_cliente VARCHAR(10) NOT NULL,
                                       codice_pagamento VARCHAR,
                                       totale_scontrino FLOAT DEFAULT 0.0,
                                       PRIMARY KEY (ID),
                                       FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID)
);

CREATE TABLE IF NOT EXISTS IngredientePrincipale(
                                                    ID VARCHAR(20) PRIMARY KEY,
                                                    nome VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS Piatto(
                                     ID VARCHAR(20) NOT NULL PRIMARY KEY,
                                     ID_ingr_princ VARCHAR(20) NOT NULL,
                                     descrizione VARCHAR(50),
                                     prezzo FLOAT NOT NULL,
                                     `t_preparazione` INT NOT NULL,
                                     FOREIGN KEY (ID_ingr_princ) REFERENCES IngredientePrincipale(ID)
);

CREATE TABLE IF NOT EXISTS Ordine(
                                     ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     ID_comanda INT NOT NULL,
                                     ID_piatto VARCHAR(20) NOT NULL,
                                     stato INT DEFAULT 0, -- 0=in preparazione, 1=completato
                                     t_ordinazione TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     urgenza_cliente INT DEFAULT 0, -- priorità del cliente: 1=massima, -1=minima
                                     FOREIGN KEY (ID_comanda) REFERENCES Comanda(ID),
                                     FOREIGN KEY (ID_piatto) REFERENCES Piatto(ID),
                                     CHECK (stato >= 0 AND stato <=1 )
);
