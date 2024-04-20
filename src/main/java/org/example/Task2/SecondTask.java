package org.example.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondTask {
    public static void runSecondTask() {

        Service service = new Service();

        String organisation = "we are an organization with a lower letter lower than ours only our competitors";

        List<Worker> worker = new ArrayList<>(Arrays.asList(
                new Worker("Bob1", Position.MANAGER.name(), 100, 33, "Greetings, fellow IT enthusiast! Keep coding and creating!"),
                new Worker("Bob2", Position.MANAGER.name(), 120, 25, "Hey there, tech wizard! May your algorithms always be optimized."),
                new Worker("Bob3", Position.MANAGER.name(), 130, 27, "Hello tech genius! Wishing you bug-free days ahead."),
                new Worker("Bob4", Position.ENGINNER.name(), 200, 40, "Hi IT rockstar! Keep disrupting the industry with your innovations."),
                new Worker("Bob5", Position.ENGINNER.name(), 220, 46, "Salutations, coding maestro! Your lines of code are a work of art."),
                new Worker("Bob6", Position.ENGINNER.name(), 230, 34, "Hey tech ninja! May your servers always run smoothly."),
                new Worker("Bob7", Position.ENGINNER.name(), 230, 50, "Greetings, digital architect! Building the future one line at a time."),
                new Worker("Bob8", Position.DIRECTOR.name(), 300, 55, "Hello IT guru! Your knowledge is a beacon in the digital world."),
                new Worker("Bob9", Position.ADMINISTRATOR.name(), 80, 30, "Hey there, software sorcerer! Casting spells with your code."),
                new Worker("Bob10", Position.FINANCIAL_ANALYST.name(), 150, 40, "Greetings, tech maestro! Your skills are the backbone of innovation.")
            )
        );

        List<Organization> organizations = new ArrayList<>(Arrays.asList(
                new Organization(worker, 1),
                new Organization(worker, 2),
                new Organization(worker, 3)
            )
        );

        /* Реализуйте удаление из листа всех дубликатов */
        List<String> deduplicatPosition = service.deduplicate(worker);
        deduplicatPosition.forEach(System.out::println);

        /* Найдите в списке целых чисел 3-е наибольшее число (пример: 5 2 10 9 4 3 10 1 13 => 10) */
        Optional<Double> findThirdLargestNumber = Optional.ofNullable(service.findThirdLargestNumber(worker));
        System.out.println();
        findThirdLargestNumber.ifPresentOrElse(
                salary -> System.out.println("Третья по величине не уникальная зп: " + salary),
                () -> System.out.println("К сожалению не хватает зп на всех работников")
        );

        /* Найдите в списке целых чисел 3-е наибольшее «уникальное» число (пример: 5 2 10 9 4 3 10 1 13 => 9,
            в отличие от прошлой задачи здесь разные 10 считает за одно число) */
        Optional<Double> findThirdLargestUniqueNumber = Optional.ofNullable(service.findThirdLargestUniqueNumber(worker));
        findThirdLargestUniqueNumber.ifPresentOrElse(
                salary -> System.out.println("\n" + "Третья по величине уникальная зп: " + salary),
                () -> System.out.println("\n" + "К сожалению не хватает зп на всех работников")
        );

        /* Имеется список объектов типа Сотрудник (имя, возраст, должность), необходимо получить список
            имен 3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста */
        List<String> threeOldestWorkers = service.getThreeOldestWorkers(worker);
        System.out.println("\n" + "Три самых старших сотрудника:");
        threeOldestWorkers.forEach(System.out::println);

        /* Имеется список объектов типа Сотрудник (имя, возраст, должность), посчитайте
            средний возраст сотрудников с должностью «Инженер» */
        Integer averageAgeOfEngineers = service.getAverageAgeOfEngineers(worker);
        System.out.println("\n" + "Средний возраст сотрудника:" + "\n" + "Без дробей =ь : " + averageAgeOfEngineers);

        /* Найдите в списке слов самое длинное */
        String longestWordInPosition = service.findLongestWordInPosition(worker);
        System.out.println("\n" + "Самая длинная должность:" + "\n" + "Я тоже смущен таким методом... Но эту должность сложно выговорить: " + longestWordInPosition);

        /* Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы,
            в которой будут храниться пары: слово - сколько раз оно встречается во входной строке */
        String mostRepeatedWord = service.buildWordFrequencyMap(organisation);
        System.out.println("\n" + "Повторяющееся слово:" + "\n" + mostRepeatedWord);

        /* Отпечатайте в консоль строки из списка в порядке увеличения длины слова,
            если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок */
        List<String> listOfCrazyWordsWithSort = service.createListOfCrazyWords(worker);
        System.out.println("\n" + "Список безумных слов:");
        listOfCrazyWordsWithSort.forEach(word -> System.out.print(word + " "));

        /* Имеется массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом,
            найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них */
        String longestCrazyWord = service.findLongestWord(worker);
        System.out.println("\n" + "\n" + "Самое длинное безумное слово:" + "\n" + longestCrazyWord);

    }

}


