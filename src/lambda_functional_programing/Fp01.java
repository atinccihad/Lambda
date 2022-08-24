package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    /*
    1) Lambda(Functional Programing) Java 8 ile kullanilmaya baslamistir
    2) Functional Programing'de ne yapilacak(What to do) uzerine yogunlasilir.
     Structured Programing "Nasil yapilacak"(How to do) uzerine yogunlasir.
    3) Functional Programing Arrays ve Collections ile kullanilir.
    4) "entrySet()  methodu ile Map, Set'e donusturulerek Functional Programing'de kullanilabilir.
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(131);
        list.add(10);
        list.add(9);
        list.add(10);
        list.add(2);
        list.add(8);
        System.out.println(list);


        listElemanlariniYazdirStructured(list);
        System.out.println(" ==> Structured listElemanlariniYazdirStructured");


        listElemanlariniYazdirFunctional(list);
        System.out.println(" ==> StructuredFunctional listElemanlariniYazdirFunctional");


        ciftElemanlariYazdirStructured(list);
        System.out.println(" ==> Structured ciftElemanlariYazdirStructured");


        ciftElemanlariYazdirFunctional(list);
        System.out.println(" ==> Functional ciftElemanlariYazdirFunctional");

        tekElemanlarinKareleriniYazdir(list);
        System.out.println(" ==> Functional tekElemanlarinKareleriniYazdir");

        tekrarsizTekElemanlarinKupunuYazdir(list);
        System.out.println(" ==> Functional tekrarsizTekElemanlarinKupunuYazdir");

        tekrarsizCiftElemanlarinKareToplami(list);
        System.out.println(" ==> Functional tekrarsizCiftElemanlarinKareToplami");

        tekrarsizCiftElemanlarinKupununCarpimi(list);
        System.out.println(" ==> Functional tekrarsizCiftElemanlarinKupununCarpimi");

        getMaxEleman01(list);
        System.out.println(" ==> Functional getMaxEleman01");

        getMaxEleman02(list);
        System.out.println(" ==> Functional getMaxEleman02");

        getMinEleman01(list);
        System.out.println(" ==> Functional getMinEleman01");

        getMinEleman02(list);
        System.out.println(" ==> Functional getMinEleman02");


        getyedidenBuyukCiftMin(list);
        System.out.println(" ==> Functional getyedidenBuyukCiftMin");

        getyedidenBuyukCiftMin2(list);
        System.out.println(" ==> Functional getyedidenBuyukCiftMin2");

        getyedidenBuyukCiftMin3(list);
        System.out.println(" ==> Functional getyedidenBuyukCiftMin3");

        tersSiralamaylaTekrarsizElemanlarinYarisi(list);
        System.out.println(" ==> Functional tersSiralamaylaTekrarsizElemanlarinYarisi");


    }

    // 1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
    public static void listElemanlariniYazdirStructured(List<Integer> list) {
        for (Integer w : list) {
            System.out.print(w + " ");
        }
    }

    // 1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        list.stream().forEach(t -> System.out.print(t + " "));
    }

    // 2) çift sayi olan list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
    public static void ciftElemanlariYazdirStructured(List<Integer> list) {
        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    // 2) çift sayi olan list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    // 3) Ardışık tek list elemanlarinin karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        // elemanlarin degerleri degisecekse map methodu kullanilir
    }

    // 4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {
        list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }

    // 5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.print(toplam);
    }

    // 6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {
        Integer carpim = list.stream().
                distinct().filter(t -> t % 2 == 0).
                map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.print(carpim);
    }

    // 7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    // 1.yol
    public static void getMaxEleman01(List<Integer> list) {
        Integer max = list.
                stream().
                distinct().
                reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);
        System.out.print(max);
    }

    // 2.yol
    public static void getMaxEleman02(List<Integer> list) {
        Integer max = list.
                stream().
                distinct().
                sorted().
                reduce(Integer.MIN_VALUE, (t, u) -> u);
        System.out.print(max);
    }

    // 8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)
    public static void getMinEleman01(List<Integer> list) {
        Integer min = list.
                stream().
                distinct().
                reduce(Integer.MAX_VALUE, (t, u) -> t > u ? u : t);
        System.out.print(min);
    }

    public static void getMinEleman02(List<Integer> list) {
        Integer min = list.
                stream().
                distinct().
                //sorted().
                        reduce(Integer.MAX_VALUE, (t, u) -> u);
        System.out.print(min);

    }

    // 9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    // 1. yol
    public static void getyedidenBuyukCiftMin(List<Integer> list) {
        Integer min = list.stream().
                distinct().filter(t -> t % 2 == 0).
                filter(t -> t > 7).reduce(Integer.
                        MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.print(min);
    }

    // 2. yol
    public static void getyedidenBuyukCiftMin2(List<Integer> list) {
        Integer min = list.stream().
                distinct().filter(t -> t % 2 == 0).
                filter(t -> t > 7).sorted(Comparator.
                        reverseOrder()).reduce(Integer.
                        MAX_VALUE, (t, u) -> u);
        System.out.print(min);
    }

    // 3. yol
    public static void getyedidenBuyukCiftMin3(List<Integer> list) {
        Integer min = list.stream().
                filter(t -> t % 2 == 0).
                filter(t -> t > 7).sorted().
                findFirst().get();
        System.out.print(min);
    }

    // 10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list) {
        List<Double> sonuc = list.stream().
                distinct().
                filter(t -> t > 5).
                map(t -> t / 2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.print(sonuc);
    }

}
