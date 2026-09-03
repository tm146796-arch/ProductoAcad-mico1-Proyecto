# Cordero_pa1

Proyecto academico N 1 para el curso Desarrollo de aplicaciones movil.

## Datos

- Estudiante: Anyisell Cordero
- Universidad: Universidad Continental del Peru
- Aplicacion: Cordero_pa1
- Paquete: org.pa1.cordero

## Descripcion

Aplicacion Android basica desarrollada en Java y XML. La app usa un SplashActivity inicial, un Navigation Drawer y fragments para mostrar la informacion del estudiante y resolver cuatro ejercicios.

## Funcionalidades

- SplashActivity con animacion de 3 segundos.
- Navigation Drawer para navegar entre pantallas.
- Fragment Acerca como pantalla por defecto.
- Calculo del area de un triangulo usando la longitud de sus tres lados.
- Generacion de un numero aleatorio de 6 cifras y validacion de 3 digitos impares.
- Conversion de numero binario a decimal.
- Conversion de numero hexadecimal a binario.
- Estilos comunes definidos en los recursos XML.

## Estructura principal

- `SplashActivity.java`: pantalla inicial con animacion.
- `MainActivity.java`: pantalla principal con Navigation Drawer.
- `AcercaFragment.java`: datos del estudiante.
- `TrianguloFragment.java`: ejercicio de area de triangulo.
- `NumeroAleatorioFragment.java`: ejercicio de numero aleatorio.
- `BinarioDecimalFragment.java`: conversion de binario a decimal.
- `HexBinarioFragment.java`: conversion de hexadecimal a binario.

## Como ejecutar

1. Abrir el proyecto en Android Studio.
2. Esperar a que Gradle sincronice.
3. Ejecutar la aplicacion en un emulador o dispositivo Android.

Tambien se puede compilar desde terminal:

```bash
./gradlew clean assembleDebug
```

El APK debug se genera en:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Requisitos usados

- Android Studio
- Java
- Gradle Wrapper incluido en el proyecto
- Java 11 configurado en Gradle

## Verificacion

La compilacion fue validada con:

```bash
./gradlew clean assembleDebug
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```
