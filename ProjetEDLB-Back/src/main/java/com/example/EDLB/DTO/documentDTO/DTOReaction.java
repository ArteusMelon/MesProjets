package com.example.EDLB.DTO.documentDTO;

import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOReaction {
    private ObjectId id;
    private ObjectId reactionReferenceId;
    private String nickname;    //nickname of User that reacted.
}
