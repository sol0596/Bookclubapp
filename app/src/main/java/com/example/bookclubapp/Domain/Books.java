package com.example.bookclubapp.Domain;

public class Books {
    private int CategoryId;
    private String Author;
    private boolean BestSeller;
    private int Id;
    private String ImagePath;
    private double Star;
    private String Title;


    public Books(){


    }
    @Override
    public String toString() {
        return Title;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public boolean isBestSeller() {
        return BestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        BestSeller = bestSeller;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
