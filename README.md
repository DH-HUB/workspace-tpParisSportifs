Documentation du Projet TRD - Plateforme de Paris Sportifs


Contexte: 
Dans le cadre du TP ce document décrit la conception et le développement d'une plateforme de paris sportifs en ligne, axée sur les matchs de football de Serie A, en suivant les principes du Domain-Driven Design (DDD). L'objectif est de créer une application flexible, capable de s'adapter et de s'étendre à d'autres sports et championnats à l'avenir.

Objectif du Projet:
Développer une plateforme de paris sportifs en ligne, en commençant par les matchs de football de Serie A, avec la capacité d'évoluer vers d'autres sports et compétitions. La plateforme doit servir à la fois les parieurs (front office) et les bookmakers (back office), en permettant la gestion des paris, la mise à jour des cotes, et la publication des résultats.

Fonctionnalités Clés:
-Gestion des comptes utilisateurs.
-Affichage et gestion des matchs disponibles.
-Placement et gestion des paris.
-Calcul et affichage des cotes.
-Notification des résultats.

Identification des Domaines et Sous-Domaines:

Core Domain : Gestion des paris sur les matchs de football.
Generic Subdomains : Authentification et gestion des utilisateurs, gestion financière.

Supporting Subdomains : Notification, logistique des matchs.


Event Storming / Example Mapping:
Identification des événements clés (Match Planifié, Pari Placé, Résultat du Match) et des commandes (Placer Pari), facilitant la compréhension des processus métier et des changements d'état.


Choix d'un Bounded Context
Bounded Context choisi : Gestion des paris sur les matchs de football. Ce contexte inclut le placement des paris, la gestion des côtes, et l'affichage des résultats des matchs.



2. Dictionnaire de données / Ubiquitous Language
Parieur : Utilisateur qui mise de l'argent sur les résultats des événements sportifs.
Bookmaker : Opérateur ou administrateur qui fixe les cotes pour chaque pari possible.
Match : Événement sportif spécifique sur lequel les paris sont placés.
Pari : Contrat entre le parieur et l'opérateur sur l'issue d'un match avec une cote déterminée.
Cote : Valeur qui multiplie la mise du parieur en cas de victoire.
Mise:  Montant placé sur un pari.
Gain : Montant reçu en cas de pari réussi.

Ticket de Pari : Preuve d'un pari placé, incluant les détails du pari.


3. Analyse et Conception
Use Case Diagram:

Illustration des cas d'utilisation principaux pour les parieurs et les bookmakers, tels que "Placer un Pari", "Configurer une Cote", et "Vérifier le Résultat d'un Match".
![image](https://github.com/DH-HUB/workspace-tpParisSportifs/assets/60735833/72303d6d-b689-4dcb-beeb-2059585a0a8b)



Activity Diagram:

Description du processus de placement d'un pari, depuis la sélection d'un match jusqu'à la soumission du pari.
![image](https://github.com/DH-HUB/workspace-tpParisSportifs/assets/60735833/97d405aa-c168-4811-8ec6-7383859e5ec7)




Sequence Diagram:
Détails de la communication entre le système et les utilisateurs lors du placement d'un pari, y compris les interactions avec la base de données pour vérifier la validité du pari. Le parieur initie un pari via l'Interface Utilisateur, qui transmet les détails au Système Pari. Ce dernier vérifie le solde avec le Système Compte; si suffisant, le montant est débité et le pari enregistré dans la Base De Données. Enfin, une confirmation est envoyée au parieur.


![image](https://github.com/DH-HUB/workspace-tpParisSportifs/assets/60735833/8972439c-cb97-4566-a318-f11f19be2b39)



Class Diagram:
Modèle des entités principales et leurs relations, comme Parieur, Pari, Match, et Cote, incluant les attributs et les méthodes de chaque classe.Le diagramme montre les classes principales du  système de paris sportifs, soulignant les relations entre parieurs, paris, matchs, cotes, et la gestion des comptes. Un parieur peut placer plusieurs paris, liés à des matchs et des cotes spécifiques, tandis que chaque parieur est associé à un compte unique géré par le système, reflétant le solde et les transactions.

![image](https://github.com/DH-HUB/workspace-tpParisSportifs/assets/60735833/ee91af5c-adef-4985-994c-646c9a92d37e)


Entity-Relationship Diagram:    
Représentation des relations entre les entités de données, montrant comment les parieurs, les paris, les matchs, et les cotes sont interconnectés.
4. Event Storming
Identification des événements clés, des commandes, et des agrégats principaux du domaine, tel que l'agrégat Pari qui peut inclure les événements PariPlacé, PariValidé, et PariPayé.
5. Context Mapping
Détermination des bounded contexts comme GestionDesParis et GestionDesMatchs, et des relations entre eux, pour identifier les modèles de collaboration tels que le partage ou le client-fournisseur.
7. Architecture et Microservices
Conception d'un diagramme d'architecture basé sur les microservices, en identifiant les services, leurs interactions, et les technologies de communication (REST, RabbitMQ pour les échanges asynchrones).



Technologie:

Backend : Il utilise Spring Boot pour le développement rapide de microservices avec des configurations préétablies et une facilité de déploiement.

Frontend : Choisis Vue.js pour son approche progressive et sa facilité d'intégration, permettant un développement rapide d'interfaces utilisateur réactives.

Base de Données : PostgreSQL, pour sa fiabilité et sa compatibilité avec les ORM comme Hibernate.

Communication : RabbitMQ pour gérer la communication asynchrone entre services.
Publish/Subscribe(gestion des notifications en temps réel) +  Work Queues(gestion des paris en arrière plan) +  Routing (acheminement des mises à jours  des scores pour le parieur concerné) 

Conteneurisation : Docker et Docker Compose pour empaqueter l'application et ses dépendances, simplifiant le déploiement et l'exécution dans différents environnements.
Développement

Frontend basique : Créer des interfaces simples pour l'inscription des utilisateurs, la visualisation et le placement des paris, et l'affichage des résultats.

API REST : Développe des points de terminaison pour la gestion des utilisateurs, des paris, et des matchs. Utilise Spring Data REST ou Spring MVC pour simplifier cette tâche.

Base de données : modélisé et crée la base de données. Utilise Hibernate pour simplifier l'intégration avec Spring Boot.

Message Queue : Configure RabbitMQ pour la gestion des notifications de résultats de matchs et autres communications asynchrones.
Docker & Docker Compose
Dockerise chaque partie de l'application pour assurer l'indépendance des environnements et faciliter le déploiement.
Utilise Docker Compose pour orchestrer les conteneurs, incluant l'application, la base de données, et RabbitMQ, garantissant leur bon fonctionnement ensemble.
Tests
Tests Unitaires :
 Écriture des tests pour les composants individuels en utilisant JUnit pour le backend et des outils appropriés pour le frontend et Jest pour Vue.js.
Tests d'Intégration : Tester  les interactions entre différents composants et services, y compris l'intégration avec la base de données et RabbitMQ.






