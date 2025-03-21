from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time

def get_rate(currency):
    url = f"https://es.investing.com/currencies/usd-{currency}"

    # Configurar Selenium con ChromeDriver
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")  # Ejecutar en segundo plano
    options.add_argument("--disable-blink-features=AutomationControlled")  # Evitar detección de bot

    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)
    driver.get(url)

    time.sleep(5)  # Esperar que cargue la página

    try:
        rate_element = driver.find_element(By.CLASS_NAME, "text-5xl/9.font-bold")
        rate = rate_element.text.strip()
        rate = rate.replace(".", "").replace(",", ".")  # Normalizar número
        return float(rate)
    except Exception as e:
        print(f"Error al obtener la tasa de {currency}: {e}")
        return 0
    finally:
        driver.quit()  # Cerrar navegador

# Ejemplo de uso
print(get_rate("rub"))
