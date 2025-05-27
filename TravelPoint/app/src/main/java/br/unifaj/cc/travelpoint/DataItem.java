package br.unifaj.cc.travelpoint;

public class DataItem {
    public int resIdThumbnail;   // imagem
    public String countryName;   // nome do destino

    public DataItem(int resIdThumbnail, String countryName) {
        this.resIdThumbnail = resIdThumbnail;
        this.countryName = countryName;
    }
}