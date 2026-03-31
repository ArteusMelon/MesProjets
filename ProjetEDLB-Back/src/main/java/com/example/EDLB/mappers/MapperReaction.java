package com.example.EDLB.mappers;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.documentDTO.DTOReaction;
import com.example.EDLB.models.documents.Reaction;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceUser;

@Service
public class MapperReaction {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceUser serviceUser;

    public DTOReaction convertToDTOReaction(Reaction reaction) {
        DTOReaction dtoReaction = modelMapper.map(reaction, DTOReaction.class);
        if (reaction.getIdUser() != null) {
            UUID userId = UUID.fromString(reaction.getIdUser());
            User user = serviceUser.getById(userId).orElse(null);
            if (user != null) {
                dtoReaction.setNickname(user.getNickname());
            }
        }
        return dtoReaction;
    }
}