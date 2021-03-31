package kz.pvl.nak.java.oop.lab6;

import java.util.Calendar;
import java.util.Locale;
import java.io.IOException;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        int gender ; // Пол
        int yearOfBirth ; // Год рождения
        int retirementAge; // Пенсионный возраст
        int languageNumber;
        int currentYear;
        {
            currentYear = Calendar.getInstance().get(Calendar.YEAR);
        }
        String myName, country= "" , language = "" ;
        Scanner input = new Scanner(System.in); // Метод ввода

        Locale.setDefault(Locale.getDefault()); //Установка локализации по умолчанию


        System.out.print("Выберите язык: \n 1: Казахский \n 2: Русский \n 3: Английский \n");
        System.out.print("Выбор: ");
        languageNumber = input.nextInt();
        if (languageNumber == 1)
        {
            language = "kk";
            country = "KZ";

        }
        else if (languageNumber == 2)
        {
            language = "ru";
            country = "RU";
        }
        else if (languageNumber == 3)
        {
            language = "en";
            country = "EN";
        }
        else
        {
            System.out.println("Выбран язык по умолчанию");
            Locale.setDefault(Locale.getDefault());
        }


        Locale.setDefault(new Locale(language, country));
        ResourceBundle languageDefault = ResourceBundle.getBundle("language", new Locale(language, country));

        // System.out.println(Locale.getDefault().equals(new Locale("ru", "RU")));

        System.out.println();
        input.nextLine();

        try
        {
            System.out.print(languageDefault.getString("greeting"));
            myName = input.nextLine(); // Ввод имени

            System.out.print(languageDefault.getString("yearOfBirth"));
            yearOfBirth = input.nextInt(); // Ввод года рождения

            System.out.println(languageDefault.getString("gender")); // Нужно выбрать 1 или 2
            System.out.print(languageDefault.getString("select"));
            gender = input.nextInt();

            if (gender == 1){
                retirementAge = 63;
            }
            else if(gender == 2){
                retirementAge = 61;
            }
            else{
                retirementAge = -1;
            }

            if(yearOfBirth >= 1940 && yearOfBirth < currentYear )
            {
                Retirement aktan = new Retirement(retirementAge, yearOfBirth);
                int aktanRetirement = aktan.solveRetirement();
                System.out.println(myName + languageDefault.getString("result") + " " + aktan.postFix(aktanRetirement));
            }
            else
            {
                System.out.println("Год рождения введен не верно");
            }



        }
        catch (Exception e)
        {
            System.out.println(languageDefault.getString("error"));
        }


    }

   /* public static int regExYear(String inputYearOfBirth){ // Регулярное выражение

        String pattern =  "(?:(?:19|20)[0-9]{2})";
        int yearOfBirth;
        Pattern myPattern = Pattern.compile(pattern);
        Matcher matcher = myPattern.matcher(inputYearOfBirth);
        if(matcher.find())
        {
            yearOfBirth = Integer.parseInt(matcher.group(0));
        }
        else {
            yearOfBirth = 0;
        }

        return yearOfBirth;
    }

    */




}
