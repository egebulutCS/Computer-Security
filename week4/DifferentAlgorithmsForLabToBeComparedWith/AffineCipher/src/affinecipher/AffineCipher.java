/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

/**
 *
 * @author LukasVyhnalek
 */
public class AffineCipher {

    public static String encrypt(String msg, int a, int b) {
        String result = "";
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (Character.isLetter(c)) {
                char offset = (Character.isUpperCase(c)) ? 'A' : 'a';
                c = (char) ((((a * (c - offset)) + b) % 26) + offset);

            }
            result += c;
        }
        return result;
    }
    
    public static String decrypt(String msg, int a, int b){
        int inv = 0;
        int temp = 0;
        String result = "";
        for(int i = 0; i < 26; i++){
            temp = (a * i) % 26;
            
            if(temp == 1){
                inv = i;
            }
        }
        
        for(int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                char offset = (Character.isUpperCase(c)) ? 'A' : 'a';
                temp = inv * (c - offset - b + 26);
                c = (char) (temp % 26 + offset);     
            }
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        String msg = "EQJHDXXQVAPTPQJKTOYQWIPBVWLXTOXBTFXQWAXBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJVWLBTPQWAEBFPBFHCVLXBQUFEVWLXGDPEQVPQGVPPBFTIXPFHXZHVFAGFOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQHFOQPWTBDHHIXQVA";
        int a = 0;
        int b = 0;
        for(int i = 0; i < 26; i++){
            a=i;
            for(int j = 0; j < 26; j++){
                b=j;
                //System.out.println("Original Message: " + msg);
                //String enMsg = encrypt(msg, a, b);
                //System.out.println("Encrypted Message: " + enMsg);
                String orMsg = decrypt(msg, a, b);
                System.out.println("Decrypted Message: " + orMsg);
            }
        }
    }

}
