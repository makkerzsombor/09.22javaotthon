package AukcioProjeckt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Festmeny> festmenyek;

    public static void main(String[] args) {
        festmenyek = new ArrayList<>();
        festmenyek.add(new Festmeny("elso", "elsokesz", "stilus1"));
        festmenyek.add(new Festmeny("masodik", "masodikkesz", "stilus2"));
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
        try {
            beolvas("festmenyek.csv");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        kiir();
        fel2d();
        //fel2e();
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
        for (int i = 0; i < 10; i++) {
            System.out.println(festmenyek);
        }
    }
    public static void fel2d(){
        for (int i = 0; i < 20; i++) {
            int feldob = (int)(Math.random() * festmenyek.size());
            festmenyek.get(feldob).licit();
        }
    }
    public static void fel2e(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem adja meg, hogy melyik festményre szeretne licitálni: ");
        int bekert = sc.nextInt();
        sc.nextLine();

    }
}

