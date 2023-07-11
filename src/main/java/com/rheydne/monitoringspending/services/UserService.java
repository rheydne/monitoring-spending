package com.rheydne.monitoringspending.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rheydne.monitoringspending.models.User;
import com.rheydne.monitoringspending.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // public User findById(Long id) {
    //     Optional<User> user = this.userRepository.findById(id);

    //     return user.orElseThrow(() -> new RuntimeException(
    //         "Usuário não encontrado! id: " + id + ", Tipo: " + User.class.getName()
    //     ));
    // }

    public User findById(Long id) {
        User user;
        Optional<User> obj = this.userRepository.findById(id);
        user = obj.orElse(null);
        if(user == null) {
            throw new RuntimeException("Usuário não encontrado! id: " + id + ", Tipo: " + User.class.getName());
        } else {
            user.setEmailAdress(user.maskedEmail(user.getEmailAdress()));
        }
        return user;
    }

    @Transactional
    public User create(User user) {
        user.setId(null);
        user = this.userRepository.save(user);
        return user;
    }

    @Transactional
    public User update(User user) {
        User newUser = findById(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setFullName(user.getFullName());
        newUser.setDateBirth(user.getDateBirth());
        newUser.setEmailAdress(user.getEmailAdress());
        return this.userRepository.save(newUser);
    }

    public void delete(Long id) {
        try {
            findById(id);
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível excluir o usuário!");
        }
    }

    
}
