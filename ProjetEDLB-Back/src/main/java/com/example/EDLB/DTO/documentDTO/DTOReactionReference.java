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
public class DTOReactionReference {
    private ObjectId id;
    private String name;
    private String description;
}
