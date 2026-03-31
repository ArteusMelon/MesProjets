# 📌 Projet EDLB - README

Bienvenue dans le projet **EDLB** ! 🚀  
Ce projet est une application fullstack composée de plusieurs services containerisés via Docker. L'objectif est d'avoir un environnement de développement et de production stable, sécurisé et facilement déployable.

---

## 📂 Structure du projet

Le projet est organisé en plusieurs dossiers et fichiers :

### 🗂 Dossiers

- **`ProjetEDLB-BDD`** *(submodule)* : Contient le `docker-compose` des bases de données **MongoDB** et **PostgreSQL**.
- **`ProjetEDLB-Back`** *(submodule)* : Application **Spring Boot (Java 23)**.
  - **`docs/`** : Dossier où seront entreposés les documents.
    - **Environnement de travail Bruno** : Contient des tests **POST** et **GET** pré-configurés.
- **`ProjetEDLB-Front`** *(submodule)* : Application **React TypeScript**.
- **`nginx/`** : Contient le fichier `Dockerfile` et les fichiers de configuration Nginx :
  - `default.conf` (configuration du reverse proxy).
  - `server.crt` et `server.key` (certificat SSL autogénéré).

### 📄 Fichiers

- **`.dockerignore`** : Ignore certains fichiers comme `.env` de Spring Boot et `.vscode`.
- **`.env`** : Stocke les variables d’environnement utilisées pour le `docker-compose`.
- **`.gitmodules`** : Contient les liens vers les différents submodules.
- **`docker-compose.yml`** : Le `docker-compose` principal qui build et lance l’ensemble du projet.

---

## 🏗️ Services Docker

Le `docker-compose` principal lance **7 containers** :

1. 🖥 **Backend** *(Spring Boot Java 23)*
2. 🌐 **Frontend** *(React TypeScript)*
3. 🗄 **Base de données MongoDB**
4. 🗄 **Base de données PostgreSQL**
5. 📊 **Mongo Express** *(visualisation de MongoDB)* → http://localhost:8085/
6. 📊 **DBeaver** *(visualisation de PostgreSQL et autres BDD)* → http://localhost:8081/
7. 🔒 **Nginx Reverse Proxy** *(redirection HTTP → HTTPS et sécurisation de l’application)*

📌 **À savoir :**
- Les bases de données sont buildées séparément dans `ProjetEDLB-BDD` pour une meilleure gestion et modification avant mise en production.
- L’ensemble de l’application est **100% fonctionnelle en local** via :
  - **HTTP** : http://localhost:7070/
  - **HTTPS** : https://localhost *(Certificat autogénéré, voir tuto ci-dessous)*

---

## 🔧 Installation et lancement

### 🛠 Prérequis

- **Docker** et **Docker Compose** installés sur votre machine.
- **Git** installé pour récupérer les submodules.

### 🚀 Installation

1. **Cloner le projet et ses submodules**
   ```sh
   git clone --recurse-submodules git@github.com:Etoile-du-loup-blanc/ProjetEDLB.git
   ```
2. **Se placer dans le dossier du projet**
   ```sh
   cd ProjetEDLB
   ```
3. **Lancer l’application**
   ```sh
   docker-compose up
   ```
4. **Accéder aux services**
   - Backend (API) : http://localhost:7070/
   - Frontend : http://localhost:7070/
   - PostgreSQL (DBeaver) : http://localhost:8081/
   - MongoDB (Mongo Express) : http://localhost:8085/

---

## 🔒 Certificat SSL et configuration Postman/Bruno

L’application utilise un certificat **auto-signé** pour HTTPS, ce qui nécessite une configuration spécifique dans **Postman** ou **Bruno** :

### 📝 Postman
1. Ouvrir **Postman**.
2. Aller dans **Settings** > **Certificates**.
3. Désactiver **SSL Certificate Verification**.

### 📝 Bruno
1. Ouvrir **Bruno**.
2. Aller dans **Settings** > **SSL/TLS**.
3. Désactiver **SSL Verification**.

---

## 🎯 Développement local et tests

### 🏗 Lancer uniquement le backend

Si vous souhaitez développer uniquement le **backend** en local sans tout relancer :

1. Aller dans le dossier **ProjetEDLB-Back**
   ```sh
   cd ProjetEDLB-Back
   ```
2. Utiliser **Visual Studio Code** :
   - Grâce au fichier `.vscode/launch.json`, les **variables d’environnement** sont automatiquement chargées.
3. API accessible sur **http://localhost:9090/api/votre_end_point**

---

## ⚙️ Configuration Docker

### ✅ Avantages

- Développement **Spring Boot** sur la même base que la production.
- Tests locaux facilités grâce à des bases de données **pré-remplies** avec des **données fictives**.
- **Sécurisation** de l’application grâce à **Nginx** (HTTPS et Reverse Proxy).
- Visualisation des bases de données via **Mongo Express** et **DBeaver**.
- **Déploiement simplifié** sur serveur via `docker-compose up` sans modifications.

📌 **Remarque :** Pour plus d’informations sur la gestion des bases de données, consultez le `README` de **ProjetEDLB-BDD**.

---

## 🛠 Commandes utiles

📌 **Démarrer l’application** :
```sh
docker-compose up
```

📌 **Arrêter l’application** :
```sh
docker-compose down
```

📌 **Mettre à jour les submodules** :
```sh
git submodule update --remote --merge
```

📌 **Supprimer les containers et volumes** *(⚠️ Reset complet !)* :
```sh
docker-compose down -v
```
