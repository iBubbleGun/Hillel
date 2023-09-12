package edu.hillel.homework.lesson12.list_methods;

import java.util.*;

public class ListMethods {

    public int countOccurence(List<String> stringList, String target) {
        return Collections.frequency(stringList, target);
    }

    public <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }

    public List<Integer> findUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbersSet = new HashSet<>(numbers);
        return new ArrayList<>(uniqueNumbersSet);
    }

    public void calcOccurrence(List<String> words) {
        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Map<String, Object>> findOccurrence(List<String> words) {
        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            Map<String, Object> wordInfo = new HashMap<>();
            wordInfo.put("name", "\"" + entry.getKey() + "\"");
            wordInfo.put("occurrence", entry.getValue());
            result.add(wordInfo);
        }
        return result;
    }

    public void delimiter(int homeworkPart) {
        System.out.println("\n".concat("-".repeat(60)).concat(" part ").concat(String.valueOf(homeworkPart)));
    }
}
