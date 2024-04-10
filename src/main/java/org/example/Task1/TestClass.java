package org.example.Task1;

import org.example.Task1.Interface.*;

public class TestClass {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test(priority = 8)
    public void testMethod1() {
        System.out.println("Test Method 1");
    }

    @BeforeTest
    @AfterTest
    @Test(priority = 3)
    public void testMethod2() {
        System.out.println("Test Method 2");
    }

    @Test(priority = 7)
    public void testMethod3() {System.out.println("Test Method 3");}

    @CsvSource("10, Java, 20, true")
    public void testMethod9(int a, String b, int c, boolean d) {
        System.out.println("Сделал невозможное: " + a + " + " + b + " + "  + c + " + "  + d);
    }

    @BeforeTest(redLine = ">>>>>>>>>>>")
    @Test(priority = 1)
    public void testMethod4() {
        System.out.println("Test Method 4");
    }

    @Test()
    public void testMethod5() {
        System.out.println("Test Method 5");
    }

    @AfterTest(redLine = "<<<<<<<<<<")
    @Test(priority = 9)
    public void testMethod6() {
        System.out.println("Test Method 6");
    }

    @Test(priority = 6)
    public void testMethod7() {
        System.out.println("Test Method 7");
    }

    @Test(priority = 2)
    public void testMethod8() {
        System.out.println("Test Method 8");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("After Suite");
    }
}