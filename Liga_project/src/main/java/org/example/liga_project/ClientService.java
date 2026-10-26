package org.example.liga_project;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Clients createUser(Clients clientsToCreate){

        var entityToSave = new ClientEntity(
                null,
                clientsToCreate.full_name(),
                clientsToCreate.gender(),
                ClientStatus.ACTIVE,
                LocalDateTime.now(),
                LocalDateTime.now()

        );
        var savedEntity = clientRepository.save(entityToSave);
        return toDomainClient(savedEntity);
    }

    public Clients updateUser(Long id, Clients clientsToUpdate)
    {
        ClientEntity clientEntity = clientRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("User not found ="+ id));
        clientEntity.setFullName(clientsToUpdate.full_name());
        clientEntity.setGender(clientsToUpdate.gender());
        clientEntity.setStatus(clientsToUpdate.status());
        clientEntity.setDateOfUpdate(LocalDateTime.now());
        return toDomainClient(clientRepository.save(clientEntity));
    }

    public Clients findUserById(Long id){
        ClientEntity clientEntity = clientRepository.
                findById(id).
                orElseThrow(()->new EntityNotFoundException("User not found ="+ id));
        return toDomainClient(clientEntity);
    }

    public List<Clients> findAllUsers(){
        List<ClientEntity> users = clientRepository.findAll();
        return users.
                stream().
                map(user -> toDomainClient(user)).
                toList();
    }

    public Clients deleteUser(Long id){
        ClientEntity clientEntity = clientRepository.
                findById(id).
                orElseThrow(()->new EntityNotFoundException("User not found ="+ id));
        clientRepository.delete(clientEntity);
        return toDomainClient(clientEntity);
    }

    private Clients toDomainClient(ClientEntity client) {
        return new Clients(
                client.getId(),
                client.getFullName(),
                client.getGender(),
                client.getStatus(),
                client.getDateOfCreate(),
                client.getDateOfUpdate()
        );
    }
}
