package com.example.demo.controller;

import com.example.demo.model.Branche;
import com.example.demo.model.Dtao.DocumentDtao;
import com.example.demo.model.Dtao.UserDtao;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/")
    String routeEndPoint(){
        return "WELCOME TO DGI DEMO API";
    }

    @GetMapping("/login/{email}")
    ResponseEntity<?> authenticate(@PathVariable String email){
        return utilisateurService.getAccountInfo(email);
    }

    @PostMapping("/admin/create")
    ResponseEntity<?> createUtilisateur(@RequestBody UserDtao userDtao){
        return utilisateurService.addUser(userDtao);
    }

    @GetMapping("/admin/users")
    ResponseEntity<?> fetchAllUsers(){
        return utilisateurService.listAlUsers();
    }

    @PostMapping("/admin/branche")
    ResponseEntity<?> createBranche(@RequestBody Branche branche){
        return utilisateurService.addBranche(branche);
    }

    @GetMapping("/admin/branche")
    ResponseEntity<?> fetchBranches(){
        return utilisateurService.listBranche();
    }

    @GetMapping("/admin/documents")
    ResponseEntity<?> fetchAllDocuments(){
        return utilisateurService.listAllDoc();
    }

    @PostMapping("/agent/document")
    ResponseEntity<?> insertDocument(@RequestBody DocumentDtao documentDtao){
        return utilisateurService.addDoc(documentDtao);
    }

    @GetMapping("/agent/documents/{id}")
    ResponseEntity<?> fetchDocuments(@PathVariable int id){
        return utilisateurService.listDoc(id);
    }
}
