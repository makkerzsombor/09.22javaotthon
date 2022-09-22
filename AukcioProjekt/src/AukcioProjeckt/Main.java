package AukcioProjeckt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Festmeny> festmenyek ;
    public static void main(String[] args) {
        festmenyek = new ArrayList<>();
        festmenyek.add(new Festmeny("","",""));
        festmenyek.add(new Festmeny("","",""));
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
        }
        try {
            beolvas("festmenyek.csv");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    public static void beolvas(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String szoveg =  br.readLine();
        while(szoveg!=null && !szoveg.equals("")){
            String[] tomb = szoveg.split(";");
            Festmeny festmeny = new Festmeny(tomb[1],tomb[0],tomb[2]);
            festmenyek.add(festmeny);
            szoveg =  br.readLine();
        }
        br.close();
        fr.close();
    }
}
