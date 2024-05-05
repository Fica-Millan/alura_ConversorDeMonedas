package com.aluracursos.currencyexchange.api;

public record ConversionDeDivisa(String base_code,
                                 String target_code,
                                 double conversion_rate,
                                 double conversion_result){
}
