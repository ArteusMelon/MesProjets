package com.example.EDLB.models.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reaction_reference")
public class ReactionReference {
    @Id
    private ObjectId reactionReferenceId;
    private String name;
    private String uri;
    private String description; // for audio description

    public ReactionReference(String name, String uri, String description) {
        this.name = name;
        this.uri = uri;
        this.description = description;
    }
}
