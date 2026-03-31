// Connexion à la bse de donnée
db = db.getSiblingDB('edlbmongodb'); //Création OU utilisation de la BDD
// Création des ObjectId pour une utilisation ultérieure
const media1 = new ObjectId();
const media2 = new ObjectId();
const media3 = new ObjectId();
const media4 = new ObjectId();
const media5 = new ObjectId();
const media6 = new ObjectId();
const media7 = new ObjectId();
const media8 = new ObjectId();

const reaction1 = new ObjectId();
const reaction2 = new ObjectId();
const reaction3 = new ObjectId();
const reaction4 = new ObjectId();
const reaction5 = new ObjectId();

const comment1 = new ObjectId();
const comment2 = new ObjectId();
const comment3 = new ObjectId();
const comment4 = new ObjectId();
const comment5 = new ObjectId();
const comment6 = new ObjectId();
const comment7 = new ObjectId();
const comment8 = new ObjectId();
const comment9 = new ObjectId();
const comment10 = new ObjectId();
const comment11 = new ObjectId();
const comment12 = new ObjectId();
const comment13 = new ObjectId();
const comment14 = new ObjectId();
const comment15 = new ObjectId();
const comment16 = new ObjectId();
const comment17 = new ObjectId();
const comment18 = new ObjectId();
const comment19 = new ObjectId();
const comment20 = new ObjectId();

const user1UUID = "123e4567-e89b-12d3-a456-426614174000";
const user2UUID = "123e4567-e89b-12d3-a456-426614174001";
const user3UUID = "123e4567-e89b-12d3-a456-426614174002";
const user4UUID = "123e4567-e89b-12d3-a456-426614174003";
const user5UUID = "123e4567-e89b-12d3-a456-426614174004";
const user6UUID = "123e4567-e89b-12d3-a456-426614174005";
const user7UUID = "123e4567-e89b-12d3-a456-426614174006";

// Insertion des données dans la collection 'reaction_reference'
db.reaction_reference.insertMany([
  { idReaction: reaction1, name: "Like", uri: "/like", description: "Exprime une appréciation positive" },
  { idReaction: reaction2, name: "Love", uri: "/love", description: "Exprime un amour ou une forte appréciation" },
  { idReaction: reaction3, name: "Angry", uri: "/angry", description: "Exprime une colère ou une frustration" },
  { idReaction: reaction4, name: "Sad", uri: "/sad", description: "Exprime de la tristesse ou de l'empathie" },
  { idReaction: reaction5, name: "Wow", uri: "/wow", description: "Exprime une surprise ou une admiration" }
]);

// Insertion des données dans la collection 'media'
db.media_reference.insertMany([
  { 
    idMedia: media1, 
    type: "image", 
    mediaName: "chien_1.jpg", 
    uploadDate: new Date("2025-01-01T10:00:00Z"), 
    commentMedia: "Un magnifique berger allemand en pleine course." 
  },
  { 
    idMedia: media2, 
    type: "video", 
    mediaName: "chien_jeu.mp4", 
    uploadDate: new Date("2025-01-05T14:30:00Z"), 
    commentMedia: "Vidéo d'un chiot jouant dans le jardin." 
  },
  { 
    idMedia: media3, 
    type: "image", 
    mediaName: "chiots_dormants.jpg", 
    uploadDate: new Date("2025-01-10T09:15:00Z"), 
    commentMedia: "Une portée de chiots endormis après une longue journée." 
  },
  { 
    idMedia: media4, 
    type: "video", 
    mediaName: "dressage_chien.mp4", 
    uploadDate: new Date("2025-02-01T11:00:00Z"), 
    commentMedia: "Séance de dressage avec un berger australien." 
  },
  { 
    idMedia: media5, 
    type: "image", 
    mediaName: "balade_foret.jpg", 
    uploadDate: new Date("2025-02-05T16:00:00Z"), 
    commentMedia: "Une belle balade en forêt avec un husky." 
  },
  { 
    idMedia: media6, 
    type: "video", 
    mediaName: "chiots_nourriture.mp4", 
    uploadDate: new Date("2025-03-01T13:45:00Z"), 
    commentMedia: "Vidéo de chiots découvrant leur premier repas solide." 
  },
  { 
    idMedia: media7, 
    type: "image", 
    mediaName: "chien_plage.jpg", 
    uploadDate: new Date("2025-03-10T08:20:00Z"), 
    commentMedia: "Un golden retriever profitant d'une journée à la plage." 
  }
]);


