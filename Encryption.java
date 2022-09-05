import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class CipherDecipher{
    /**
     * This method is used to cipher the message (normal) by following steps.
     * Swap the cases of String - UpperCase letters to LowerCase letters and viceversa.
     * Reverse the String
     * Replace the spaces of string with a star character("*")
     * Replace the characters in the even positions of the string
     * Append any integer at the last in that String
     * 
     * @param normal
     * @return the ciphered message
     */
    public String ciphering(String normal){
        String n = "";
        for (int k=0; k<normal.length(); k++){
            char c = normal.charAt(k);
            if (Character.isUpperCase(c)){
                n += Character.toLowerCase(c);
            }else if (Character.isLowerCase(c)){
                n += Character.toUpperCase(c);
            }else {
                n += c;
            }
        }
        n = n.replaceAll(" ", "\\*");
        StringBuilder str = new StringBuilder(n);
        StringBuilder reversestr = str.reverse();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<reversestr.length(); i++){
            if (i%2==1){
                int l = reversestr.charAt(i);
                result.append(l);
            }
            else{
                result.append(reversestr.charAt(i));
            }
        }
        String ans = result.toString();
        ans += Integer.toString(3);
        return ans;
    }
    /**
     * This method is used to get the normal text by the reverse process of ciphering.
     * 
     * @param ciphered
     * @return the deciphered message
     */
    public String deciphering(String ciphered){
        StringBuilder result = new StringBuilder();
        String newstr = ciphered.substring(0, ciphered.length()-1);
        String ascii = "";
        int count = 0;
        for (int i=0; i<newstr.length(); i++){
            if (!Character.isDigit(newstr.charAt(i))){
                if (!ascii.equals("")){
                    int asciiVal = Integer.parseInt(ascii);
                    String str = new Character((char) asciiVal).toString();
                    result.append(str);
                    ascii = "";
                }
                result.append(newstr.charAt(i));
            }
            else{
               ascii += newstr.charAt(i);
            }
        }
        if (!ascii.equals("")){
            int asciiVal = Integer.parseInt(ascii);
            String str = new Character((char) asciiVal).toString();
            result.append(str);
            ascii = "";
        }
        String actual = result.toString();
        actual = actual.replaceAll("\\*", " ");
        String n = "";
        for (int k=0; k<actual.length(); k++){
            char c = actual.charAt(k);
            if (Character.isUpperCase(c)){
                n += Character.toLowerCase(c);
            }else if (Character.isLowerCase(c)){
                n += Character.toUpperCase(c);
            }else {
                n += c;
            }
        }
        StringBuilder str = new StringBuilder(n);
        StringBuilder reversestr = str.reverse();
        return reversestr.toString();
    }
}

public class Encryption {
    
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        String normal=readInput.nextLine();
        String ciphered=readInput.nextLine();
        
        CipherDecipher cipherOrDecipher = new CipherDecipher();
        System.out.println(cipherOrDecipher.ciphering(normal));
        System.out.println(cipherOrDecipher.deciphering(ciphered));
        
    }
    
}
