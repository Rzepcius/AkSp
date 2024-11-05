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

//    Parametryzacja przez Argument
//    @GetMapping
//    public String getProducts(@RequestParam String name,
//                              @RequestParam(required = false,defaultValue = "") String surName){

//    Parametryzacja przez Ścieżkę, najczesciej wybierany
//    @GetMapping("/{name}")
//    public String getProducts(@PathVariable String name){

//    Parametryzacja przez Header
//    @GetMapping
//    public String getProducts(@RequestHeader String name){
//    Parametryzacja przez Body
//    @GetMapping
//    public String getProducts(@RequestBody String name){

    //    Połączone
    @GetMapping
    public String getProducts(@RequestParam String name,
                              @RequestHeader(required = false, defaultValue = "") String surName) {
        return "Hel with get to: " + name + " " + surName;
//        return "Hel with get to: "+name;
    }

    //    @PostMapping("/products")
    @PostMapping
    public String addProduct() {
        return "Hel with post";
    }

    //    @PutMapping("/products")
    @PutMapping
    public String modProduct() {
        return "Hel with put";
    }

    //    @DeleteMapping("/products")
    @DeleteMapping
    public String removeProduct() {
        return "Hel with delete";
    }
}