// Insertions des données commentaires 
db.comment.insertMany([
  {
    idComment: comment1,
    dateOfComment: new Date("2025-01-02T08:15:00Z"),
    messageComment: "Ce berger allemand est magnifique !",
    idUser: user1UUID,
    mediaId: [media1, media4],
    reactionId: [reaction1, reaction3]
  },
  {
    idComment: comment2,
    dateOfComment: new Date("2025-01-06T12:30:00Z"),
    messageComment: "J'adore cette vidéo, le chiot est trop mignon !",
    idUser: user2UUID,
    mediaId: [media2],
    reactionId: [reaction2, reaction4]
  },
  {
    idComment: comment3,
    dateOfComment: new Date("2025-01-11T15:45:00Z"),
    messageComment: "Rien de plus beau que des chiots qui dorment. 🐶",
    idUser: user3UUID,
    mediaId: [],
    reactionId: [reaction1]
  },
  {
    idComment: comment4,
    dateOfComment: new Date("2025-01-15T09:10:00Z"),
    messageComment: "Ce dressage est impressionnant, beau travail !",
    idUser: user4UUID,
    mediaId: [],
    reactionId: [reaction5, reaction3]
  },
  {
    idComment: comment5,
    dateOfComment: new Date("2025-02-02T18:20:00Z"),
    messageComment: "Le husky a l'air d'adorer sa balade en forêt.",
    idUser: user5UUID,
    mediaId: [media5, media7],
    reactionId: [reaction2, reaction4, reaction5]
  },
  {
    idComment: comment6,
    dateOfComment: new Date("2025-02-06T21:00:00Z"),
    messageComment: "Trop drôle comment ils découvrent leur nourriture !",
    idUser: user6UUID,
    mediaId: [media6],
    reactionId: [reaction1]
  },
  {
    idComment: comment7,
    dateOfComment: new Date("2025-02-10T10:30:00Z"),
    messageComment: "Wow, la plage et le chien, c'est une photo parfaite !",
    idUser: user7UUID,
    mediaId: [media7],
    reactionId: [reaction3, reaction5]
  },
  {
    idComment: comment8,
    dateOfComment: new Date("2025-02-12T14:50:00Z"),
    messageComment: "Ça donne envie d'aller se promener avec son chien. 😊",
    idUser: user1UUID,
    mediaId: [],
    reactionId: [reaction2, reaction4]
  },
  {
    idComment: comment9,
    dateOfComment: new Date("2025-02-15T08:05:00Z"),
    messageComment: "Une vraie complicité entre le maître et son chien !",
    idUser: user2UUID,
    mediaId: [media4],
    reactionId: [reaction1, reaction3]
  },
  {
    idComment: comment10,
    dateOfComment: new Date("2025-02-18T19:40:00Z"),
    messageComment: "J’adore cette photo, elle dégage une belle énergie.",
    idUser: user3UUID,
    mediaId: [media1],
    reactionId: []
  },
  {
    idComment: comment11,
    dateOfComment: new Date("2025-02-20T11:25:00Z"),
    messageComment: "On dirait que ce golden retriever adore l’eau !",
    idUser: user4UUID,
    mediaId: [media7],
    reactionId: [reaction4, reaction5]
  },
  {
    idComment: comment12,
    dateOfComment: new Date("2025-02-25T16:35:00Z"),
    messageComment: "Quelle belle meute de chiots !",
    idUser: user5UUID,
    mediaId: [media3],
    reactionId: [reaction1, reaction3]
  },
  {
    idComment: comment13,
    dateOfComment: new Date("2025-03-01T22:15:00Z"),
    messageComment: "Le dressage demande tellement de patience, bravo !",
    idUser: user6UUID,
    mediaId: [media4],
    reactionId: [reaction5]
  },
  {
    idComment: comment14,
    dateOfComment: new Date("2025-03-04T14:00:00Z"),
    messageComment: "Un chien heureux, c’est tout ce qui compte. 😍",
    idUser: user7UUID,
    mediaId: [media5, media7],
    reactionId: [reaction2]
  },
  {
    idComment: comment15,
    dateOfComment: new Date("2025-03-05T09:45:00Z"),
    messageComment: "Cette photo devrait être un fond d’écran !",
    idUser: user1UUID,
    mediaId: [media1],
    reactionId: [reaction3, reaction4]
  },
  {
    idComment: comment16,
    dateOfComment: new Date("2025-03-06T13:30:00Z"),
    messageComment: "Tellement beau, on sent l’amour pour ces chiens !",
    idUser: user2UUID,
    mediaId: [media3],
    reactionId: [reaction5]
  },
  {
    idComment: comment17,
    dateOfComment: new Date("2025-03-08T20:20:00Z"),
    messageComment: "Ce chiot est une vraie boule d’énergie !",
    idUser: user3UUID,
    mediaId: [],
    reactionId: [reaction1, reaction2]
  },
  {
    idComment: comment18,
    dateOfComment: new Date("2025-03-10T17:10:00Z"),
    messageComment: "Le cadre est magnifique, ça donne envie d’y être.",
    idUser: user4UUID,
    mediaId: [media5],
    reactionId: [reaction4, reaction3]
  },
  {
    idComment: comment19,
    dateOfComment: new Date("2025-03-12T12:55:00Z"),
    messageComment: "Un vrai plaisir de voir des chiens aussi heureux !",
    idUser: user5UUID,
    mediaId: [media6, media7],
    reactionId: [reaction2, reaction5]
  },
  {
    idComment: comment20,
    dateOfComment: new Date("2025-02-10T12:55:00Z"),
    messageComment: "Un vrai plaisir !",
    idUser: user2UUID,
    mediaId: [],
    reactionId: []
  }
]);



