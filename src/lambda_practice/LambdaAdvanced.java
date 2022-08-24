package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaAdvanced {
    //multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR
    public static void main(String[] args) {
         /*TASK :
        2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm
        elemanları bir
        listeye kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
        Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
           Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
         */
        String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};
        /* TASK :
   Bir integer list oluşturunuz ve bu list’deki tum sayıların karesinin
   toplamını bulan code create ediniz.
    */
        List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 4));
        System.out.println(numbers.stream().map(t -> t * t).reduce(0, (y, g) -> y + g));
        System.out.println(numbers.stream().mapToInt(t -> t * t).sum());
    }
}
