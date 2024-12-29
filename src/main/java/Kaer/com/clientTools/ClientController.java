package Kaer.com.clientTools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/new")
    public String newClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "clientForm";
    }

    @PostMapping("/new")
    public String createClient(Client client) {
        clientService.saveClient(client);
        log.info("Klient " + client + " został dodany");
        return "redirect:/clients";
    }

    @PostMapping("/clients/update")
    public String updateClient(@ModelAttribute Client client) {
        Optional<Client> existingClient = clientService.getClientById(client.getId());
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            // Aktualizacja wszystkich pól
            updatedClient.setName(client.getName());
            updatedClient.setCountry(client.getCountry());
            updatedClient.setGoodsHeBuy(client.getGoodsHeBuy());
            updatedClient.setGoodsHeSell(client.getGoodsHeSell());
            updatedClient.setCreditLimit(client.getCreditLimit());
            updatedClient.setAcceptedPrice(client.getAcceptedPrice());
            updatedClient.setOfferedPrice(client.getOfferedPrice());
            updatedClient.setContact(client.getContact());
            updatedClient.setInfo(client.getInfo());
            clientService.saveClient(updatedClient);
            log.info("Zaktualizowano klienta: {}", updatedClient);
        } else {
            log.error("Klient o ID {} nie istnieje", client.getId());
        }
        return "redirect:/clients/" + client.getId();
    }


    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clientList";
    }

    @GetMapping("/clients/{id}")
    public String viewClientDetails(@PathVariable Long id, Model model) {
        Optional<Client> optionalClient = clientService.getClientById(id);

        if (optionalClient.isPresent()) {
            model.addAttribute("client", optionalClient.get());
            return "clientDetails";
        } else {
            log.error("Client with id {} not found", id);
            return "redirect:/clients";
        }
    }
}
