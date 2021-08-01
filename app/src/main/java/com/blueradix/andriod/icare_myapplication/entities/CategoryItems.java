package com.blueradix.andriod.icare_myapplication.entities;

import java.io.Serializable;

public class CategoryItems implements Serializable
{
    private Long categoryId;
    private String categoryName;

    // Constructor
    public CategoryItems(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Default constructor
    public CategoryItems() {
    }

    // Getter
    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    // Setter
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
