package AukcioProjeckt;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
    }

    public Festmeny(int licitekSzama, int legmagasabbLicit, boolean elkelt) {
        this.licitekSzama = licitekSzama;
        this.legmagasabbLicit = legmagasabbLicit;
        this.elkelt = elkelt;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean isElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elketlt) {

    }

    public void licit() {
        if (this.elkelt == true) {
            System.out.println("A festmény már elkelt!");
        } else if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
            this.licitekSzama = licitekSzama + 1;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        } else if (this.licitekSzama >= 1) {
            this.legmagasabbLicit = (int) (legmagasabbLicit * 1.1);
            this.licitekSzama = licitekSzama + 1;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        }
    }

    public void licit(int mertek) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem adjon meg egy számot 10 és 100 között.");
        int szazalek = sc.nextInt();
        while(szazalek<10 || szazalek>100){
            System.out.println("Hiba a szám 10 és 100 között kell, hogy legyen.");
            szazalek = sc.nextInt();
        }
        this.legmagasabbLicit = legmagasabbLicit * szazalek/100+1;
    }
}
