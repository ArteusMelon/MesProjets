package com.example.EDLB.services.postgre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.models.entities.Product;
import com.example.EDLB.models.entities.ProductMedia;
import com.example.EDLB.models.entities.ProductMediaId;
import com.example.EDLB.repositories.JPA.RepositoryProduct;
import com.example.EDLB.repositories.JPA.RepositoryProductMedia;
import com.example.EDLB.services.mongo.ServiceMedia;

@Service
public class ServiceProductMedia {

    @Autowired
    private RepositoryProductMedia repositoryProductMedia;
    @Autowired
    private RepositoryProduct repositoryProduct;
    @Autowired
    private ServiceMedia serviceMedia;

    public List<ProductMedia> getAll() {
        return repositoryProductMedia.findAll();
    }

    public Optional<ProductMedia> getById(ProductMediaId id) {
        return repositoryProductMedia.findById(id);
    }

    /// find all medias linked to a Product of id 'id'
    public List<Media> getMediasForProduct(UUID id){
        List<ProductMedia> productMediaList = repositoryProductMedia.findByProductMediaIdIdProduct(id);
        if(productMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return productMediaList.stream().map(
            productMedia -> serviceMedia.getByStringId(productMedia.getProductMediaId().getIdMedia())
                .orElseThrow(() -> new RuntimeException("Media "+productMedia.getProductMediaId().getIdMedia()+" not found."))
        ).collect(Collectors.toList());
    }

    /// find all Products linked to a media of id 'id'
    public List<Product> getProductsOfMedia(String id){
        List<ProductMedia> productMediaList = repositoryProductMedia.findByProductMediaIdIdMedia(id);
        if(productMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return productMediaList.stream().map(
            productMedia -> repositoryProduct.findById(productMedia.getProductMediaId().getIdProduct())
                .orElseThrow(() -> new RuntimeException("Where the Product at ?"+productMedia.getProductMediaId().getIdProduct()))
        ).collect(Collectors.toList());
    }

    public void delete(ProductMediaId id) {
        Optional<ProductMedia> productMedia = getById(id);
        if(productMedia.isPresent()){
            repositoryProductMedia.delete(productMedia.get());
        }
    }

    public ProductMedia save(ProductMedia productMedia) {
        return repositoryProductMedia.save(productMedia);
    }
}