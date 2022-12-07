package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Category;
import com.teahouse.inventory.teahouseinventory.services.CategoryService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 


@RestController
@RequestMapping("api/category/{loginKeyid}")
public class CategoryControler  extends BaseControler<Category>{

    
    private final CategoryService categoryService;

    public CategoryControler(CategoryService categoryService) {
        super(); 
        this.categoryService = categoryService;
    }


 


  


    // @GetMapping("list/all")
    // public ResponseEntity findAll(
    //     @PathVariable("loginKeyid")  String loginKey,  
    //     @RequestParam(name="active",required = false) @Nullable Boolean active
    //     ) {
    //         if(getUserLoginId(loginKey)==null){
    //             if(getUserLoginId(loginKey)==null){
    //                 return   new ResponseEntity<String>
    //                 ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //             }
    //         }
    //         if(active==null){
    //             return   new ResponseEntity<List<Category>> 
    //             (this.categoryService.findAll(), HttpStatus.OK);
    //         }else{
    //             return   new ResponseEntity<List<Category>> 
    //             (this.categoryService.findByStatus(active), HttpStatus.OK);
    //         }
    // }
    // @GetMapping("list")
    // public ResponseEntity findById(
    //     @PathVariable("loginKeyid")  String loginKey,  
    //     @RequestParam(name="id",required = true) Long categoryId
    //     ) {

    //         if(getUserLoginId(loginKey)==null){
    //             return   new ResponseEntity<String>
    //             ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //         }

       
    // }



    @Override
    public ResponseEntity onAdd(Category t) {
             return new ResponseEntity<Category>(this.categoryService.save(t), 
        HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity onUpdate(Long id, Category t) {
        if(this.categoryService.findById(id)!=null){
            return new ResponseEntity<Category>(this.categoryService.update(t,id), 
            HttpStatus.ACCEPTED);
        }
 
            return new ResponseEntity<String>(
                "Record not found", 
            HttpStatus.NOT_FOUND);
        
    }



    @Override
    public ResponseEntity onFindAll(Boolean active) {
        if(active==null){
            return   new ResponseEntity<List<Category>> 
            (this.categoryService.findAll(), HttpStatus.OK);
        }else{
            return   new ResponseEntity<List<Category>> 
            (this.categoryService.findByStatus(active), HttpStatus.OK);
        }
       
    }
  


    @Override
    public ResponseEntity onFindById(Long id) {
        return   new ResponseEntity<Category> 
        (this.categoryService.findById(id), HttpStatus.OK);
    }

 

 
    
}
