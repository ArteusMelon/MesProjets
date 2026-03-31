package com.example.EDLB.DTO.documentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import com.example.EDLB.Enum.DocType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOMedia {
    private ObjectId idMedia;
    private DocType type;
    private String uri;
    private String mediaName;
    private String commentMedia;
}