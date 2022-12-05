package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Client;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.ClientRepository;
import com.teahouse.inventory.teahouseinventory.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client findById(Long Id) {
        
        return this.clientRepository.findById(Id).orElse(null);
    }

    @Override
    public Client save(Client t) {
        
        return this.clientRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Client update(Client t, Long id) {
        Client client = this.clientRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Client", "ID", t.getId()));

            client.setAdresses(t.getAdresses());   
            client.setDateOfBirth(t.getDateOfBirth());   
            client.setEmail(t.getEmail());   
            client.setFirstName(t.getFirstName());   
            client.setGender(t.getGender());   
            client.setLastName(t.getLastName());   
            client.setMiddleName(t.getMiddleName());   
            client.setMobileNumbers(t.getMobileNumbers());   
            client.setRoles(t.getRoles());   
            client.setPrimaryAddressIndex(t.getPrimaryAddressIndex());   
            
            return this.clientRepository.save(client);
    }
    
}
