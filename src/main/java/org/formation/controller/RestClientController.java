package org.formation.controller;

import org.formation.entity.Client;
import org.formation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping
//	@CrossOrigin(origins = "*", methods = RequestMethod.PUT, allowedHeaders = "*")
    public Client updateClient(@RequestBody Client client) {
        return clientRepository.save(client);

    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

}
