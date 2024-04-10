package org.example;

import org.example.Task1.Exception.IllegalAnnotationException;
import org.example.Task1.Exception.OverHeadCount;
import org.example.Task1.TestClass;

import java.lang.reflect.InvocationTargetException;

import static org.example.Task1.TestRunner.runTests;

public class Main {
    public static void main(String[] args) throws OverHeadCount, IllegalAnnotationException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        runTests(TestClass.class);
    }
}