package edu.hillel.homework.lesson12;

import edu.hillel.homework.lesson12.list_methods.ListMethods;
import edu.hillel.homework.lesson12.phonebook.Phonebook;
import edu.hillel.homework.lesson12.phonebook.Record;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ListMethods listMethods = new ListMethods();

        //// part 1
        listMethods.delimiter(1);
        List<String> wordList = List.of("apple", "banana", "apple", "cherry", "date", "apple",
                "fig", "grape", "apple", "12345", "some text", "54321", "12345", "some text", "apple");
        String targetWord = "apple";
        System.out.println(listMethods.countOccurence(wordList, targetWord));

        //// part 2
        listMethods.delimiter(2);
        // Example with String type
        String[] stringArray = {"AA", "BB", "CC", "DD", "EE", "FF"};
        List<String> stringList = listMethods.toList(stringArray);
        for (String s : stringList) {
            System.out.print(s + ", ");
        }
        System.out.println();
        // Example with Character type
        Character[] charArray = {'A', 'B', 'C', 'D', 'E', 'F'};
        List<Character> charList = listMethods.toList(charArray);
        for (char ch : charList) {
            System.out.print(ch + ", ");
        }
        System.out.println();
        // Example with Integer type
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        List<Integer> integerList = listMethods.toList(integerArray);
        for (int i : integerList) {
            System.out.print(i + ", ");
        }
        System.out.println();

        //// part 3
        listMethods.delimiter(3);
        List<Integer> numbers = List.of(1, 2, 1, 3, 1, 4, 5, 6, 1, 2, 2, 1, 1, 1, 1, 2, 3, 1, 6);
        List<Integer> uniqueNumbers = listMethods.findUnique(numbers);
        for (int i : uniqueNumbers) {
            System.out.print(i + ", ");
        }
        System.out.println();

        //// part 4
        listMethods.delimiter(4);
        List<String> words = List.of("bird", "fox", "bird", "cat", "bird", "dog", "cat", "rabbit",
                "fox", "elephant", "fox", "cat", "bird", "bird", "fox", "cat", "dog", "rabbit", "cat", "cat");
        listMethods.calcOccurrence(words);

        //// part 5
        listMethods.delimiter(5);
        List<Map<String, Object>> occurrences = listMethods.findOccurrence(words);
        for (int i = 0; i < occurrences.size(); i++) {
            System.out.println(((i == 0) ? "[\n {" : " {") +
                    "name: " + occurrences.get(i).get("name") + ", " +
                    "occurrence: " + occurrences.get(i).get("occurrence") +
                    ((i < occurrences.size() - 1) ? "}," : "}\n]")
            );
        }

        //// part 6 (phonebook)
        listMethods.delimiter(6);
        Phonebook phonebook = new Phonebook();
        phonebook.add(new Record("Tymur", "+38(044)9379992"));
        phonebook.add(new Record("Tymur", "+38(044)9379992"));
        phonebook.add(new Record("Tymur", "+38(066)1234567"));
        phonebook.add(new Record("SomeName", "+38(050)3434567"));
        //phonebook.add(new Record("Name", "45379992")); // Example with invalid pone number format - throw InvalidPhoneNumberFormatException

        // print first record find for name "Vasya"
        System.out.println(phonebook.find("Vasya")); // null (user doesn't exist in phonebook)

        // print first record find for name "SomeName"
        System.out.println(phonebook.find("SomeName"));

        // print first record find for name "Tymur"
        System.out.println(phonebook.find("Tymur"));

        // print all records for name "Tymur"
        System.out.println(phonebook.findAll("Tymur"));

        // print all records in phonebook
        System.out.println(phonebook);
    }
}
