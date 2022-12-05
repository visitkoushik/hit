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


    @PostMapping 
    public ResponseEntity<Category>  add(@RequestBody Category category){
        
        return new ResponseEntity<Category>(this.categoryService.save(category), 
        HttpStatus.CREATED);
        
    }


    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category){
        return new ResponseEntity<Category>(this.categoryService.update(category,id), 
        HttpStatus.ACCEPTED);
    }


    @GetMapping("all")
    public ResponseEntity<List<Category>> findAll(
        @RequestParam(name="active",required = false) @Nullable Boolean active
        ) {
            if(active==null){
                return   new ResponseEntity<List<Category>> 
                (this.categoryService.findAll(), HttpStatus.OK);
            }else{
                return   new ResponseEntity<List<Category>> 
                (this.categoryService.findByStatus(active), HttpStatus.OK);
            }
    }
    @GetMapping()
    public ResponseEntity<Category> findById(
        @RequestParam(name="id",required = true) Long categoryId
        ) {
        return   new ResponseEntity<Category> 
        (this.categoryService.findById(categoryId), HttpStatus.OK);
    }


 
    
}
