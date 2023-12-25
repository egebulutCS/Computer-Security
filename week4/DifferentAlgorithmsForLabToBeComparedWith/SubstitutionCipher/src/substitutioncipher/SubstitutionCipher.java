/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substitutioncipher;

/**
 *
 * @author LukasVyhnalek
 */
public class SubstitutionCipher {
    //
    static char encryptMap[]= {'j','a','v','b','e','n','c','d','f','g','h','i','k',
                        'l','m','o','p','q','r','s','t','u','w','r','x','y'};
    public static int decryptMap(char c){
        for(int i = 0 ; i < 26; i++){
            if(c == encryptMap[i]){
                return i;
            }
        }
        return -1;
    }
    
    public static String encrypt(String msg){
        int DiffLowUpper = 'A' -'a';
        String result = "";
        for(int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    c -= DiffLowUpper;
                    c = encryptMap[c - 'a'];
                    c += DiffLowUpper;
                }else{
                    c = encryptMap[c - 'a'];
                }
            }
            result += c;
        }
        return result;
    }
    
    public static String decrypt(String msg){
        int DiffLowUpper = 'A' -'a';
        String result = "";
        for(int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    c -= DiffLowUpper;
                    c = (char)('A' + decryptMap(c));
                }else{
                    c = (char)('a' + decryptMap(c));
                }
            }
            result += c;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String msg = "EQJHDXXQVAPTPQJKTOYQWIPBVWLXTOXBTFXQWAXBVCXQWAXFQJVWLEQNTO\n" +
"ZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJVWLBTPQWAEBFPBFHCVLXBQUFE\n" +
"VWLXGDPEQVPQGVPPBFTIXPFHXZHVFAGFOTHFEFBQUFTDHZBQPOTHXTYFTODXQ\n" +
"HFTDPTOGHFQPBQWAQJJTODXQHFOQPWTBDHHIXQVA";
        System.out.println("Original Message: " + msg);
        String enMsg = encrypt(msg);
        System.out.println("Encrypted Message: " +enMsg);
        String orMsg = decrypt(enMsg);
        System.out.println("Decrypted Message: " +orMsg);
    }
    
}
