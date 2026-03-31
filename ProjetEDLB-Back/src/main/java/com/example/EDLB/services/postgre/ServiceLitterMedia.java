package com.example.EDLB.services.postgre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.models.entities.Litter;
import com.example.EDLB.models.entities.LitterMedia;
import com.example.EDLB.models.entities.LitterMediaId;
import com.example.EDLB.repositories.JPA.RepositoryLitter;
import com.example.EDLB.repositories.JPA.RepositoryLitterMedia;
import com.example.EDLB.services.mongo.ServiceMedia;

@Service
public class ServiceLitterMedia{

    @Autowired
    private RepositoryLitterMedia repositoryLitterMedia;
    @Autowired
    private RepositoryLitter repositoryLitter;
    @Autowired
    private ServiceMedia serviceMedia;

    public List<LitterMedia> getAll() {
        return repositoryLitterMedia.findAll();
    }

    public Optional<LitterMedia> getById(LitterMediaId id) {
        return repositoryLitterMedia.findById(id);
    }

    /// find all medias linked to a Litter of id 'id'
    public List<Media> getMediasForLitter(UUID id){
        List<LitterMedia> litterMediaList = repositoryLitterMedia.findByLitterMediaIdIdLitter(id);
        if(litterMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return litterMediaList.stream().map(
                litterMedia -> serviceMedia.getByStringId(litterMedia.getLitterMediaId().getIdMedia())
                    .orElseThrow(() -> new RuntimeException("Media "+litterMedia.getLitterMediaId().getIdMedia()+" not found."))
                ).collect(Collectors.toList());
    }

    /// find all Litters linked to a media of id 'id'
    public List<Litter> getLittersOfMedia(String id){
        List<LitterMedia> litterMediaList = repositoryLitterMedia.findByLitterMediaIdIdMedia(id);
        if(litterMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return litterMediaList.stream().map(
            litterMedia -> repositoryLitter.findById(litterMedia.getLitterMediaId().getIdLitter())
                .orElseThrow(() -> new RuntimeException("Litter "+litterMedia.getLitterMediaId().getIdLitter()+" not found."))
        ).collect(Collectors.toList());
    }

    public void delete(LitterMediaId id) {
        Optional<LitterMedia> litterMedia = getById(id);
        if(litterMedia.isPresent()){
            repositoryLitterMedia.delete(litterMedia.get());
        }
    }

    public LitterMedia save(LitterMedia litterMedia) {
        return repositoryLitterMedia.save(litterMedia);
    }
}