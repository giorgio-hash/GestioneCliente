# Gestione Cliente
Componente del sistema [ServeEasy](https://github.com/giorgio-hash/ServeEasy.git).

Il microservizio Gestione Cliente si occupa di implementare i seguenti casi d'uso del gruppo cliente:

UC-2 “effettuare un’ordinazione”, dettagliato:
- UC-2.1 : effettuare un ordine personalizzato, il cliente può effettuare un ordine escludendo un ingrediente o 
descrivendo una variazione del piatto

UC-3 “Visualizzare menu”, dettagliato:
- UC-3.1 : visualizzare piatto
- UC-3.2 : visualizzare informazioni piatto, il cliente deve poter leggere breve descrizione, ingredienti, prezzo

UC-4 “Autenticazione”, dettagliato:
- UC-4.1 : identificazione sessione cliente, al momento del pasto e solo per il pasto, il cliente deve poter distinguere la propria comanda

Nello specifico quindi GestioneCliente risolve gli use case del gruppo “cliente”, espone le funzionalità destinate ai 
dispositivi di tavolo ed al portale web per clienti d’asporto. Ha dunque il compito di gestire gli aspetti del servizio
legati alle interazioni del cliente col sistema, come la visualizzazione del menu, la creazione degli ordini ed il 
raggruppamento degli ordini in una comanda relativa.

La comunicazione con gli altri microservizi avviene tramite Message Broker come segue:
- Il microservizio [GestioneCliente](https://github.com/giorgio-hash/GestioneCliente) comunica verso [GestioneComanda](https://github.com/giorgio-hash/GestioneComanda) tramite il topic Kafka NotifyOrderEvent.

La comunicazione con il databse avviene tramite un adapter JPA

Il microservizio è stato implementato seguendo lo stile architetturale esagonale, seguendo lo schema port/adapter,
per questo motivo viene strutturato in 3 parti:

- ### Interface
  Adattatori ponte tra il mondo esterno e il core del sistema, consentono al microservizio di comunicare con altre applicazioni, servizi o dispositivi esterni in modo         indipendente dall'implementazione interna del sistema stesso. Sono presenti i seguenti Interface Adapter:
    - HTTPControllers: RestApiCliente, permette di esporre API verso l'esterno.
  
- ### Domain
  Definisce gli oggetti, le entità e le operazioni che sono pertinenti al problema che il microservizio gestisce.

- ### Infrastructure:
  Adattatori ponte tra il core del sistema e l'infrastruttura esterna, gestendo le chiamate e le operazioni necessarie per accedere e utilizzare le risorse infrastrutturali.     Sono presenti i seguenti Infrastructure Adapters:
    - Repository: JPAOrderAdapter e JPAMenuAdapter per la comunicazione con il database;
    - MessageBroker: PubOrderEvent per l'invio di messaggi sul topic verso il microservizio della cucina.

## Start
Apri Docker Desktop, apri un terminale e vai alla root directory del progetto e digita:
```shell
docker compose up
```
Manda in run il microservizio usando qualsiasi IDE oppure tramite Maven Wrapper con la seguente istruzione:
```shell
./mvnw clean install
./mvnw spring-boot:run
```

## User Interface

### Kafdrop
[Kafdrop](https://github.com/obsidiandynamics/kafdrop) è un'interfaccia utente Web per visualizzare i topic di Kafka
e sfogliare i gruppi dei consumers.
Lo strumento visualizza informazioni circa: brokers, topics, partitions, consumers, e consente di visualizzare i messaggi.

Apri un browser e vai all'indirizzo http://localhost:9000.

### phpMyAdmin
[phpMyAdmin](https://www.phpmyadmin.net/) è un'applicazione web che consente di amministrare un database MariaDB tramite un qualsiasi browser.

Apri un browser e vai all'indirizzo http://localhost:3307.

## API
Il microservizio GestioneCucina espone 3 API verso l'esterno per mezzo dell'adattarore RestApiCucina in HTTPControllers,
per la documentazione si rimanda alla documentazione completa via documenter.getpostman: https://documenter.getpostman.com/view/32004409/2sA3JFBQDv

## Test
E' possibile usufruire delle API per verificare il corretto funzionamento del sistema
via [Postman](https://web.postman.co//) tramite l'API all'indirizzo http://localhost:8080/...

### Test dei topic Kafka:
- ### Command Line Producer
    Utilizzare il seguente comando per pubblicare sul topic specificato un messaggio
    ```shell
    docker exec --interactive --tty broker kafka-console-producer --bootstrap-server broker:9092 --topic "notifyOrderEvent"
    ```

- ### Command Line Consumer
    Utilizzare il seguente comando per restare in ascolto sul topic specifico
    ```shell
    docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic "notifyOrderEvent" --from-beginning
    ```
### Test di integrazione e unità
E' possibile eseguire i test di integrazione e di unità tramite il Maven Wrapper, che è uno strumento che consente di eseguire i comandi Maven senza dover avere Maven installato globalmente sul sistema, tramite l'istruzione:
```shell
 ./mvnw clean verify
 ```
## Analisi Statica
### Checkstyle
In questo progetto è integrato un tool per l'analisi statica: 
[Apache Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/index.html)
Per generare il sito del progetto e i report eseguire:
```shell
 ./mvnw site
 ```
I file di report si troveranno in ```target/site```, in particolare il file di interesse è 
```checkstyle.html``` che è possibile aprire tramite un qualsiasi browser.

Per poter personalizzare le regole è possibile modificare il file ```checkstyle.xml``` e seguire le indicazioni 
dei commenti in apertura.
### Script Python
Inoltre è presente uno script python per generare i file csv e i grafici associati ai report, per poterlo avviare
è necessario avere python installato sulla propria macchina ed eseguire il seguente comando
per installare le librerie necessarie:
```shell
 pip install -r python/requirements.txt
 ```
Succesivamente eseguire il seguente per poter avviare lo script:
```shell
 python main.py
 ```
I file csv e le immagini png verranno salvati in ```target/output```.
