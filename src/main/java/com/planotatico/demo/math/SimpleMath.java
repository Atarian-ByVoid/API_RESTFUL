package com.planotatico.demo.math;

public class SimpleMath {
    // Soma dois numeros
    public Double sum(Double numberOne, Double numberTwo) {

        return numberOne + numberTwo;
    }

    // Subtrai dois numeros
    public Double sub(Double numberOne, Double numberTwo){

        return numberOne - numberTwo;
    }

    // Multiplica dois numeros
    public Double mult(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    // Eleva dois numeros
    public Double eleva(Double numberOne, Double numberTwo)  {
        return (Math.pow(numberOne, numberTwo));

    }

    // Divide dois numeros
    public Double divi(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;

    }

    // Média de dois numeros
    public Double med(Double numberOne, Double numberTwo) {
        return numberOne + (numberTwo / 2);

    }

    // Raiz quadrada numeros
    public Double raiz(Double number) {
        return Math.sqrt(number);

    }
}
