package com.example.demo.services;

import com.example.demo.model.Branche;
import com.example.demo.model.Dtao.DocumentDtao;
import com.example.demo.model.Dtao.UserDtao;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UtilisateurService extends UserDetailsService {

    ResponseEntity<?> getAccountInfo(String email);

    ResponseEntity<?> addUser(UserDtao userDtao);

    ResponseEntity<?> listAlUsers();

    ResponseEntity<?> addBranche(Branche branche);

    ResponseEntity<?> listBranche();

    ResponseEntity<?> addDoc(DocumentDtao documentDtao);

    ResponseEntity<?> listDoc(int id);

    ResponseEntity<?> listAllDoc();

}
