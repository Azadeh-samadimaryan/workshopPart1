package com.workshopPart1;

/**
 * Hello world!
 */
public class App {

    static String[] names = new String[10];
    
    public static void main(String[] args) {

        fillNames("Erik Svensson",names);
        fillNames("Mehrdad Javan",names);
        fillNames("Omid Mojabi",names);
        fillNames("Azadeh Samadi",names);

        printNames(names);
        
    }

    private static void printNames(String[] repoArray)
    {
        for (int i=0; i< repoArray.length; i++){

            if (repoArray[i] != null && repoArray[i] != "") {
                System.out.println(repoArray[i]);
            }

        }
    }

    private static void fillNames(String name,String[] repository) {

        if (repository == null){
            repository = new String[10];
        }
        else{
            for (int i=0; i< repository.length; i++){

                if (repository[i] == null || repository[i] ==""){
                    repository[i] = name;
                    break;
                }
            }
        }

    }


}




