package com.example.EDLB.services.mongo;

import com.example.EDLB.DTO.documentDTO.DTOMedia;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.repositories.mongo.RepositoryMedia;
import jakarta.persistence.EntityNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ServiceMedia implements IServiceMongo<Media> {

    @Autowired
    private RepositoryMedia mediaRepository;

    @Override
    public List<Media> getAll() {
        return mediaRepository.findAll();
    }

    @Override
    public Optional<Media> getById(ObjectId id) {
        return mediaRepository.findById(id);
    }

    @Override
    public void delete(ObjectId id) {
        Optional<Media> media = getById(id);
        if(media.isPresent()){
            mediaRepository.delete(media.get());
        }
    }

    @Override
    public Media save(Media media) {
        return mediaRepository.save(media);
    }

    public Optional<Media> getByStringId(String string){
        return getById(new ObjectId(string));
    }

    public Media updateMedia(ObjectId id, DTOMedia dtoMedia){
        return getById(id).map(existingMedia -> {
            if(!dtoMedia.getCommentMedia().isBlank() && !dtoMedia.getCommentMedia().equals(existingMedia.getCommentMedia())){
                existingMedia.setCommentMedia(dtoMedia.getCommentMedia());
            }
            if(!dtoMedia.getMediaName().isBlank() && !dtoMedia.getMediaName().equals(existingMedia.getMediaName())){
                existingMedia.setMediaName(dtoMedia.getMediaName());
            }
            return save(existingMedia);
        }).orElseThrow(() -> new EntityNotFoundException("ID Media : "+id+" not found."));
    }
}