package com.aluracursos.currencyexchange.servicios;

import com.aluracursos.currencyexchange.api.ServicioTasaDeCambio;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConversorDivisas {

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Implementa la lógica para obtener la tasa de conversión
        return ServicioTasaDeCambio.getExchangeRate(baseCurrency, targetCurrency);
    }

    public double convertir(String divisaBase, String divisaObjetivo, double cantidad) {
        // Obtener la tasa de conversión
        double tasaConversion = getExchangeRate(divisaBase, divisaObjetivo);
        // Calcular el monto convertido
        return cantidad * tasaConversion;
    }

    public String formatearCantidad(double cantidad) {
        // Formatear la cantidad con dos decimales y separador de miles
        NumberFormat formato = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatoDecimal = (DecimalFormat) formato;
        formatoDecimal.applyPattern("#,##0.00");
        return formatoDecimal.format(cantidad);
    }
}

