package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Category;
import com.teahouse.inventory.teahouseinventory.services.CategoryService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/category/{loginKeyid}")
public class CategoryControler  extends BaseControler{

    
    private final CategoryService categoryService;

    public CategoryControler(CategoryService categoryService) {
        super(); 
        this.categoryService = categoryService;
    }



    @PostMapping("add") 
    public ResponseEntity add(
    @PathVariable("loginKeyid")  String loginKey,  
    @RequestBody Category category){
        if(getUserLoginId(loginKey)==null){
            return   new ResponseEntity<String>
            ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Category>(this.categoryService.save(category), 
        HttpStatus.CREATED);
        
    }


    @PutMapping("edit/{id}")
    public ResponseEntity update(  
        @PathVariable("loginKeyid")  String loginKey,  
        @PathVariable("id") Long id, 
        @RequestBody Category category){
       
            if(getUserLoginId(loginKey)==null){
                return   new ResponseEntity<String>
                ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
            }
        return new ResponseEntity<Category>(this.categoryService.update(category,id), 
        HttpStatus.ACCEPTED);
    }


    @GetMapping("list/all")
    public ResponseEntity findAll(
        @PathVariable("loginKeyid")  String loginKey,  
        @RequestParam(name="active",required = false) @Nullable Boolean active
        ) {
            if(getUserLoginId(loginKey)==null){
                if(getUserLoginId(loginKey)==null){
                    return   new ResponseEntity<String>
                    ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
                }
            }
            if(active==null){
                return   new ResponseEntity<List<Category>> 
                (this.categoryService.findAll(), HttpStatus.OK);
            }else{
                return   new ResponseEntity<List<Category>> 
                (this.categoryService.findByStatus(active), HttpStatus.OK);
            }
    }
    @GetMapping("list")
    public ResponseEntity findById(
        @PathVariable("loginKeyid")  String loginKey,  
        @RequestParam(name="id",required = true) Long categoryId
        ) {

            if(getUserLoginId(loginKey)==null){
                return   new ResponseEntity<String>
                ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
            }

        return   new ResponseEntity<Category> 
        (this.categoryService.findById(categoryId), HttpStatus.OK);
    }


 
    
}
