package com.example.EDLB.mappers;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.documentDTO.DTOComment;
import com.example.EDLB.models.documents.Comment;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceUser;

@Service
public class MapperComment {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceUser serviceUser;

    public DTOComment convertToDTOComment(Comment comment) {
        DTOComment dtoComment = modelMapper.map(comment, DTOComment.class);
        if (comment.getIdUser() != null) {
            UUID userId = UUID.fromString(comment.getIdUser());
            User user = serviceUser.getById(userId).orElse(null);
            if (user != null) {
                dtoComment.setNickname(user.getNickname());
            }
        }
        return dtoComment;
    }
}
