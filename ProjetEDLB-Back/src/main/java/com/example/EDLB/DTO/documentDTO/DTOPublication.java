package com.example.EDLB.DTO.documentDTO;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPublication {
    private ObjectId id;
    private String message;
    private List<DTOMedia> medias;
    private String nickname;
    private List<DTOReaction> reactions;
    private List<DTOComment> comments;
    private Date publicationDate;
    private Date updateDate;
}
