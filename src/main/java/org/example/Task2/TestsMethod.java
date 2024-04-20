package org.example.Task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestsMethod {
    /*
    Нужно написать коллектор, который создаст Map с ключем - ID организации,
    а в качестве значения - сама организация
    */

    Map<Integer, Organization> integerOrganizationMap(List<Organization> organizations) {
        return organizations.stream()
                .collect(
                        Collectors.toMap(Organization::getId, org -> org)
                );
    }

    /*
    Нужно написать коллектор, который создаст Map. Где ключом будет должность,
    а в качестве значения будет список рабочих, которые занимают эту должность.
    */

    Map<String, List<Worker>> groupWorkersByPosition(List<Worker> workers) {
        return workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition)
                );
    }

    /*
    Нужно написать коллектор, который создаст Map. Где ключом будет должность, а в качестве значения
    будет количество рабочих, которые занимают эту должность.
    */

    Map<String, Long> getCountForPositions(List<Worker> workers) {
        return workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition, Collectors.counting())
                );
    }

    /*
    Нужно написать коллектор, который создаст Map, где ключом будет должность,
    а в качестве значения будет средняя зарплата для этой должности.
    */

    Map<String, Double> getAvgSalaryPerPosition(List<Worker> workers) {
        return workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition, Collectors.averagingDouble(Worker::getSalary))
                );
    }
}
