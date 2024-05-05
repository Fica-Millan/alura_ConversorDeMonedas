# Conversor de Divisas

Este proyecto es un conversor de divisas que utiliza la API de
[ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio 
en tiempo real y realizar conversiones entre diferentes monedas.

La aplicación está escrita en Java, utiliza el patrón de diseño MVC
(Modelo-Vista-Controlador) para organizar su estructura y como entorno de desarrollo 
integrado (IDE) se utilizo IntelliJ IDEA para escribir, depurar y probar el código.

![Conversor de Divisas](C:\Users\ficam\Dropbox\ONE\JAVA\CurrencyExchange\imagenes\ConversorDeDivisas.png)

## Características

- Conversión entre nueve divisas principales.
- Interfaz de usuario intuitiva para la selección de divisas y entrada de montos.
- Historial de conversiones para realizar un seguimiento de las operaciones anteriores.
- Utiliza tasas de cambio actualizadas para garantizar la precisión de las conversiones.

## Requisitos del Sistema

- Java 8 o superior.
- Conexión a Internet para obtener tasas de cambio actualizadas.

## Instalación

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de Java preferido.
3. Compila y ejecuta el archivo `Principal.java` para iniciar la aplicación.

## Uso

- Al iniciar la aplicación, se te pedirá que selecciones la divisa base y la divisa objetivo para la conversión.
- Luego, introduce el monto que deseas convertir.
- La aplicación calculará automáticamente el monto convertido y lo mostrará.
- Puedes optar por realizar más conversiones o salir de la aplicación.

## Monedas Disponibles
La aplicación de conversión de divisas cuenta con soporte para las siguientes monedas:

* USD - Dólar Estadounidense
* ARS - Peso Argentino
* EUR - Euro, Unión Europea
* BRL - Real Brasileño
* MXN - Peso Mexicano
* CNY - Yuan Chino
* CHF - Franco Suizo
* GBP - Libra Esterlina
* JPY - Yen Japonés

## Historial de Conversiones

- La aplicación guarda un historial de todas las conversiones realizadas durante la sesión.
- Puedes acceder al historial al finalizar todas las conversiones.
- El historial muestra detalles como la divisa base, la divisa objetivo, el monto convertido y la fecha y hora de la conversión.

```java
//Crea un objeto Conversion y lo agrega al historial
Conversion conversion = new Conversion(divisaBase, divisaObjetivo, cantidad, 
        conversorDivisas.getExchangeRate(divisaBase, divisaObjetivo),
        LocalDateTime.now());
        historialConversiones.agregarConversion(conversion);
```

![Historial de consultas](C:\Users\ficam\Dropbox\ONE\JAVA\CurrencyExchange\imagenes\HistorialDeConsultas.png)

## Control de Errores

En este proyecto, se ha prestado especial atención al manejo de errores para 
garantizar un comportamiento robusto y una experiencia de usuario fluida. 
A continuación, se describen algunas de las estrategias de manejo de errores que 
se han implementado:

### Validación de Entrada del Usuario
Se han implementado controles de validación en las entradas del usuario para 
garantizar que solo se introduzcan valores válidos. Por ejemplo, cuando se 
solicita al usuario que ingrese una cantidad, se verifica que la entrada sea 
un número válido y se muestra un mensaje de error si no es así.

```java
//Método leerCantidad, solicita al usuario que ingrese la cantidad a convertir
private static double leerCantidad(String mensaje) {
    System.out.println("\n─────────────────────────────────────────────────────────");
    System.out.println(mensaje);
    String input = scanner.nextLine();

    while (!input.matches("\\d+")) {
        System.out.println("Por favor, ingrese un valor válido sin puntos ni comas.");
        input = scanner.nextLine();
    }

    return Double.parseDouble(input);
}
```

![Error de importe incorrecto](C:\Users\ficam\Dropbox\ONE\JAVA\CurrencyExchange\imagenes\ErrorImporteIncorrecto.png)

### Captura de Excepciones
Se han implementado bloques try-catch para capturar excepciones y manejarlas 
adecuadamente. Por ejemplo, al convertir divisas, se captura cualquier excepción
que pueda ocurrir durante el proceso de conversión y se muestra un mensaje de 
error al usuario.

```java
public static double getExchangeRate(String baseCurrency, String targetCurrency) {
    // Construir la URL para la solicitud
    String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + 
            baseCurrency + "/" + targetCurrency;

    try {
        // Codigo para Enviar solicitud GET a la API
        // Codigo para procesar la respuesta JSON y obtener la tasa de conversión
    
    } catch (Exception e) {
        // Manejar la excepción
        System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
        throw new RuntimeException("Error al obtener la tasa de cambio.");
    }
}
```
## Contribuir
¡Siéntete libre de contribuir al proyecto! Si tienes ideas para nuevas 
características, mejoras en el código o correcciones de errores, abre un pull
request y estaré encantado de revisarlo.

## Creado por

Este proyecto fue creado por [Fica](https://github.com/Fica-Millan).



¡Siéntete libre de contactarme si tienes alguna pregunta o sugerencia!

[LinkedIn](https://www.linkedin.com/in/yesica-fica-millan/)