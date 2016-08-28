package net.apkode.guida.model;

import java.io.Serializable;

public class Maison implements Serializable {
    private String ville;
    private String quartier;
    private String type; // location, vente,
    private String prix;
    private String description;
    private String image;
    private Double latitude;
    private Double longitude;
    private Long telephone;

    public Maison(String ville, String quartier, String type, String prix, String description, String image, Double latitude, Double longitude, Long telephone) {
        this.ville = ville;
        this.quartier = quartier;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.telephone = telephone;
    }

    public Maison() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
