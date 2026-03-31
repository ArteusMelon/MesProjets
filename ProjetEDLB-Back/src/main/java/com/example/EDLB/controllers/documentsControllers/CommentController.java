package com.example.EDLB.controllers.documentsControllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.EDLB.DTO.documentDTO.DTOComment;
import com.example.EDLB.mappers.MapperComment;
import com.example.EDLB.models.documents.Comment;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.mongo.ServiceComment;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private MapperComment mapperComment;
    @Autowired
    private ServiceComment serviceComment;

    // GET
    @GetMapping
    public ResponseEntity<List<DTOComment>> allComments() {
        List<Comment> comments = serviceComment.getAll();
        if (comments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<DTOComment> dtoComments = comments.stream()
                .map(comment -> mapperComment.convertToDTOComment(comment))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoComments);
    }

    @GetMapping("/{idComment}")
    public ResponseEntity<DTOComment> CommentById(@PathVariable ObjectId id) {
        Optional<Comment> comment = serviceComment.getById(id);
        if (comment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapperComment.convertToDTOComment(comment.get()));
    }

    // POST
    @PostMapping
    public Comment addComments(@RequestBody DTOComment dtoComment) {
        Comment comment = serviceComment.getById(dtoComment.getId()).get();
        return serviceComment.save(comment);
    }

    // PATCH
    @PatchMapping("/{idComment}")
    public ResponseEntity<Comment> commentUpdate(@PathVariable ObjectId id, @RequestBody DTOComment dtoComment, @AuthenticationPrincipal User principal) {
        Optional<Comment> optionalComment = serviceComment.getById(id);
        if (optionalComment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!principal.getIdUser().equals(UUID.fromString(optionalComment.get().getIdUser()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceComment.updateComment(id, dtoComment));
    }

    // DELETE
    @DeleteMapping("/{idComment}")
    public ResponseEntity<Comment> CommentDelete(@PathVariable ObjectId id,  @AuthenticationPrincipal User principal) {
        if (!principal.getIdUser().equals(UUID.fromString(serviceComment.getById(id).get().getIdUser())) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceComment.delete(id);
        return ResponseEntity.ok().build();
    }
}