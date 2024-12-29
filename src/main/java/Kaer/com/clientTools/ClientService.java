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
    public Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Zmieniona metoda, która zwraca Optional<Client>
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
}

