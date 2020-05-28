package com.example.babymonitor;

public class Resume {
    private int horas;
    private int trocado;
    private int mamou;
    private int date;

    public Resume(int horas, int trocado, int mamou, int date) {
        this.horas = horas;
        this.trocado = trocado;
        this.mamou = mamou;
        this.date = date;
    }

    public Resume() {
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setTrocado(int trocado) {
        this.trocado = trocado;
    }

    public void setMamou(int mamou) {
        this.mamou = mamou;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public String getResume(){
        return "Bebe dormiu por " + horas +" horas " +
                "\n" +
                "Bebe foi trocado " + trocado + " vezes " +
                "\n" +
                "Bebe mamou " + mamou + "vezes\n" +
                "\n";
    }
}
