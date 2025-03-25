# 🌍 ForexConvert API

ForexConvert API es una API sencilla y eficiente para obtener tasas de cambio entre diferentes monedas y calcular conversiones en tiempo real vinculada a las tasas de conversion de [Investing.com](https://www.investing.com/). 

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

### ⤴️ Obtener todas las tasas de cambio

Todas las divisas se cambian a Dolar y luego esta a otra moneda se hace asi por optimización de la base de datos.

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
GET /rate?from={moneda_origen}&to={moneda_destino}&amount={cantidad}
```

**Ejemplo:** Convertir **10 GBP** a **EUR**

```http
GET /rate?from=gbp&to=eur&amount=10
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

Debera tener el maven instalado -> [Maven]("https://maven.apache.org/download.cgi")

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/oriolcarulla/forexconvert-api.git
   cd forexconvert-api
   ```
2. Construir el proyecto:
   ```sh
   mvn clean install
   ```

   Acceder a target/classes/application.properties
   Y cambiar: `spring.datasource.url=jdbc:sqlite:forexconvert.db`

   por: `spring.datasource.url=jdbc:sqlite:../forexconvert.db`

   Esto es necesario ya que sino no habra conexión con la base de datos.
3. Ejecutar la aplicación:
   
   En caso de estar en Linux 
   ```sh
   source venv/bin/activate
   python3 scraping.py #es un bucle que va actualizando la BDD
   mvn spring-boot:run
   ```

   En caso de estar en Windows
   ```sh
   .\venv_windows\Scripts\activate
   python scraping.py o py scraping.py
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

