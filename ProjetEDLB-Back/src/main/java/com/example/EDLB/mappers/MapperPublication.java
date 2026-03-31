package com.example.EDLB.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EDLB.DTO.documentDTO.DTOComment;
import com.example.EDLB.DTO.documentDTO.DTOMedia;
import com.example.EDLB.DTO.documentDTO.DTOPublication;
import com.example.EDLB.DTO.documentDTO.DTOReaction;
import com.example.EDLB.models.documents.Publication;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceUser;

@Service
public class MapperPublication {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private MapperComment mapperComment;
    @Autowired
    private MapperReaction mapperReaction;
    @Autowired
    private MapperMedia mapperMedia;

    public DTOPublication convertToDTOPublication(Publication publication) {
        DTOPublication dtoPublication = modelMapper.map(publication, DTOPublication.class);
        
        if(publication.getComments() != null){
            if(publication.getComments() != null){
            List<DTOComment> dtoComments = publication.getComments().stream()
                .map(comment -> mapperComment.convertToDTOComment(comment))
                .collect(Collectors.toList());
                dtoPublication.setComments(dtoComments);
        }
        if(publication.getReactions()!=null){        }

            List<DTOReaction> dtoReactions = publication.getReactions().stream()
            .map(reaction -> mapperReaction.convertToDTOReaction(reaction))
            .collect(Collectors.toList());
            dtoPublication.setReactions(dtoReactions);
        }
        if(publication.getMedias()!=null){
            List<DTOMedia> dtoMedias = publication.getMedias().stream()
            .map(media -> mapperMedia.convertToDTOMedia(media))
            .collect(Collectors.toList());
            dtoPublication.setMedias(dtoMedias);
        }
        if(publication.getIdUser() != null) {
            UUID userId = UUID.fromString(publication.getIdUser());
            User user = serviceUser.getById(userId).orElse(null);
            if (user != null) {
                dtoPublication.setNickname(user.getNickname());
            }
        }
        return dtoPublication;
    }
}