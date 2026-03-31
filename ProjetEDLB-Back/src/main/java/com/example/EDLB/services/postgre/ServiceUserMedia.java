package com.example.EDLB.services.postgre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.entities.UserMedia;
import com.example.EDLB.models.entities.UserMediaId;
import com.example.EDLB.repositories.JPA.RepositoryUser;
import com.example.EDLB.repositories.JPA.RepositoryUserMedia;
import com.example.EDLB.services.mongo.ServiceMedia;

@Service
public class ServiceUserMedia{

    @Autowired
    private RepositoryUserMedia repositoryUserMedia;
    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private ServiceMedia serviceMedia;

    public List<UserMedia> getAll() {
        return repositoryUserMedia.findAll();
    }

    public Optional<UserMedia> getById(UserMediaId id) {
        return repositoryUserMedia.findById(id);
    }

    /// find all medias linked to a User of id 'id'
    public List<Media> getMediasForUser(UUID id){
        List<UserMedia> userMediaList = repositoryUserMedia.findByUserMediaIdIdUser(id);
        if(userMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return userMediaList.stream().map(
            userMedia -> serviceMedia.getByStringId(userMedia.getUserMediaId().getIdMedia())
                .orElseThrow(() -> new RuntimeException("Media "+userMedia.getUserMediaId().getIdMedia()+" not found."))
        ).collect(Collectors.toList());
    }

    /// find all Users linked to a media of id 'id'
    public List<User> getUsersOfMedia(String id){
        List<UserMedia> userMediaList = repositoryUserMedia.findByUserMediaIdIdMedia(id);
        if(userMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return userMediaList.stream().map(
            userMedia -> repositoryUser.findById(userMedia.getUserMediaId().getIdUser())
                .orElseThrow(() -> new RuntimeException("Where the User at ?"+userMedia.getUserMediaId().getIdUser()))
        ).collect(Collectors.toList());
    }

    public void delete(UserMediaId id) {
        Optional<UserMedia> userMedia = getById(id);
        if(userMedia.isPresent()){
            repositoryUserMedia.delete(userMedia.get());
        }
    }

    public UserMedia save(UserMedia userMedia) {
        return repositoryUserMedia.save(userMedia);
    }
}