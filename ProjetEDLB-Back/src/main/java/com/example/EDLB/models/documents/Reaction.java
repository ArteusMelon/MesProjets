package com.example.EDLB.models.documents;

import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {
    private ObjectId idReaction;
    private ObjectId reactionReferenceId;
    private String idUser;
}
