package com.autoparts.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Osman on 10.05.2018.
 */

public class Zapchast extends ArrayList<Zapchast> {
    String podkhodit;
    String tip;
    String opisaniye;
    String tsena;
    String kod;
    String brend;
    String idImages;
    String value;

    public Zapchast(Zapchast zapchast) {

    }


    public String getPodkhodit() {
        return podkhodit;
    }

    public void setPodkhodit(String podkhodit) {
        this.podkhodit = podkhodit;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOpisaniye() {
        return opisaniye;
    }

    public void setOpisaniye(String opisaniye) {
        this.opisaniye = opisaniye;
    }

    public String getTsena() {
        return tsena;
    }

    public void setTsena(String tsena) {
        this.tsena = tsena;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String  getIdImages() {
        return idImages;
    }

    public void setIdImages(String idImages) {
        this.idImages = idImages;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Zapchast(String podkhodit, String tip, String opisaniye, String tsena, String kod, String brend, String idImages, String value) {

        this.podkhodit = podkhodit;
        this.tip = tip;
        this.opisaniye = opisaniye;
        this.tsena = tsena;
        this.kod = kod;
        this.brend = brend;
        this.idImages = idImages;
        this.value=value;

    }

    @Override
    public Stream<Zapchast> stream() {
        return null;
    }
}
