package com.teahouse.inventory.teahouseinventory.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Franchises;
import com.teahouse.inventory.teahouseinventory.services.FranchisesService;


@RestController
@RequestMapping("api/franchise/{loginKeyid}")
public class FrachiseeControler extends BaseControler<Franchises>{



    private final FranchisesService franchisesService;

    


    public FrachiseeControler(FranchisesService franchisesService) {
        this.franchisesService = franchisesService;
    }

    @Override
    public ResponseEntity onAdd(Franchises t) {
        // TODO Auto-generated method stub
        return new ResponseEntity<Franchises> (this.franchisesService.save(t)
        ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Franchises t) {
        if(this.franchisesService.findById(id)!=null){
            return new ResponseEntity<Franchises>(this.franchisesService.update(t,id), 
            HttpStatus.ACCEPTED);
        }
 
            return new ResponseEntity<String>(
                "Record not found", 
            HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
        // TODO Auto-generated method stub
        return new ResponseEntity<List<Franchises>>(this.franchisesService.findAll()
        ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity onFindById(Long id) {
      
          return new ResponseEntity<Franchises>(this.franchisesService.findById(id)
        ,HttpStatus.OK);
    }
    
}