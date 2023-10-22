package com.example.productservice_proxy.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Categories extends BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade= CascadeType.ALL)
    private List<Product> productList;

}
