package com.teahouse.inventory.teahouseinventory.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Client;
import com.teahouse.inventory.teahouseinventory.services.ClientService;


@RestController
@RequestMapping("api/client/{loginKeyid}")
public class ClientControler extends BaseControler<Client>{

    private final ClientService clientService;
    public ClientControler(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity onAdd(Client t) {
        
        return new ResponseEntity<Client>(this.clientService.save(t),
        HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Client t) {

        if(this.clientService.findById(id)!=null){
            return new ResponseEntity<Client>(this.clientService.update(t,id), 
            HttpStatus.ACCEPTED);
        }
 
            return new ResponseEntity<String>(
                "Record not found", 
            HttpStatus.NOT_FOUND);
        
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
         
        return new ResponseEntity<List<Client>> (this.clientService.findAll(),HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity onFindById(Long id) {
       
        return new ResponseEntity<Client>(this.clientService.findById(id), 
        HttpStatus.ACCEPTED);
    }
    
}
