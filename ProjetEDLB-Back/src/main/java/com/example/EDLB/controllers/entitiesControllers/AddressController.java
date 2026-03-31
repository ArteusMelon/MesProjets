package com.example.EDLB.controllers.entitiesControllers;

import java.util.Optional;
import java.util.UUID;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EDLB.DTO.jpaDTO.DTOAddress;
import com.example.EDLB.models.entities.Address;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceAddress;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private ServiceAddress serviceAddress;

    // GET
    @GetMapping("/{idAddress}")
    public ResponseEntity<Address> addressById(@PathVariable UUID idAddress){
        Optional<Address> address = serviceAddress.getById(idAddress);
        if(address.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(address.get());
    }

    // POST
    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody DTOAddress dtoAddress){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAddress.addAddress(dtoAddress));
    }

    // PATCH
    @PatchMapping("/{idAddress}")
    public ResponseEntity<Address> updateDog(@PathVariable UUID id, @RequestBody DTOAddress dtoAddress, @AuthenticationPrincipal User principal){
        if(!principal.getAddresses().contains(serviceAddress.getById(id)) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceAddress.updateAddress(id, dtoAddress));
    }

    // DELETE
    @DeleteMapping("/{idAddress}")
    public ResponseEntity<Address> deleteAddress(@PathVariable UUID id, @AuthenticationPrincipal User principal){
        if(!principal.getAddresses().contains(serviceAddress.getById(id)) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceAddress.delete(id);
        return ResponseEntity.ok().build();
    }
}