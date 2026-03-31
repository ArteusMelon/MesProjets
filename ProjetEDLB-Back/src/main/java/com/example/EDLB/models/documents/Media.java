package com.example.EDLB.models.documents;

import java.util.Date;
import com.example.EDLB.Enum.DocType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "media")
public class Media {
    private ObjectId idMedia;
    private DocType type;
    private String mediaName;
    private Date uploadDate;
    private String commentMedia;
    private String uri;

    public DocType getType(){ return type;}

    public DocType getTypeDeDoc(){
        return type;
    }

    public void setType(DocType type) { this.type = type; }

    public Media(DocType type, String mediaName, Date uploadDate, String commentMedia, String uri) {
        this.type = type;
        this.mediaName = mediaName;
        this.uploadDate = uploadDate;
        this.commentMedia = commentMedia;
        this.uri = uri;

    }
}
