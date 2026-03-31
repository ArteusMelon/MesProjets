package com.example.EDLB.models.documents;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {
    @Id
    private ObjectId idComment;
    private Date dateOfComment;
    private Date dateOfUpdateComment;
    private String messageComment;
    @DBRef
    private List<Media> medias;
    private List<Reaction> reaction;
    private String idUser;

    public Comment(Date dateOfComment, String messageComment, List<Media> medias, List<Reaction> reaction, String idUser) {
        this.dateOfComment = dateOfComment;
        this.messageComment = messageComment;
        this.medias = medias;
        this.reaction = reaction;
        this.idUser = idUser;
    }
}

