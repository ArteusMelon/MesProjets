#⚠️ATTENTION LE README N'EST PLUS A JOUR⚠️


# Configuration et Installation du Projet

Ce dépôt contient la configuration nécessaire pour mettre en place un environnement Docker avec PostgreSQL, MongoDB, CloudBeaver (DBeaver) et Mongo-Express pour la gestion des données.

## Docker Compose

Pour commencer, vous devrez configurer l'environnement Docker avec Docker Compose. Voici la configuration à utiliser.

## Installation

### Prérequis
- Docker installé sur votre machine.
- Docker Compose installé.

### Lancer Docker Compose

1. Clonez ce dépôt dans votre répertoire local.
2. Ouvrez un terminal et naviguez vers le répertoire du projet.
3. Exécutez la commande suivante pour démarrer les conteneurs avec Docker Compose:

```bash
docker compose up
```

Cela va démarrer les services suivants :

- **PostgreSQL** : Serveur de base de données PostgreSQL.
- **CloudBeaver (DBeaver)** : Interface graphique pour gérer les bases de données.
- **MongoDB** : Serveur de base de données MongoDB.
- **Mongo-Express** : Interface graphique pour MongoDB.

### Accéder à l'interface DBeaver

1. Ouvrez votre navigateur et accédez à l'URL suivante : `http://localhost:8081`.
2. Créez un compte administrateur pour le serveur DBeaver avec les informations suivantes :
   - **Login** : cdbadmin
   - **Mot de passe** : (votre mot de passe))
3. Ne changez pas le nom du serveur ni l'URL du serveur, cliquez sur "Next" puis sur "Finish".

### Connexion à la base de données PostgreSQL

1. Cliquez en haut à droite sur le logo de roue dentée 
![dbeaver menu login](./docs/dbeaver%20tuto%201.png)
pour accéder aux paramètres.
2. Cliquez sur "Login" et entrez vos identifiants de connexion à DBeaver.
3. Ensuite, cliquez sur le "+" en haut à gauche 
![dbeaver ajout serveur](./docs/dbeaver%20tuto%202.png) 
pour créer une nouvelle connexion.
4. Choisissez "Postgres" et remplissez les champs suivants :
   - **Host** : postgres
   - **Database** : edlbpostgres
   - **User name** : root
   - **User password** : root
5. Cochez la case **Save credentials for all users with access**, puis cliquez sur **Test** pour vérifier la connexion.
6. Si tout fonctionne, cliquez sur **Create**.

### Explications des autres services dans le docker-compose

1. **PostgreSQL** : Ce service utilise l'image `postgres:latest` et permet de stocker les données de votre projet.
   - Les variables d'environnement sont utilisées pour configurer l'utilisateur, le mot de passe et la base de données.
   - Le volume `${POSTGRES_SCRIPTS_DIR}` est monté pour exécuter les scripts d'initialisation au démarrage.

2. **CloudBeaver (DBeaver)** : Ce service vous permet d'accéder à une interface graphique pour gérer les bases de données.
   - Les ports sont mappés pour permettre l'accès via `localhost:8081`.

3. **MongoDB** : Ce service utilise l'image `mongo:latest` pour démarrer un serveur MongoDB.
   - Les variables d'environnement configurent l'utilisateur et le mot de passe administrateur.

4. **Mongo-Express** : Interface graphique pour MongoDB, accessible via `localhost:8085`.
   - Il dépend de MongoDB et permet de gérer les bases de données MongoDB via un navigateur.

### Persistance des données

- Vous pouvez activer la persistance des données pour PostgreSQL et MongoDB en décommentant les volumes correspondants dans le fichier `docker-compose.yml`.

### Données insérées et relation entre PostgreSQL et MongoDB

Les deux bases de données, PostgreSQL et MongoDB, contiennent des données pré-insérées lors de l'initialisation. Les UUID insérés dans la base MongoDB sont fiables et correspondent aux enregistrements de la base de données PostgreSQL. En effet, chaque entrée dans MongoDB est associée à une clé primaire UUID, qui est également présente dans PostgreSQL. Cela garantit une relation de cohérence entre les deux bases, permettant de faire correspondre les données de manière fiable et d'effectuer des jointures ou des vérifications croisées entre les deux systèmes de gestion de bases de données.

## Schéma de la base de donnée 

![Schema de la BDD postgres + mongo](./docs/EDLBv3_black.drawio%20.png) 

## Conclusion

Une fois tout configuré et lancé, vous pourrez gérer vos bases de données PostgreSQL et MongoDB via les interfaces graphiques CloudBeaver et Mongo-Express. Si vous avez des questions, n'hésitez pas à consulter la documentation de Docker et de DBeaver.

## ToDO
   - Créer un JSON pour les données de MongoDB plutôt qu'un script JS (exemple :https://github.com/afpa-learning/mongodb-docker/tree/main/initdb)
   - Ajouter des paramètres pour ne pas avoir à configurer DBeaver Cloud à la main.
   - Mieux expliquer la mise en place de la persistance.
