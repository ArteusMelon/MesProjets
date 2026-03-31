package com.example.EDLB.controllers.entitiesControllers;

import com.example.EDLB.models.entities.Litter;
import com.example.EDLB.services.postgre.ServiceLitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/litters")
public class LitterController {

    @Autowired
    private ServiceLitter serviceLitter;

    // GET
    @GetMapping("/{idLitter}")
    public ResponseEntity<Litter> litterById(@PathVariable UUID idLitter){
        Optional<Litter> litter = serviceLitter.getById(idLitter);
        if(litter.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(litter.get());
    }
}
