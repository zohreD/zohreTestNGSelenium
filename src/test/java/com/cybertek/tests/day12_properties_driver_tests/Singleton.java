package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    private static String str;

    private Singleton(){}

    public static String getInstance(){
        if(str == null){
            System.out.println("assigning some value");
            str = "SOME VALUE";
        }else{
            System.out.println("it has a value so return assigned value");
        }
        return str;
    }

}
