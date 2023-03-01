package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;

public class UserResponseDTO{

    private String id;
    private String name;
    
    public UserResponseDTO() {
    }
    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
