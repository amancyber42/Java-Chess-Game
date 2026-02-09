# ♟️ Chess Game

Moderna implementacija šaha u Javi s jasno odvojenom **game logic** i **GUI** arhitekturom. Projekt je zamišljen kao edukativni primjer objektno-orijentiranog dizajna (OOP), uz postepenu izgradnju funkcionalnosti.

---

## ✨ Značajke

* Čista **OOP arhitektura** (model / GUI razdvojeni)
* Osnovna pravila šaha (u izradi)
* Modularna struktura projekta
* Jednostavan Swing GUI
* Proširivo za AI, online play ili JavaFX

---

### 📦 `chess` package (Model / Domain)

* Ne zna ništa o GUI-u
* Sadrži pravila igre i stanje
* Može se testirati bez grafike

### 🎨 `gui` package (Presentation)

* Prikazuje stanje igre
* Reagira na korisnički input
* Koristi klase iz `chess` paketa

---

## 🚀 Pokretanje projekta

### Preduvjeti

* **Java JDK 17+**
* **VS Code** s instaliranim:

  * Extension Pack for Java

Provjera instalacije:

```bash
java -version
javac -version
```

### Pokretanje (GUI)

Pokreni klasu:

```
ChessGameGUI.java
```

### Pokretanje (bez GUI-a – test logike)

Pokreni:

```
ChessGame.java
```

---

## 🧪 Trenutni status

* [x] Osnovna struktura projekta
* [x] Core klase (`Piece`, `Position`, `Game`)
* [x] Osnovni GUI prozor
* [ ] Implementacija figura (Pawn, Rook, etc.)
* [ ] Validacija poteza
* [ ] Check / Checkmate logika
* [ ] Restart igre

---

## 🧠 Dizajnerske odluke

* **Separation of Concerns** – game logic i GUI su strogo razdvojeni
* **Apstraktna klasa `Piece`** – omogućava lako dodavanje novih figura
* **Minimalni GUI** – fokus na čistu logiku igre

---

## 📚 Moguća proširenja

* AI protivnik (Minimax)
* Online multiplayer
* JavaFX GUI
* Snimanje / učitavanje partije
* Unit testovi

---

## 🧑‍💻 Autor

* Projekt razvijen kao edukativni Java/OOP projekt

---

## 📄 Licenca

Ovaj projekt je open-source i može se slobodno koristiti u edukativne svrhe.

---

> ♟️ *"Šah je problem, matematika i umjetnost u isto vrijeme."*


<img width="1915" height="1029" alt="Chess_Game" src="https://github.com/user-attachments/assets/e1bd1e40-e243-4bad-8342-6ea92981dd76" />
