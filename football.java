import java.util.*;
import java.util.stream.*;

class Hashset
{
     public static <T> Set<T> convertArrayToSet(T array[])
    {
        return Arrays.stream(array).collect(Collectors.toSet());
    }
 

    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
        String[] sq = squads.split("#");
        Set<String> s1 = new HashSet<String>(Arrays.asList(sq[0].split(" ")));

        for (int i=1; i<numberOfMatches; i++){
          Set<String> s2 = new HashSet<String>(Arrays.asList(sq[i].split(" ")));
          s1.retainAll(s2);
        }
        System.out.println(s1);
        String a = String.join(" ", s1);
        System.out.println(a);
        Set<String> x = convertArrayToSet(sq[squad1-1].split(" "));
        Set<String> y = convertArrayToSet(sq[squad2-1].split(" "));
        y.removeAll(x);
        String b = String.join(" ", y);
        System.out.println(b);
        String ans = a+", "+b;
        System.out.println(ans);
        System.out.println(ans.hashCode());

        return null;
    }
}

public class football{
  public static void main(String[] args) {
    Hashset s = new Hashset();
    int numberOfMatches = 3;
    // String squads = "Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Ronaldo Eder Andre Bruma Ricardo Domingos#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi";    
    String squads = "Messi Saravia Tagliafico Pezzella Saravia Lamela Nehuen Marcos Leandro Celso Andrada Paul Rodriguez Dominguez Palacios Tagliafico Pezzella Saravia Balerdi Nehuen Marcos Leandro Celso Musso Otamendi Tagliafico Pezzella Saravia Balerdi#Ocampos Allister Messi Aguero Dybala Martinez Alario Gonzalez Marchesin Andrada Lamela Kannemann Saravia Montiel Quarta Allister Messi Aguero Dybala Martinez Alario Andrada Foyth Kannemann Rojo Montiel Quarta#Figal Messi Casco Mercado Saravia Lisandro Lamela Andrada Lanzini Maria Lamela Meza Fernandez Gimenez Marcone Casco Mercado Sigali Lisandro Lamela Zaracho Lanzini Lisandro Lamela Zaracho Lanzini Maria Pizarro#Blanco Correa Vargas Correa Gaich Armani Suarez Icardi Gonzalo Benedetto Messi Saravia Sigali Andrada Lamela Armani Suarez Icardi Gonzalo Benedetto Messi Saravia Sigali#Musso Otamendi Tagliafico Pezzella Saravia Balerdi Ocampos Allister Messi Aguero Dybala Martinez Andrada Lamela Gonzalo Pezzella Saravia Balerdi Ocampos Allister Messi Aguero Dybala Dybala Martinez Andrada Lamela Gonzalo Pezzella Saravia#Messi Saravia Tagliafico Pezzella Saravia Ocampos Allister Andrada Lamela Foyth Kannemann Rojo Montiel Quarta Sigali Pezzella Saravia Ocampos Allister Andrada Lamela Foyth Kannemann Rojo Saravia Tagliafico Pezzella Saravia Ocampos Allister Andrada Lamela";
    int squad1 = 2;
    int squad2 = 5;
    String actual = s.getOut(numberOfMatches, squads, squad1, squad2);
    // System.out.println(actual.hashCode());
    System.out.println(actual);
  }
}