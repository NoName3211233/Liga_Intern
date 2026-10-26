package org.example.liga_project;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Clients> createUser(@Valid @RequestBody Clients clientsToCreate){
        log.info("Calling method createUser = {}", clientsToCreate);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(clientService.
                        createUser(clientsToCreate));
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getAllUsers(){
        log.info("Calling method getAllUsers");
        return ResponseEntity.
                ok(clientService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getUserById(@PathVariable Long id){
        log.info("Calling method getUserById = {}", id);
        try {
            return ResponseEntity.
                    ok().
                    body(clientService.findUserById(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.
                    status(404).
                    build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateUser(@PathVariable Long id, @Valid @RequestBody Clients clientsToUpdate){
        log.info("Calling method updateUser id ={},UserToUpdate ={}",id, clientsToUpdate);
        try {
            var updatedUser = clientService.updateUser(id, clientsToUpdate);
            return ResponseEntity.ok(updatedUser);
        }catch (NoSuchElementException e){
            return ResponseEntity.
                    status(404).
                    build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        log.info("Calling method deleteClient id ={}",id);
        try {
            clientService.deleteUser(id);
            return ResponseEntity.
                    ok().
                    build();
        }catch (NoSuchElementException e){
            return ResponseEntity.
                    status(404).
                    build();
        }
    }
}
