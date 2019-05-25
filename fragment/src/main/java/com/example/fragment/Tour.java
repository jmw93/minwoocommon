package com.example.fragment;
// 관광지 정보 객체
public class Tour {

    String image_url;
    String name;
    String address;

    public Tour(String image_url, String name, String address) {
        this.image_url = image_url;
        this.name = name;
        this.address = address;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
