package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.RelationType;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.entities.UserRelation;
import com.example.EDLB.models.entities.UserRelationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryUserRelation extends JpaRepository<UserRelation, UserRelationId> {

    List<UserRelation> findByUserReceiver(User userReceiver);
    boolean existsByUserReceiver(User userReceiver);
    List<UserRelation> findBySourceUser(User sourceUser);
    boolean existsBySourceUser(User sourceUser);
    List<UserRelation> findByRelationType(RelationType relationType);
    boolean existsByRelationType(RelationType relationType);

}
