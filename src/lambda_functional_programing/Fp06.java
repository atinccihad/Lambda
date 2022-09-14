package lambda_functional_programing;

import java.util.*;

import static lambda_functional_programing.Fp01.listElemanlariniYazdirFunctional;
import static lambda_functional_programing.Fp01.listElemanlariniYazdirStructured;

public class Fp06 {
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


        // 1. Tekrarsiz 10'dan buyuk cift elemanlarin karelerini yazdiriniz.
        list.stream().distinct().filter(t-> t>9 && t%2==0).map(t-> t*t).forEach(System.out::print);
        System.out.println("");

        // 2. listedeki 3.enbuyuk elemani bulunuz
        list.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).skip(2).forEach(t-> System.out.print(t+" "));
        System.out.println("");

        // 3 en kucuk 2.elemanin kupunu bulunuz
        list.stream().distinct().sorted().limit(2).skip(1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
        System.out.println("");

        // 4 tekrarsiz tek sayilarin kupunu yazdiriniz
        list.stream().distinct().filter(t-> t%2==1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }
}
