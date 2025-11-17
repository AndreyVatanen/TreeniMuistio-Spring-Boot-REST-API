TreeniMuistio on yksinkertainen Spring Boot -pohjainen harjoitusprojekti, jonka tarkoituksena on mallintaa treenipäiväkirjan backend-puolta. Projektissa on kolme keskeistä entiteettiä:

Käyttäjä (Kayttaja)

TreeniSessio (treenipäivä / harjoituskerta)

TreeniLiike (yksittäinen liike treenissä)

Sovellus tarjoaa REST-rajapinnan treenien hallintaan: käyttäjän luomiseen, treenisessioiden lisäämiseen ja liikkeiden tallentamiseen.


Relaatiot

- Käyttäjällä voi olla monta treenisessiota

- Treenisessiossa voi olla monta treeniliikettä

- Treeniliike kuuluu yhteen sessioon


Projekti on harjoitus REST API -suunnittelusta ja Spring Bootin käytöstä.
Tavoitteena oli:

- oppia mallintamaan reaalimaailman entiteettejä

- harjoitella JPA-relaatiota

- rakentaa toimiva backend pienelle sovellukselle

- käyttää controller–service–repository -rakennetta
