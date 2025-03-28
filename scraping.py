import requests
from bs4 import BeautifulSoup
import sqlite3
import time

def get_rate(currency):
    url = f"https://es.investing.com/currencies/usd-{currency}"
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    }
    response = requests.get(url, headers=headers)

    if response.status_code != 200:
        print(f"Error {response.status_code} al obtener {url}")
        return 0  # Si la solicitud falla, devuelve 0

    soup = BeautifulSoup(response.content, "html.parser")
    
    try:
        rate_element = soup.find("div", class_="text-5xl/9 font-bold text-[#232526] md:text-[42px] md:leading-[60px]")
        if rate_element is None:
            print(f"No se encontró la tasa de {currency}. Puede que la estructura de la web haya cambiado.")
            return 0  # Si no encuentra el dato, devuelve 0

        rate = rate_element.text.strip()
        rate = rate.replace(".", "").replace(",", ".")  # Normalizar números
        return float(rate)  # Convertir a número
    except Exception as e:
        print(f"Error al obtener la tasa de {currency}: {e}")
        return 0  # Si hay algún error, devuelve 0

if __name__ == "__main__":
    conn = sqlite3.connect("forexconvert.db")
    cursor = conn.cursor()

    # Crear tabla si no existe
    cursor.execute("""
        CREATE TABLE IF NOT EXISTS rates (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            usd TEXT NOT NULL,
            currency TEXT NOT NULL,
            rate REAL NOT NULL
        )
    """)
    cursor.execute("select * from rates where currency = 'usd'")
    if not cursor.fetchall():
        cursor.execute("insert into rates (usd, currency, rate) values ('usd', 'usd', 1)")
    conn.commit()

    currencies = ["eur", "gbp", "jpy", "ars", "clp", "chf", "cad", "cny", "mxn", "cop"]
    
    # Insertar las monedas si no existen
    for currency in currencies:
        cursor.execute("SELECT * FROM rates WHERE currency = ?", (currency,))
        if not cursor.fetchall():
            cursor.execute("INSERT INTO rates (usd, currency, rate) VALUES (?, ?, ?)", ("usd", currency, 0))

    # Actualizar las tasas de cambio
    while True:
        for currency in currencies:
            rate = get_rate(currency)  # Si es None, devolverá 0
            cursor.execute("UPDATE rates SET rate = ? WHERE currency = ?", (rate, currency))
            conn.commit()
        print("Tasas actualizadas")
        time.sleep(60)  # Esperar 1 minuto