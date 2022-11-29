import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(faktorialis(3));
        System.out.println(hatvanyozas(3, 10));
        int darab = 7;
        int max = 35;
        int[] tomb =new int[darab];
        lotto(tomb, max, darab);
        for (int szam: tomb) {
            System.out.println(szam);
        }

    }

    public static int faktorialis(int n) {
        if (n > 0) {
            return n * (faktorialis(n - 1));
        }
        return 1;
    }

    public static int hatvanyozas(int alapp, int hatvany) {
        int alap = alapp;
        int kitevo = hatvany;
        int eredmeny = 1;
        for (int i = 1; i <= kitevo; i++) {
            eredmeny *= alap;
        }
        return eredmeny;

    }

    public static void lotto(int[] szamok, int max, int db) {
        if (db > 0){
            int proba =(int) (Math.random()*max+1);
            boolean benne= (Arrays.stream(szamok).anyMatch(szam -> szam == proba));
            if (benne){
                lotto(szamok, max, db);
            }else {
                szamok[db-1]=proba;
                lotto(szamok, max, db-1);
            }

        }

    }
    public static int lkr(int[] t,int j, int b, int e){
        int center=0;
        if (b > j){
            return 0;
        }else{
            int c = (b + j / 2);
            if (t[c]== e){
                return c;

            }else{
                if (t[c]>e){
                    return lkr(t, b, c-1,e);
                }else {
                    return lkr(t, c+1, j, e);
                }
            }
        }
    }
}
