package com.teahouse.inventory.teahouseinventory.controlers;

 
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Owners;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin; 
import com.teahouse.inventory.teahouseinventory.services.OwnerService; 


@RestController
@RequestMapping("api/owner/{loginKeyid}")
public class OwnerControler extends BaseControler<Owners>{


    public final OwnerService ownerService; 



    public OwnerControler(OwnerService ownerService ) {
        this.ownerService = ownerService;
        
    }

    @Override
    public ResponseEntity<String> onAdd(Owners t) {
        UserLogin u =  getUserLogin(loginKey);

        Owners currentUser = this.ownerService.findByUserLogin(u.getId());
        if(currentUser==null){
            t.setIsCurrent(true);
            t.setUserLogin(u);
            Owners e = this.ownerService.save(t);
            return  new ResponseEntity<String>("Owner Created successfuly",HttpStatus.CREATED);
        }
        
        return  new ResponseEntity<String>("Something went wrong",HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<String> onUpdate(Long id, Owners t) {
        UserLogin u =  getUserLogin(loginKey);

        Owners currentUser = this.ownerService.findByUserLogin(u.getId());
        if(currentUser!=null){
            currentUser.setAddress(t.getAddress());
            currentUser.setDateOfExit(t.getDateOfExit()); 
            currentUser.setFirstName(t.getFirstName());
            currentUser.setMiddleName(t.getMiddleName());
            currentUser.setLastName(t.getLastName());
            currentUser.setFranchises(t.getFranchises());
            currentUser.setIsCurrent(t.getIsCurrent());
            currentUser.setMobileNumbers(t.getMobileNumbers());
            currentUser.setRoles(t.getRoles());
            currentUser.setPercentageOfShare(t.getPercentageOfShare());
            currentUser.setUserLogin(u);
            Owners o = this.ownerService.save(currentUser);
            return  new ResponseEntity<String>("Owner update successfuly",HttpStatus.CREATED);
        }
        
        return  new ResponseEntity<String>("Something went wrong",HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<Owners>> onFindAll(Boolean active) {
      
        if (active) {
            return new ResponseEntity<List<Owners>>(
              this.ownerService.findAll(),
              HttpStatus.OK
            );
          } else {
            return new ResponseEntity<List<Owners>>(
              this.ownerService.findAllExOwners(),
              HttpStatus.OK
            );
          }
    }

    @Override
    public ResponseEntity<Owners> onFindById(Long id) {
        return new ResponseEntity<Owners>(
            this.ownerService.findById(id),
            HttpStatus.OK
          );
    }
    
}
