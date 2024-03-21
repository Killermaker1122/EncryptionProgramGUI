import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class EncryptionProgram {

    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    EncryptionProgram() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
    }

    private void newKey() {
        list.clear();
        shuffledList.clear();

        for (int i = 32; i < 127; i++) {
            list.add(character);
            character++;
        }

        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*");
    }

    public String encrypt(String message) {
        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        StringBuilder encryptedMessage = new StringBuilder();
        for (char x : letters) {
            encryptedMessage.append(x);
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        StringBuilder decryptedMessage = new StringBuilder();
        for (char x : letters) {
            decryptedMessage.append(x);
        }

        return decryptedMessage.toString();
    }
}