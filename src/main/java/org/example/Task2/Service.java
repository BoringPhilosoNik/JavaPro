package org.example.Task2;

import java.util.*;
import java.util.stream.Collectors;


public class Service {
    List<String> deduplicate(List<Worker> workers) {
        return workers.stream()
                .map(Worker::getPosition)
                .distinct()
                .toList();
    }

    Double findThirdLargestNumber(List<Worker> workers) {
        return workers.stream()
                .map(Worker::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(null);
    }

    Double findThirdLargestUniqueNumber(List<Worker> workers) {
        return workers.stream()
                .map(Worker::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(null);
    }

    List<String> getThreeOldestWorkers(List<Worker> workers) {
        return workers.stream()
                .filter(e -> e.getPosition().equals("ENGINNER"))
                .sorted(Comparator.comparingInt(Worker::getAge).reversed())
                .limit(3)
                .map(Worker::getName)
                .toList();
    }

    Integer getAverageAgeOfEngineers(List<Worker> workers) {
        return (int) workers.stream()
                .filter(e -> e.getPosition().equals("ENGINNER"))
                .mapToInt(Worker::getAge)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Не найдены данные"));
    }

    String findLongestWordInPosition(List<Worker> workers) {
        return workers.stream()
                .map(Worker::getPosition)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    String buildWordFrequencyMap(String phrase) {
        Map<String, Integer> map = Arrays.stream(phrase.split(" "))
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    List<String> createListOfCrazyWords(List<Worker> workers) {
        List<String> randomCrazyWord = workers.stream()
                .map(Worker::getCrazyIntroduce)
                .limit(2) // достаточный список
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();

        return randomCrazyWord; //нравится название
    }

    String findLongestWord(List<Worker> workers) {
        return workers.stream()
                .map(Worker::getCrazyIntroduce)
                .limit(5) // достаточный список
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .max(Comparator.comparingInt(String::length))
                .orElse("Ваши строки пусты, как и ваша душа...");
    }
}
