import requests
from bs4 import BeautifulSoup
import sqlite3

def get_rate(currency):
    url = f"https://es.investing.com/currencies/usd-{currency}"
    response = requests.get(url)
    soup = BeautifulSoup(response.content, "html.parser")
    rate = soup.find("div", {"class": "text-5xl/9 font-bold text-[#232526] md:text-[42px] md:leading-[60px]"}).text
    return rate

if __name__ == "__main__":
    conn = sqlite3.connect("forexconvert.db")
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE IF NOT EXISTS currency (currency TEXT, rate REAL)")
    currencies = ["eur", "gbp"]
    for currency in currencies:
        rate = get_rate(currency)
        cursor.execute("UPDATE rate SET rate = ? WHERE currency = ?", (rate, currency))    
    conn.commit()
    conn.close()