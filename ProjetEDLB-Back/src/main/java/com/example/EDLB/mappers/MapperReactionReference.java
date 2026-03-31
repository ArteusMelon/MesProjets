package com.example.EDLB.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.documentDTO.DTOReactionReference;
import com.example.EDLB.models.documents.ReactionReference;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapperReactionReference {

    
    private ModelMapper modelMapper;

    public DTOReactionReference convertToDTOReactionReference(ReactionReference reactionReference) {
        DTOReactionReference dtoReactionReference = modelMapper.map(reactionReference, DTOReactionReference.class);

        return dtoReactionReference;
    }
}