// Insertion des données dans la collection 'publication'
db.publication.insertMany([
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-01T08:00:00Z"),
    messagePublication: "Bonne année 2025 ! Voici nos premières nouvelles.",
    idUser: user1UUID,
    mediaId: [media1, media2],
    reactionId: [reaction1, reaction2],
    commentId: [comment1, comment2]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-15T10:00:00Z"),
    messagePublication: "Nous venons de lancer un nouveau produit ! Découvrez-le maintenant.",
    idUser: user2UUID,
    mediaId: [media3],
    reactionId: [reaction3],
    commentId: []
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-20T14:00:00Z"),
    messagePublication: "Retour sur notre événement de lancement, c'était incroyable ! Merci à tous ceux qui ont participé.",
    idUser: user3UUID,
    mediaId: [media4],
    reactionId: [reaction2, reaction4],
    commentId: [comment3, comment4, comment5]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-03-01T12:00:00Z"),
    messagePublication: "Nos équipes sont prêtes pour le grand salon de la tech ! Venez nous voir.",
    idUser: user4UUID,
    mediaId: [media5],
    reactionId: [reaction1],
    commentId: []
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-10T16:30:00Z"),
    messagePublication: "Un grand merci à tous nos clients pour leur fidélité.",
    idUser: user5UUID,
    mediaId: [media6],
    reactionId: [reaction3, reaction4, reaction5],
    commentId: [comment6]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-05T09:30:00Z"),
    messagePublication: "Faites connaissance avec notre équipe, ce mois-ci, focus sur Sarah !",
    idUser: user6UUID,
    mediaId: [media2],
    reactionId: [reaction5],
    commentId: [comment7]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-25T11:00:00Z"),
    messagePublication: "Nos produits viennent de recevoir des avis incroyables, merci à nos utilisateurs !",
    idUser: user7UUID,
    mediaId: [media3],
    reactionId: [reaction1, reaction3],
    commentId: []
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-20T13:15:00Z"),
    messagePublication: "Une nouvelle version de notre application est disponible !",
    idUser: user1UUID,
    mediaId: [media4, media5],
    reactionId: [reaction2],
    commentId: [comment8, comment9]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-03-10T15:00:00Z"),
    messagePublication: "Découvrez les coulisses de notre dernière campagne de marketing.",
    idUser: user2UUID,
    mediaId: [media6],
    reactionId: [reaction4],
    commentId: [comment10, comment11]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-15T12:00:00Z"),
    messagePublication: "Une journée de formation passionnante pour notre équipe !",
    idUser: user3UUID,
    mediaId: [media7],
    reactionId: [reaction1, reaction5],
    commentId: [comment12, comment13]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-03T17:45:00Z"),
    messagePublication: "Nous sommes très fiers de cette collaboration avec un grand nom de l'industrie.",
    idUser: user4UUID,
    mediaId: [media1, media6],
    reactionId: [reaction2],
    commentId: [comment14]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-30T19:00:00Z"),
    messagePublication: "Notre équipe vient de recevoir une récompense pour l'excellence du service.",
    idUser: user5UUID,
    mediaId: [media2],
    reactionId: [reaction3, reaction4],
    commentId: [comment15, comment16]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-25T18:15:00Z"),
    messagePublication: "Une nouvelle fonctionnalité est disponible dans notre application. Plus de détails sur notre blog.",
    idUser: user6UUID,
    mediaId: [media5],
    reactionId: [reaction1],
    commentId: [comment17]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-03-02T14:45:00Z"),
    messagePublication: "Merci pour vos commentaires et votre soutien continus.",
    idUser: user7UUID,
    mediaId: [media3],
    reactionId: [reaction4],
    commentId: []
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-01-10T20:30:00Z"),
    messagePublication: "Un petit aperçu de nos bureaux après quelques rénovations !",
    idUser: user1UUID,
    mediaId: [media4, media7],
    reactionId: [reaction5],
    commentId: [comment18]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-03-15T13:00:00Z"),
    messagePublication: "Le lancement officiel de notre produit phare approche !",
    idUser: user2UUID,
    mediaId: [media1],
    reactionId: [reaction2],
    commentId: [comment19, comment20]
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-18T17:00:00Z"),
    messagePublication: "Nous avons amélioré notre processus de support client, venez découvrir les nouvelles fonctionnalités.",
    idUser: user3UUID,
    mediaId: [media6],
    reactionId: [reaction3, reaction4],
    commentId: []
  },
  { 
    idPublication: new ObjectId(),
    publicationDate: new Date("2025-02-28T14:30:00Z"),
    messagePublication: "Merci à tous ceux qui sont venus à notre événement ce mois-ci, c'était génial de vous rencontrer.",
    idUser: user4UUID,
    mediaId: [media2],
    reactionId: [reaction5],
    commentId: [comment2]
  }
]);