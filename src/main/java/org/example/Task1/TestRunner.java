package org.example.Task1;

import org.example.Task1.Exception.IllegalAnnotationException;
import org.example.Task1.Exception.OverHeadCount;
import org.example.Task1.Interface.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void runTests(Class<TestClass> testClass) throws OverHeadCount, IllegalAnnotationException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Constructor<TestClass> constructor = testClass.getConstructor();
        TestClass instance = constructor.newInstance();
        Method[] getDeclaredMethods = testClass.getDeclaredMethods();
        int countBefore = 0;
        Method beforeSuite = null;
        int countAfter = 0;
        Method afterSuite = null;
        Method csvSource = null;

        for (Method getDeclaredMethod : getDeclaredMethods) {
            if (getDeclaredMethod.isAnnotationPresent(BeforeSuite.class)) {
                if (!java.lang.reflect.Modifier.isStatic(getDeclaredMethod.getModifiers())) {
                    throw new IllegalAnnotationException("Method annotated with BeforeSuite must be static");
                }
                countBefore++;
                if (countBefore > 1) throw new OverHeadCount("Количество методов с аннотацией BeforeSuite превышено");
                beforeSuite = getDeclaredMethod;
            }
            if (getDeclaredMethod.isAnnotationPresent(AfterSuite.class)) {
                if (!java.lang.reflect.Modifier.isStatic(getDeclaredMethod.getModifiers())) {
                    throw new IllegalAnnotationException("Method annotated with AfterSuite must be static");
                }
                countAfter++;
                if (countAfter > 1) throw new OverHeadCount("Количество методов с аннотацией AfterSuite превышено");
                afterSuite = getDeclaredMethod;
            }
            if (getDeclaredMethod.isAnnotationPresent(Test.class)) {
                if (java.lang.reflect.Modifier.isStatic(getDeclaredMethod.getModifiers())) {
                    throw new IllegalAnnotationException("Method annotated with @Test cant be static");
                }
                if (getDeclaredMethod.isAnnotationPresent(CsvSource.class)) {
                    throw new IllegalAnnotationException("К сожалению мы так не умеем ахах");
                }
            }
            if (getDeclaredMethod.isAnnotationPresent(CsvSource.class)) {
                if (java.lang.reflect.Modifier.isStatic(getDeclaredMethod.getModifiers())) {
                    throw new IllegalAnnotationException("Method annotated with @Test cant be static");
                }
                if (getDeclaredMethod.isAnnotationPresent(Test.class)) {
                    throw new IllegalAnnotationException("К сожалению мы так не умеем ахах");
                }
                csvSource = getDeclaredMethod;
            }
        }

        if (beforeSuite != null) {
            if (beforeSuite.isAnnotationPresent(BeforeTest.class)) {
                System.out.println(beforeSuite.getAnnotation(BeforeTest.class).redLine());
            }
            beforeSuite.invoke(null);
            if (beforeSuite.isAnnotationPresent(AfterTest.class)) {
                System.out.println(beforeSuite.getAnnotation(AfterTest.class).redLine());
            }
        }

        List<Method> testMethods = Arrays.stream(getDeclaredMethods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()))
                .toList();

        for (Method testMethod : testMethods) {
            if (testMethod.isAnnotationPresent(BeforeTest.class)) {
                System.out.println(testMethod.getAnnotation(BeforeTest.class).redLine());
            }
            testMethod.invoke(instance);
            if (testMethod.isAnnotationPresent(AfterTest.class)) {
                System.out.println(testMethod.getAnnotation(AfterTest.class).redLine());
            }
        }

        if (afterSuite != null) {
            if (afterSuite.isAnnotationPresent(BeforeTest.class)) {
                System.out.println(beforeSuite.getAnnotation(BeforeTest.class).redLine());
            }
            afterSuite.invoke(null);
            if (afterSuite.isAnnotationPresent(AfterTest.class)) {
                System.out.println(afterSuite.getAnnotation(AfterTest.class).redLine());
            }

        }

        if (csvSource != null) {
            String[] values = csvSource.getAnnotation(CsvSource.class).value().split(",\\s*");
            int parseIntFirstArg = Integer.parseInt(values[0]);
            int parseIntSecondArg = Integer.parseInt(values[2]);
            boolean parseBoolean = Boolean.parseBoolean(values[3]);
            instance.testMethod9(parseIntFirstArg, values[1], parseIntSecondArg, parseBoolean);
        }
    }
}