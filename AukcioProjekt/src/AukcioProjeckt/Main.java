package AukcioProjeckt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static List<Festmeny> festmenyek;
    static List<Festmeny> sorfestmenyek;


    public static void main(String[] args) {
        festmenyek = new ArrayList<>();
        sorfestmenyek = new ArrayList<>();
        listurites();
        try {
            beolvas("festmenyek.csv");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        //fel2a();
        //fel2b();
        fel2d();
        kiir();
        fel2e();
        //fel3a();
        kiir();
        //fel3a();
        //fel3b();
        //fel3c();
        fel3d();
        //kiir();
    }

    public static void listurites() {
        festmenyek.clear();
    }

    public static void beolvas(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String szoveg = br.readLine();
        while (szoveg != null && !szoveg.equals("")) {
            String[] tomb = szoveg.split(";");
            Festmeny festmeny = new Festmeny(tomb[1], tomb[0], tomb[2]);
            festmenyek.add(festmeny);
            szoveg = br.readLine();
        }
        br.close();
        fr.close();
    }

    public static void kiir() {
        for (int i = 0; i < festmenyek.size(); i++) {
            System.out.println(festmenyek.get(i));
        }
    }

    public static void fel2a(){
        festmenyek.add(new Festmeny("elso", "elsokesz", "stilus1"));
        festmenyek.add(new Festmeny("masodik", "masodikkesz", "stilus2"));
    }

    public static void fel2b(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem adja meg, hogy mennyi elemet adna hozzá a listához: ");
        int szam = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < szam; i++) {
            System.out.print("Kérem adja meg a festmény címét:");
            String cím = sc.nextLine();
            System.out.print("Kérem adja meg a festmény készítőjét:");
            String festo = sc.nextLine();
            System.out.print("Kérem adja meg a festmény stilusát: ");
            String stilus = sc.nextLine();
            festmenyek.add(new Festmeny(cím, festo, stilus));
        }
    }

    public static void fel2d() {
        for (int i = 0; i < 20; i++) {
            int feldob = (int) (Math.random() * festmenyek.size());
            festmenyek.get(feldob).licit();
        }
    }

    public static void fel2e() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem adja meg, hogy melyik festményre szeretne licitálni: ");
        int bekert = sc.nextInt();
        sc.nextLine();
        while (bekert != 0) {
            while(bekert - 1 < 0 || bekert - 1 > festmenyek.size()){
                System.out.print("Hiba ilyen számú elem nem létezik. Kérem írjon be egy új számot: ");
                bekert = sc.nextInt();
                sc.nextLine();
            }if (festmenyek.get(bekert - 1).isElkelt()) {
                System.out.println("Ez a festmény elkelt.");
            } else {
                System.out.print("Kérem adja meg, hogy mennyit szeretne licitálni: ");
                int osszeg = sc.nextInt();
                sc.nextLine();
                while(osszeg<10 || osszeg>100){
                    System.out.print("Kérem adja meg, hogy mennyit szeretne licitálni: ");
                    osszeg = sc.nextInt();
                    sc.nextLine();
                }
                festmenyek.get(bekert - 1).licit(osszeg);
                System.out.printf("Feladat 2/e: A számadik elem a: %s", festmenyek.get(bekert - 1));
            }
            System.out.print("Kérem adja meg, hogy melyik festményre szeretne licitálni: ");
            bekert = sc.nextInt();
        }
            System.out.println("Kilépés...");
        for (int i = 0; i < festmenyek.size(); i++) {
            if (festmenyek.get(i).getLicitekSzama() > 0){
                festmenyek.get(i).setElkelt(true);
            }
        }
    }

    public static void fel3a() {
        int maxosszeg = 0;
        int index = 0;
        for (int i = 0; i < festmenyek.size(); i++) {
            if (festmenyek.get(i).getLegmagasabbLicit() > maxosszeg && festmenyek.get(i).isElkelt()) {
                maxosszeg = festmenyek.get(i).getLegmagasabbLicit();
                index = i;
            }
        }
        System.out.printf("Feladat 3a: A legdrágább festmény a %s", festmenyek.get(index));
    }

    public static void fel3b() {
        boolean volteTiz = false;
        for (int i = 0; i < festmenyek.size(); i++) {
            if (festmenyek.get(i).getLicitekSzama() > 10) {
                volteTiz = true;
            }
        }
        System.out.printf("\n Feladat 3/b: a volt-e tíz értéke: %s", volteTiz);
    }

    public static void fel3c() {
        int nemkeltel = 0;
        for (int i = 0; i < festmenyek.size(); i++) {
            if (!festmenyek.get(i).isElkelt()){
                nemkeltel++;
            }
        }
        System.out.printf("Feladat 3/c: Összesen %d festmény nem kelt el.",nemkeltel);
    }

    public static void fel3d(){
        festmenyek.sort((x, y) ->(x.getLegmagasabbLicit() > y.getLegmagasabbLicit()) ? -1 :1);
        System.out.println(festmenyek);
    }
}

