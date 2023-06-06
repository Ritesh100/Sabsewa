package com.example.sabaesewa;

public class ServiceProvider {
    private String name;
    private String contact;
    private String address;
    private int imageResId; // Resource ID of the image

    public ServiceProvider(String name, String contact, String address, int imageResId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}