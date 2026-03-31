package com.example.EDLB.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.documentDTO.DTOMedia;
import com.example.EDLB.models.documents.Media;

@Service
public class MapperMedia {
    
    @Autowired
    private ModelMapper modelMapper;

    public DTOMedia convertToDTOMedia(Media media) {
        return modelMapper.map(media, DTOMedia.class);
    }
}