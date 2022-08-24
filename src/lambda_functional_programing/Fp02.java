package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {
    /*
    1) t->"Logic" , (t,u)-> "Logic"
       Bu yapiya "Lambda Expession"
    2) Functional Programming kapsaminda "Lambda Expession" kullanilabilir ama onerilmez.
       "Lambda Expession" yerine "Method Reference" tercih edilir.
    3) Method Reference kullanimi "Class Name :: Method Name

       Ayni zamanda kendi classlarimizi da kullanabilirsiniz.
       Ornegin bir Animal class'iniz var ve bu class  eat() methoduna sahip ==> "Animal :: eat"
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
        listElemanlariniYazdirFunctional(list);
        System.out.println("");
        ciftElemanlariYazdirFunctional(list);
        System.out.println("");
        tekElemanlarinKareleriniYazdir(list);
        System.out.println("");
        tekrarsizTekElemanlarinKupunuYazdir(list);
        System.out.println("");
        tekrarsizCiftElemanlarinKareToplami1(list);
        tekrarsizCiftElemanlarinKareToplami2(list);
        tekrarsizCiftElemanlarinKareToplami3(list);
        tekrarsizCiftElemanlarinKuplerininCarpimi(list);
        getMaxEleman(list);
        getMinEleman(list);
        yedidenBuyukCiftMinimum(list);
        tersSiralamaylaTekrarsizElemanlarinYarisi(list);

    }

    // 1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional ve method reference)
    public static void listElemanlariniYazdirFunctional(List<Integer> list) {
        list.
                stream().
                forEach(Utils::ayniSatirdaBosluklaYazdir);

    }

    // 2) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {
        list.
                stream().
                filter(t -> t % 2 == 0).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    //3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {
        list.
                stream().
                filter(Utils::tekElemaniSec).
                map(Utils::karesinAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    // 4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {
        list.stream().
                distinct().
                filter(Utils::tekElemaniSec).
                map(Utils::kupunuAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    // 5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.
    //  1.yol
    public static void tekrarsizCiftElemanlarinKareToplami1(List<Integer> list) {

        Integer toplam = list.stream().
                distinct().filter(Utils::ciftElemaniSec).
                map(Utils::karesinAl).
                reduce(0, Math::addExact);
        System.out.println(toplam + " tekrarsizCiftElemanlarinKareToplami1(list)");
    }

    //  2.yol
    public static void tekrarsizCiftElemanlarinKareToplami2(List<Integer> list) {

        Integer toplam = list.
                stream().
                distinct().
                filter(Utils::ciftElemaniSec).
                map(Utils::karesinAl).
                reduce(Math::addExact).
                get();
        System.out.println(toplam + " tekrarsizCiftElemanlarinKareToplami2(list)");
    }

    //  3.yol
    public static void tekrarsizCiftElemanlarinKareToplami3(List<Integer> list) {

        Integer toplam = list.
                stream().
                distinct().
                filter(Utils::ciftElemaniSec).
                map(Utils::karesinAl).
                reduce(0, Integer::sum);
        System.out.println(toplam + " tekrarsizCiftElemanlarinKareToplami3(list)");
    }

    // 6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list) {
        Integer carpim = list.
                stream().
                distinct().
                filter(Utils::ciftElemaniSec).
                map(Utils::kupunuAl).
                reduce(1, Math::multiplyExact);
        System.out.println(carpim + " tekrarsizCiftElemanlarinKuplerininCarpimi(list)");
    }

    // 7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void getMaxEleman(List<Integer> list) {
        Integer max = list.
                stream().
                distinct().
                reduce(Math::max).
                get();
        System.out.println(max + " getMaxEleman(list)");
    }

    // 8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)
    public static void getMinEleman(List<Integer> list) {
        Integer min = list.
                stream().
                distinct().
                reduce(Math::min).
                get();
        System.out.println(min + " getMinEleman(list)");
    }

    // 9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    public static void yedidenBuyukCiftMinimum(List<Integer> list) {
        Integer min = list.
                stream().
                distinct().
                filter(t -> t > 7).
                filter(Utils::ciftElemaniSec).
                reduce(Math::min).
                get();
        System.out.println(min + " yedidenBuyukCiftMinimum(list)");
    }

    // 10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list) {
        List<Double> sonuc = list.
                stream().// Gerekli methodlari kullanmamizi saglar
                        distinct().// tekrarli olanlari almaz
                        filter(t -> t > 5).// kosula gore filtreleme yapar
                        map(Utils::yarisiniAl).// her bir elemanin degerini degistirmeye yarar
                        sorted(Comparator.reverseOrder()).// siralama yapar
                        collect(Collectors.toList());// Elemanlari collection'a cevirir
        System.out.println(sonuc);
    }

}
