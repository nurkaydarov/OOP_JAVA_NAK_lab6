package kz.pvl.nak.java.oop.lab6;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Retirement {

    private String gender;
    private int retirementAge;
    private int yearOfBirth;
    private final int year;
    private int age;
    private String old ;
    private  String temp;

    {
        year = Calendar.getInstance().get(Calendar.YEAR);

    }

    public Retirement( int retirementAge, int yearOfBirth)
    {

        this.retirementAge = retirementAge;
        this.yearOfBirth = yearOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setRetirementAge(int retirementAge){
        this.retirementAge = retirementAge;
    }

    public int getRetirementAge(){
        return this.retirementAge;
    }

    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth(){
        return this.yearOfBirth;
    }

    public int solveRetirement()
    {
        this.age = year - yearOfBirth;
        return retirementAge - this.age;
    }

    public String postFix(int age){
        //ResourceBundle languageDefault = ResourceBundle.getBundle("language");

        int ageLastNumber = age % 10;
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);

        if (ageLastNumber == 1)
        {

            // old = languageDefault.getString("prefix1");

            old = preFix( "prefix1", "prefix1", "prefix1");

        }
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
        {
            //  old = languageDefault.getString("prefix3");
            old = preFix("prefix3", "prefix1", "prefix1");

        }
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
        {
            // old = languageDefault.getString("prefix2");
            old = preFix("prefix2", "prefix1", "prefix1");

        }
        if(isExclusion)
        {
            // old = languageDefault.getString("prefix3");
            old = preFix( "prefix3", "prefix1", "prefix1");

        }

        return age + " " + this.old;

    }

    private String preFix( String lang1, String lang2, String lang3)
    {
        String temp = "";
        ResourceBundle languageDefault = ResourceBundle.getBundle("language");
        if(Locale.getDefault().equals(new Locale("ru", "RU"))){
            temp = languageDefault.getString(lang1);

        }
        else if(Locale.getDefault().equals(new Locale("en", "EN"))){
            temp = languageDefault.getString(lang2);

        }
        else if(Locale.getDefault().equals(new Locale("kk", "KZ"))) {
            temp = languageDefault.getString(lang3);
        }


        return temp;
    }

}
