package com.example.EDLB.models.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "publication")
public class Publication {
    @Id
    private ObjectId idPublication;
    private Date publicationDate;
    private Date updateDate;
    private String messagePublication;
    @DBRef
    private List<Media> medias;
    private String idUser;
    @DBRef
    private List<Reaction> reactions;
    @DBRef
    private List <Comment> comments;

    public Publication(Date publicationDate, String messagePublication, List<Media> medias, String idUser, List<Reaction> reactions, List<Comment> comments) {
        this.publicationDate = publicationDate;
        this.messagePublication = messagePublication;
        this.medias = medias;
        this.idUser = idUser;
        this.reactions = reactions;
        this.comments = comments;
    }
}
