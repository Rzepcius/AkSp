package com.example.aksp;

import org.springframework.web.bind.annotation.*;

/**
 * @author andrzej.rzepecki
 **/


@RestController
@RequestMapping("/products")
public class ProductApi {

//    @GetMapping("/products")
//    @RequestMapping(value = "/products",method = RequestMethod.GET)
//    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping("/get") -- http://localhost:8080/products/get
    @GetMapping
    public String getProducts(){
        return "Hel with get";
    }

//    @PostMapping("/products")
    @PostMapping
    public String addProduct(){
        return "Hel with post";
    }

//    @PutMapping("/products")
    @PutMapping
    public String modProduct(){
        return "Hel with put";
    }

//    @DeleteMapping("/products")
    @DeleteMapping
    public String removeProduct(){
        return "Hel with delete";
    }
}
