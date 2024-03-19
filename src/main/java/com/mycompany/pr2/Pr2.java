/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pr2;

/**
 *
 * @author arrri
 */
import java.util.*;

public class Pr2 {
    // Создаем словарь для хранения слов и их переводов
    private static Map<String, Set<String>> dictionary = new TreeMap<>();

    public static void main(String[] args) {
        
        addWord("Abdication", "отречение");
        addWord("Aperitif", "аперитив");
        addWord("Mead", "мёд");
        addWord("Zizz", "жужжание");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить слово в словарь");
            System.out.println("2. Удалить слово из словаря");
            System.out.println("3. Выйти из программы");
            System.out.print("Введите номер: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Введите слово на английском: ");
                    String word = scanner.nextLine();
                    System.out.print("Введите русский перевод: ");
                    String translation = scanner.nextLine();
                    addWord(word, translation);
                    break;
                case 2:
                    System.out.print("Введите слово, которое нужно удалить: " );
                    String wordToDelete = scanner.nextLine();
                    removeWord(wordToDelete);
                    break;
                case 3:
                    System.out.println("Выйти");
                    System.exit(0);
                default:
                    System.out.println(" Напишите 1,2 или 3");
            }

            
            System.out.println("\nСловаря:");
            for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
                System.out.print(entry.getKey() + " - ");
                System.out.println(String.join("; ", entry.getValue()));
            }
        }
    }

    
    private static void addWord(String word, String translations) {
        Set<String> translationSet = dictionary.getOrDefault(word, new TreeSet<>());
        translationSet.addAll(Arrays.asList(translations.split(",\\s*")));
        dictionary.put(word, translationSet);
    }

    
    private static void removeWord(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.println("Слово \"" + word + "\" удалено.");
        } else {
            System.out.println("Слово \"" + word + "\" не найдено.");
        }
    }
}
