# 🌍 ForexConvert API

ForexConvert API es una API sencilla y eficiente para obtener tasas de cambio entre diferentes monedas y calcular conversiones en tiempo real vinculada a las tasas de conversion de [Investing.com](https://www.investing.com/). 

## ✨ Características

- ✔️ Obtén tasas de conversión entre las diversas mas conocidas.
- ✔️ Soporte para cálculo de conversiones directas e indirectas.
- ✔️ Desarrollado con **Spring Boot** y **Java**.
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

### ⤴️ Obtener todas las tasas de cambio

```http
GET /rates
```

**Ejemplo de respuesta:**

```json
[
    {
        "id": 1,
        "usd": "usd",
        "currency": "eur",
        "rate": 0.9229
    },
    {
        "id": 2,
        "usd": "usd",
        "currency": "gbp",
        "rate": 0.7728
    }
]
```

### ✅ Convertir una cantidad entre monedas

```http
GET /rates?from={moneda_origen}&to={moneda_destino}&amount={cantidad}
```

**Ejemplo:** Convertir **10 GBP** a **EUR**

```http
GET /rates?from=gbp&to=eur&amount=10
```

**Ejemplo de respuesta:**

```json
{
    "from": "GBP",
    "to": "EUR",
    "amount": 10,
    "rate": 1.1949,
    "result": 11.949
}
```

## 🛠️ Instalación y ejecución

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
   ```sh
   python scraping.py #es un bucle que va actualizando la BDD
   mvn spring-boot:run
   ```

## 🛡️ Configuración del puerto

El puerto por defecto es **8080**, pero puedes cambiarlo en el archivo `application.properties`:

```properties
server.port=5000
```

## 💎 Contribuir

Si quieres mejorar la API, ¡las contribuciones son bienvenidas! Haz un fork del proyecto, crea una nueva rama y envía un pull request.

## 📢 Licencia

Este proyecto está bajo la licencia **MIT**. ¡Usa y modifica libremente!

---

✨ **Desarrollado con amor y código por Oriol Carulla** ✨

