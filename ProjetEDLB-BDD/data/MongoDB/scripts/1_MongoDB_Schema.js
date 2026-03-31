// Connexion à la bse de donnée
db = db.getSiblingDB('edlbmongodb');  //Création OU utilisation de la BDD

db.createCollection("publication");
db.createCollection("media_reference");
db.createCollection("reaction_reference");
db.createCollection('comment');

db.publication.createIndex({ idUser: 1 }), { unique: true };
db.media_reference.createIndex({ idMedia: 1 }, { unique: true });
db.reaction_reference.createIndex({ idReaction: 1 }, { unique: true });
db.comment.createIndex({ idComment: 1 }, { unique: true });

