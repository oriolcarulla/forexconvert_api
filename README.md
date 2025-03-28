# 🌍 ForexConvert API

![Java](https://img.shields.io/badge/Java-22-blue)
![Python](https://img.shields.io/badge/Python-3.x-green)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)
![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white)

ForexConvert API es una API sencilla y eficiente para obtener tasas de cambio entre diferentes monedas y calcular conversiones en tiempo real vinculada a las tasas de conversion de [Investing.com](https://www.investing.com/). Es usada en el repositorio [Forex-Convert](https://www.pypi.org/project/forex-convert) en python.
## 📚 Índice
- [Características](#-características)
- [Monedas disponibles](#-monedas-disponibles)
- [Uso](#-uso)
- [Instalación y ejecución](#️-instalación-y-ejecución)
- [Configuración del puerto](#️-configuración-del-puerto)
- [Contribuir](#-contribuir)
- [Licencia](#-licencia)

## ✨ Características

- ✔️ Obtén tasas de conversión entre las diversas mas conocidas.
- ✔️ Soporte para cálculo de conversiones directas e indirectas.
- ✔️ Desarrollado con **Python 3, Spring Boot** y **Java 22**.
- ✔️ Redondeo de valores de conversión con precisión de 4 decimales.

## 🔄 Monedas disponibles

| Código | Moneda           |
| ------ | ---------------- |
| USD    | Dólar estadounidense |
| EUR    | Euro             |
| GBP    | Libra esterlina  |
| JPY    | Yen japonés      |
| ARS    | Peso argentino   |
| CLP    | Peso chileno     |
| CHF    | Franco suizo     |
| CAD    | Dólar canadiense |
| CNY    | Yuan chino       |
| MXN    | Peso mexicano    |
| COP    | Peso colombiano  |

## 💪 Uso

### Libre uso en `oriolserver.ddns.net:8080`

### ⤴️ Obtener todas las tasas de cambio

```js
GET /rate/{moneda}
```

**Ejemplo de uso:**

```js
GET /rate/eur
```

```json
[
    {
        "currency": "usd",
        "rate": 1.0814
    },
    {
        "currency": "gbp",
        "rate": 0.8354
    },
    ...
]
```

### ✅ Convertir una cantidad entre monedas


```js
GET /rate?from={moneda_origen}&to={moneda_destino}&amount={cantidad}
```

**Ejemplo de uso:**

Convertir **10 GBP** a **EUR**
```js
GET /rate?from=gbp&to=eur&amount=10
```

```json
{
    "from": "GBP",
    "to": "EUR",
    "amount": 10,
    "rate": 1.1949,
    "result": 11.949
}
```

### 💱 Obtener todas las monedas disponibles
```js
GET /currency
```

**Ejemplo de uso**

```json
[
    "usd",
    "eur",
    "gbp",
    "jpy",
    "ars",
    "clp",
    "chf",
    "cad",
    "cny",
    "mxn",
    "cop"
]
```

## 🛠️ Instalación y ejecución

Tienes que tener el [Maven]("https://maven.apache.org/download.cgi") instalado.

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/oriolcarulla/forexconvert-api.git
   cd forexconvert-api
   ```
2. Construir el proyecto:
   ```sh
   mvn clean install
   ```
3. Ejecutar la aplicación:
   
   En caso de estar en Linux 
   ```sh
   source venv/bin/activate
   python3 scraping.py #es un bucle que va actualizando la BDD

   Desde la raiz del proyecto: 
   mvn spring-boot:run
   ```

   En caso de estar en Windows
   ```sh
   .\venv_windows\Scripts\activate
   python scraping.py o py scraping.py #es un bucle que va actualizando la BDD

   Desde la raiz del proyecto: 
   mvn spring-boot:run
   ```

## 🛡️ Configuración del puerto

El puerto por defecto es **8080**, pero puedes cambiarlo en el archivo [`application.properties`](src/main/resources/application.properties):

```properties
server.port=5000
server.addresses=0.0.0.0 #para que sea visible por todo el mundo
```

## 💎 Contribuir

Si quieres mejorar la API, ¡las contribuciones son bienvenidas! Haz un fork del proyecto, crea una nueva rama y envía un pull request.

## 📢 Licencia

Este proyecto está bajo la licencia **MIT**. ¡Usa y modifica libremente!

---

✨ **Desarrollado con amor y código por Oriol Carulla** ✨

