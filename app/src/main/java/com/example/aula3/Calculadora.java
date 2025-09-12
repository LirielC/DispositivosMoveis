package com.example.aula3;

public class Calculadora {
    double v1, v2;
    public Calculadora(){}
    public Calculadora(double v1, double v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }
    public double somar(){
        return v1 + v2;
    }
    public double subtrair(){
        return v1 - v2;
    }
    public double multiplicar(){
        return v1 * v2;
    }
    public double dividir(){
        if(v2 != 0){
            return v1 / v2;
        } else {
            return 0;
        }
    }
    public double exponenciar(){
        return Math.pow(v1, v2);
    }
    public double radiciar(){
        return Math.sqrt(v1);
    }
    public String formatar(double v, int nc){
        return String.format("%." + String.valueOf(nc)+"f",v);
    }
}
