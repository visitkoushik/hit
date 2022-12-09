package com.teahouse.inventory.teahouseinventory.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.EmployeeResp;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.NewStuff;
import com.teahouse.inventory.teahouseinventory.exceptions.CreationgException;
import com.teahouse.inventory.teahouseinventory.services.EmployeeAddressService;
import com.teahouse.inventory.teahouseinventory.services.EmployeeService;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;
@RestController
@RequestMapping("api/employee/{loginKeyid}")
public class EmployeeControle extends BaseControler<Employee>{



    private final EmployeeService employeeService; 
    private final UserLoginService userLoginService;
    private final LoggedInUserService loggedInUserService;


public EmployeeControle(EmployeeService employeeService, UserLoginService userLoginService,
            LoggedInUserService loggedInUserService) {
        this.employeeService = employeeService;
        this.userLoginService = userLoginService;
        this.loggedInUserService = loggedInUserService;
    }

    

    private UserLogin RegisterStuff(UserLogin userLogin){
       
        LoggedInUser l = 
         this.loggedInUserService.save(new LoggedInUser());
        userLogin.setLoggedinuser(l);
        userLogin.setIsActive(true);

        UserLogin u = this.userLoginService.save(userLogin);
        if(u == null )
            {
                throw new CreationgException("Employee");
            }
        return u;

}
    @PostMapping("addstuff") 
    public ResponseEntity addEmployee(
    @PathVariable("loginKeyid")  String loginKey,  
    @RequestBody NewStuff t){
        if(isValidationFailed(loginKey)){
            return   new ResponseEntity<String>
                    ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
        }

        UserLogin u= RegisterStuff(new UserLogin(t.getUserName(),t.getPassWord(), t.getUserType()));
        Employee currentUser = this.employeeService.findByUserLogin(u.getId());
        Employee newEmp = t.getEmployee();
        if(currentUser==null){
            newEmp.setIsCurrent(true);
            newEmp.setUserLogin(u);
            Employee e = this.employeeService.save(newEmp);
            return  new ResponseEntity<String>("Employee Created successfuly",HttpStatus.CREATED);
        }
        return  new ResponseEntity<String>("Something went wrong",HttpStatus.UNAUTHORIZED);
    }



    @Override
    public ResponseEntity onAdd(Employee t) {
       UserLogin u =  getUserLogin(loginKey);

       Employee currentUser = this.employeeService.findByUserLogin(u.getId());
        if(currentUser==null){
            t.setIsCurrent(true);
            t.setUserLogin(u);
            Employee e = this.employeeService.save(t);
            return  new ResponseEntity<String>("User Created successfuly",HttpStatus.CREATED);
        }
        
        return  new ResponseEntity<String>("Something went wrong",HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Employee t) {
        UserLogin u =  getUserLogin(loginKey);
        Employee currentUser = this.employeeService.findByUserLogin(u.getId());
        if((currentUser!=null && currentUser.getId() == id )|| 
        ((currentUser.getRoles()==Roles.ADMIN || currentUser.getRoles()==Roles.SUPERADMIN) &&
        (currentUser.getRoles().getValue()<=t.getRoles().getValue())))
        {
            t.setIsCurrent(true);
            t.setId(currentUser.getId());
            return  new ResponseEntity<EmployeeResp>(new EmployeeResp( this.employeeService.save(t)),HttpStatus.CREATED);
        }
    
    return  new ResponseEntity<String>("Error Occured during update",HttpStatus.BAD_REQUEST);
    
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
        // TODO Auto-generated method stub
        return  new ResponseEntity<List<Employee>>(this.employeeService.findAll()
          ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity onFindById(Long id) {
       
          return  new ResponseEntity<Employee>(this.employeeService.findById(id)
          ,HttpStatus.OK);
    }
    

 
}
