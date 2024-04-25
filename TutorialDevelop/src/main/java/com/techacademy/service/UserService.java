package com.techacademy.service;

import java.util.List;
import java.util.Set; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /** 全件を検索して返す */
    public List<User> getUserList() {
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }
    
    /** Userを1件検索して返す */
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
    
    /** Userの登録を行う */
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    /** Userの削除を行なう */
    @Transactional
    public void deleteUser(Set<Integer> idck) {
        for(Integer id : idck) {
            userRepository.deleteById(id);
        }
    }
}