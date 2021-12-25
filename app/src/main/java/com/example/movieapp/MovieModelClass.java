package com.example.movieapp;

public class MovieModelClass {
    String id;
    String name;
    String img;
    String ov;

    public MovieModelClass(String id, String name, String img, String ov) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.ov = ov;
    }

    public MovieModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOv() {
        return ov;
    }

    public void setOv(String ov) {
        this.ov = ov;
    }
}
