package com.example.EDLB.controllers.entitiesControllers;

import com.example.EDLB.models.entities.DeliveryMode;
import com.example.EDLB.services.postgre.ServiceDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/deliverymodes")
public class DeliveryModeController {

    @Autowired
    private ServiceDeliveryMode serviceDeliveryMode;

    // GET
    @GetMapping("/")
    public ResponseEntity<List<DeliveryMode>> allDeliveryModes(){
        List<DeliveryMode> deliveryModes = serviceDeliveryMode.getAll();
        if(deliveryModes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(deliveryModes);
    }

    @GetMapping("/{idDeliveryMode}")
    public ResponseEntity<DeliveryMode> deliveryModeById(@PathVariable UUID idDeliveryMode){
        Optional<DeliveryMode> deliveryMode = serviceDeliveryMode.getById(idDeliveryMode);
        if(deliveryMode.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deliveryMode.get());
    }
}
