package org.factoriaf5.imc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestIMC {
    IMCMetodos imcMetodos = new IMCMetodos();

    @Test
    public void testCalcularIMC() {
        double peso = 50;
        double altura = 1.60;
        double imcEsperado = peso / Math.pow(altura, 2);
        double imcCalculado = imcMetodos.calcularIMC(peso, altura);
        assertEquals(imcEsperado, imcCalculado);
    }

    @Test
    public void testCalcularIMCInvalidoPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> imcMetodos.calcularIMC(-50, 1.60));
    }

    @Test
    public void testCalcularIMCInvalidoAlturaCero() {
        assertThrows(IllegalArgumentException.class, () -> imcMetodos.calcularIMC(50, 0));
    }

    @Test
    public void testCalcularIMCInvalidoPesoCero() {
        assertThrows(IllegalArgumentException.class, () -> imcMetodos.calcularIMC(0, 1.60));
    }

    @Test
    public void testClasificacionDelgadezSevera() {
        assertEquals("Delgadez severa", imcMetodos.clasificacionIMC(15.0));
    }

    @Test
    public void testClasificacionDelgadezModerada() {
        assertEquals("Delgadez moderada", imcMetodos.clasificacionIMC(16.0));
    }

    @Test
    public void testClasificacionDelgadez() {
        assertEquals("Delgadez", imcMetodos.clasificacionIMC(17.0));
    }

    @Test
    public void testClasificacionPesoNormalLimiteInferior() {
        assertEquals("Peso normal", imcMetodos.clasificacionIMC(18.5));
    }

    @Test
    public void testClasificacionPesoNormalLimiteSuperior() {
        assertEquals("Peso normal", imcMetodos.clasificacionIMC(24.9));
    }

    @Test
    public void testClasificacionSobrepesoLimiteInferior() {
        assertEquals("Sobrepeso", imcMetodos.clasificacionIMC(25.0));
    }

    @Test
    public void testClasificacionSobrepesoLimiteSuperior() {
        assertEquals("Sobrepeso", imcMetodos.clasificacionIMC(29.9));
    }

    @Test
    public void testClasificacionObesidadLeve() {
        assertEquals("Obesidad leve", imcMetodos.clasificacionIMC(32.0));
    }

    @Test
    public void testClasificacionObesidadModerada() {
        assertEquals("Obesidad moderada", imcMetodos.clasificacionIMC(37.0));
    }

    @Test
    public void testClasificacionObesidadMorbida() {
        assertEquals("Obesidad morbida", imcMetodos.clasificacionIMC(42.0));
    }

    @Test
    public void testClasificacionIMCInvalido() {
        assertThrows(IllegalArgumentException.class, () -> imcMetodos.clasificacionIMC(-5));
    }

    @Test
    public void testClasificacionLimiteInferiorDelgadez() {
        assertEquals("Delgadez severa", imcMetodos.clasificacionIMC(15.99));
    }

    @Test
    public void testClasificacionLimiteSuperiorDelgadez() {
        assertEquals("Delgadez moderada", imcMetodos.clasificacionIMC(16.99));
    }

    @Test
    public void testClasificacionLimiteInferiorPesoNormal() {
        assertEquals("Peso normal", imcMetodos.clasificacionIMC(24.99));
    }

    @Test
    public void testClasificacionLimiteInferiorDelgadezNormal() {
        assertEquals("Delgadez", imcMetodos.clasificacionIMC(18.49));
    }

    @Test
    public void testClasificacionLimiteInferiorObesidadLeve() {
        assertEquals("Obesidad leve", imcMetodos.clasificacionIMC(30.0));
    }

    @Test
    public void testClasificacionLimiteSuperiorObesidadLeve() {
        assertEquals("Obesidad leve", imcMetodos.clasificacionIMC(34.99));
    }

    @Test
    public void testClasificacionIMCAlto() {
        assertEquals("Obesidad morbida", imcMetodos.clasificacionIMC(100.0)); // Un valor muy alto
    }

    @Test
    public void testClasificacionIMCBajo() {
        assertEquals("Delgadez severa", imcMetodos.clasificacionIMC(10.0)); // Un valor muy bajo
    }
}
