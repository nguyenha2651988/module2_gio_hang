package com.codegym.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GioHang {
    private String image = "gioHang.jpg";
    private int count;
    private List<Long> array = new ArrayList<>();
    private Date thoiGianTao;
    private Date thoiGianHetHan;


    public String getImage() {
        return image;
    }


    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.thoiGianHetHan = now.getTime();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {

        this.count = count;
    }

    public int increment() {
        return count++;
    }

    public void add(Long id) {
        thoiGianTao = new Date();
        array.add(id);
    }

    public List<Long> getArray() {
        return array;
    }

    public void hetHan() {
        this.setExpiryDate(1);
        if (new Date().after(this.thoiGianHetHan)) {
            count = 0;
            array.clear();
        }
    }
}
