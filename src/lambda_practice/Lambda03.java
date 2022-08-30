package lambda_practice;

import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda03 {
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar
    // tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming
    public static int toplaAmele(int i) {
        int toplam = 0;
        for (int j = 0; j <= i; j++) {
            toplam += j;
        }
        return toplam;
    }

    //TODO Functional(cincix Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1).//1den x e kdar x dahil int degerler alindi
                        sum();
    }

    //TODO TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).//1 den x e kadar int ler alindi x dahil
                        filter(t -> t % 2 == 0).//akisda ki cift int degerler alindi
                        sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).//2 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akisdaki ilk x degeri alir
                        sum();
    }

    //TODO TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).//1 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akisdaki ilk x degeri alir
                        sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.iterate(2, t -> t * 2).limit(x).forEach(Methods::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void isteneSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.iterate(istenenSayi, t -> t * istenenSayi).limit(x).forEach(Methods::yazdir);
    }

    //TODO TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int x) {
        return IntStream.rangeClosed(1, x).reduce(1, (t, u) -> t * u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double xKuvveti(int sayi, int x) {
        return Math.pow(sayi, x);//math classina git pow kuvvetini alir
        //return IntStream.iterate(sayi,t->t*sayi).limit(x).reduce(0,(t,u)->u);
    }
}