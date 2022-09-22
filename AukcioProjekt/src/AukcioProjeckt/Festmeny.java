package AukcioProjeckt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
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

    public void setLegmagasabbLicit(int legmagasabbLicit) {
        this.legmagasabbLicit = legmagasabbLicit;
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
        if (elkelt) {
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
        if (licitekSzama != 0) {
            this.legmagasabbLicit = (int) (legmagasabbLicit * 1.1);
        } else {
            legmagasabbLicit = legmagasabbLicit * (mertek / 100 + 1);
        }
    }
    @Override
    public String toString() {
        return "\n"+this.festo + ": " + this.cim + "(" + this.stilus + ")\n" +
                this.elkelt + "\n" +
                "Legmagasabb licit: " + this.legmagasabbLicit + " legutolsó licit Ideje: ( összesen: " + this.licitekSzama + " db)\n";
    }
}
