package com.example.demo.services;

import com.example.demo.model.Branche;
import com.example.demo.model.Document;
import com.example.demo.model.Dtao.DocumentDtao;
import com.example.demo.model.Dtao.UserDtao;
import com.example.demo.model.Utilisateur;
import com.example.demo.repository.BrancheRepository;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UtilisateurServiceImp implements UtilisateurService{

    @Autowired
            private UtilisateurRepository utilisateurRepository;
    @Autowired
            private RoleRepository roleRepository;
    @Autowired
            private BrancheRepository brancheRepository;
    @Autowired
            private DocumentRepository documentRepository;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(username);

        if(utilisateur.isPresent()){
            return new org.springframework.security.core.userdetails.User(
                    utilisateur.get().getEmail(), utilisateur.get().getPassword(),
                    mapRolesToAuthorities(utilisateur.get().getIdrole().getRolename())
            );

        }else {
            throw new UsernameNotFoundException("Personne with these crudentials not found");
        }

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String roles){
        return Collections.singleton(new SimpleGrantedAuthority(roles));
    }

    @Override
    public ResponseEntity<?> getAccountInfo(String email) {
        return ResponseEntity.ok(utilisateurRepository.findByEmail(email));
    }

    @Override
    public ResponseEntity<?> addUser(UserDtao userDtao) {
        if(utilisateurRepository.findByEmail(userDtao.getEmail()).isPresent()){
            return ResponseEntity.status(401).body("User with this email already exist");
        }else{
            Utilisateur user = new Utilisateur(userDtao.getName(), userDtao.getEmail(),
                    passwordEncoder.encode(userDtao.getPassword()), roleRepository.findById(userDtao.getIdrole()).get(),
                    brancheRepository.findById(userDtao.getIdbranche()).get());
            return ResponseEntity.status(201).body(utilisateurRepository.save(user));
        }
    }

    @Override
    public ResponseEntity<?> listAlUsers() {
        return ResponseEntity.ok(utilisateurRepository.findAll());
    }

    @Override
    public ResponseEntity<?> addBranche(Branche branche) {
        return ResponseEntity.status(201).body(brancheRepository.save(branche));
    }

    @Override
    public ResponseEntity<?> listBranche() {
        return ResponseEntity.ok(brancheRepository.findAll());
    }

    @Override
    public ResponseEntity<?> addDoc(DocumentDtao documentDtao) {
        Optional<Utilisateur> user = utilisateurRepository.findById(documentDtao.getIduser());
        if(user.isPresent()){
            Document doc = new Document(documentDtao.getFile_name(), documentDtao.getContent(), user.get());
            return ResponseEntity.status(201).body(documentRepository.save(doc));
        }else{
            return ResponseEntity.status(401).body("There is no user with this Id");
        }

    }

    @Override
    public ResponseEntity<?> listDoc(int id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(documentRepository.findByUserBranche(user.get().getIdbranche().getIdbranche()));
        }else{
            return ResponseEntity.status(401).body("There is no User with this Id");
        }

    }

    @Override
    public ResponseEntity<?> listAllDoc() {
        return ResponseEntity.ok(documentRepository.findAll());
    }

}
