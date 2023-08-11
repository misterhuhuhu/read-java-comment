package com.example.GroovySpring;


import org.springframework.stereotype.Service;

@Service
public class UserService {
   
   public User findById(int i){
       return new User().setName("name" +i);
   }
    public static class User {
        public String name;
    
        public String name() {
            return name;
        }
    
        public User setName(String name) {
            this.name = name;
            return this;
        }
        
    }
}
