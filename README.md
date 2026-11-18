
# E-Bank Microservices Application

## 1. Présentation du projet

Ce projet consiste à concevoir et développer une application bancaire basée sur une architecture **Microservices**, en utilisant **Spring Boot** et **Spring Cloud**.

L'application permet de gérer les clients et leurs comptes bancaires à travers plusieurs microservices indépendants qui communiquent entre eux.

Le projet est réalisé en trois parties dans le cadre d'un travail académique.

## 2. Technologies utilisées

- Java
- Spring Boot
- Spring Cloud
- Spring Cloud Gateway
- Netflix Eureka
- OpenFeign
- Resilience4J
- Spring Data JPA
- REST API
- Swagger UI
- Postman
- Maven

## 3. Architecture du projet

Le projet est composé des microservices suivants :

| Microservice | Description |
|---|---|
| Customer-Service | Gestion des informations des clients. |
| EBank-Service | Gestion des comptes bancaires et communication avec Customer-Service. |
| Discovery-Service | Enregistrement et découverte des microservices. |
| Gateway-Service | Point d'entrée unique pour accéder aux différents microservices. |

## 4. Réalisation du projet

### Partie 1 : Architecture Microservices et communication

- Développement du Customer-Service.
- Développement du EBank-Service.
- Communication entre les deux services avec OpenFeign.
- Mise en place de la tolérance aux pannes avec Resilience4J (Circuit Breaker).
- Développement de l'API Gateway.
- Mise en place du Discovery Service.
- Test des services Backend avec Postman et Swagger UI.

### Screenshots :
<img src="screenshots/partie-1/1.png"/>
<hr/>
<img src="screenshots/partie-1/2.png"/>
<hr/>
<img src="screenshots/partie-1/3.png"/>
<hr/>
<img src="screenshots/partie-1/4.png"/>
<hr/>
<img src="screenshots/partie-1/5.png"/>

### Partie 2 : Intégration de l'Intelligence Artificielle avec Spring AI et MCP

Cette partie consiste à intégrer un agent conversationnel intelligent (AI Agent) à l'application E-Bank Microservices, en utilisant Spring AI et le protocole Model Context Protocol (MCP).

L'objectif est de permettre au chatbot d'interagir directement avec les microservices bancaires afin d'accéder à leurs fonctionnalités et de répondre aux demandes des utilisateurs.

#### 1. Développement de l'AI Agent
- Développement d'un AI Agent basé sur Spring AI.
- Mise en place du système de gestion des interactions conversationnelles.

#### 2. Intégration du protocole MCP
- Exposition des fonctionnalités des microservices via MCP.
- Test des fonctionnalités des microservices via un MCP Client.
- Connexion du chatbot aux microservices à l'aide du protocole MCP.

#### 3. Tests et intégration du Chatbot
- Test du chatbot avec un client REST.
- Intégration et test du chatbot avec un client Telegram.
- Intégration et test du chatbot avec un client Discord.

#### Screenshots

<img src="screenshots/partie-2/1.png" width="100%"/>

<hr/>

<img src="screenshots/partie-2/2.png" width="100%"/>

<hr/>

<img src="screenshots/partie-2/3.png" width="100%"/>

<hr/>

<img src="screenshots/partie-2/4.png" width="100%"/>

<hr/>

<img src="screenshots/partie-2/5.png" width="100%"/>

<hr/>

<img src="screenshots/partie-2/6.png" width="100%"/>



### Partie 3

À compléter.


HANANE TOUBALI