package org.factoriaf5.imc;

public class IMCMetodos {
    public double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso y altura deben ser mayores que cero");
        }
        return peso / Math.pow(altura, 2);
    }

    public String clasificacionIMC(double imc) {
        if (imc <= 0) {
            throw new IllegalArgumentException("IMC no puede ser negativo o cero");
        }
        
        if (imc < 16) {
            return "Delgadez severa";
        } else if (imc >= 16 && imc < 17) {
            return "Delgadez moderada";
        } else if (imc >= 17 && imc < 18.5) {
            return "Delgadez";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidad leve";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidad moderada";
        } else {
            return "Obesidad morbida";
        }
    }
}
