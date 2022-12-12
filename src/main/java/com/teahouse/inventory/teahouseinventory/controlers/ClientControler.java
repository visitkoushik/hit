package com.teahouse.inventory.teahouseinventory.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Client;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;
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
        if(t!=null){
            t.setRoles(Roles.CLIENT);
        }

        Client client = this.clientService.save(t);
        if(client!=null){
        return new ResponseEntity<Client>(
            client,
            HttpStatus.CREATED
          );
        }

        return new ResponseEntity<String>(
            "Can't Add the Client to Database",
            HttpStatus.NOT_IMPLEMENTED
          );
    }

    @Override
    public ResponseEntity onUpdate(Long id, Client t) {

        if(this.clientService.findById(id)!=null){
            Client c = this.clientService.update(t,id);
            if(c!=null){
                return new ResponseEntity<String>(
                    "Client Updated successfuly",
                    HttpStatus.ACCEPTED
                );
            }

            return new ResponseEntity<String>(
                "Can't Update the Client to Database",
                HttpStatus.NOT_IMPLEMENTED
            );
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
    

    @GetMapping("contant")
    public ResponseEntity findClientContact(
        @PathVariable("loginKeyid")  String loginKey,  
        @RequestParam(name="mobile",required = true) String mobile
    ){
        if(isValidationFailed(loginKey)){
            return new ResponseEntity<String>("Either wrong credential or not have permission", 
            HttpStatus.UNAUTHORIZED);     
        }
        return new ResponseEntity<Client>(this.clientService.findByContact(mobile), 
        HttpStatus.ACCEPTED);
    }

}
