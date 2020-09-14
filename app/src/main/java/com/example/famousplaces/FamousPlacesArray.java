package com.example.famousplaces;

public class FamousPlacesArray {

    String placeName, placeDesc;
    Double placeLat, placeLong;
    int placeImage;

    public FamousPlacesArray(String placeName, String placeDesc, Double placeLat, Double placeLong, int placeImage) {
        this.placeName = placeName;
        this.placeDesc = placeDesc;
        this.placeLat = placeLat;
        this.placeLong = placeLong;
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public Double getPlaceLat() {
        return placeLat;
    }

    public void setPlaceLat(Double placeLat) {
        this.placeLat = placeLat;
    }

    public Double getPlaceLong() {
        return placeLong;
    }

    public void setPlaceLong(Double placeLong) {
        this.placeLong = placeLong;
    }

    public int getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(int placeImage) {
        this.placeImage = placeImage;
    }
}
