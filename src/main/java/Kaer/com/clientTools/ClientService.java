package Kaer.com.clientTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    /**
     * Saves a client to the database.
     *
     * @param client the client to save
     * @return the saved client
     */
    public Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Retrieves a client by their ID.
     *
     * @param id the ID of the client to retrieve
     * @return an Optional containing the client if found, otherwise empty
     */
    // Method to get a client by ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
}

