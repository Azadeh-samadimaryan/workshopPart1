package com.workshopPart1;

/**
 * Hello world!
 */
public class App {

    static String[] names = new String[10];
    static NameRepositoryByChatGPT repository = new NameRepositoryByChatGPT();

    public static void main(String[] args) {

        // In this part we have used our implementation
        /*fillNames("Erik Svensson", names);
        fillNames("Mehrdad Javan", names);
        fillNames("Omid Mojabi", names);
        fillNames("Azadeh Samadi", names);*/

        //add("Erik Svensson");
        //add("Mehrdad Javan");
        //add("Erik Svensson");
        //add("Omid Mojabi");
        //add("Azadeh Samadi");

        //System.out.println(find("Omid Mojabi"));
        //System.out.println(find("Erik Svensson"));

        //printNames(names);

        // In this part we have used ChatGPT Implementation
        repository.add("Erik Svensson");
        repository.add("Erik Andersson");
        repository.add("Mehrdad Javan");
        repository.add("Patrik Andersson");
        String[] result1 = repository.findByFirstName("Erik");
        printNames(result1);

        String[] result2 = repository.findByLastName("Andersson");
        printNames(result2);

        String result3 = repository.find("Patrik Andersson");
        System.out.println(result3);

        String[] result4 = repository.getAllNames();
        printNames(result4);

        boolean updateResult = repository.update("Erik Svensson",
                "Rosa Svensson");
        System.out.println(updateResult ? "true": "false");
        printNames(repository.getAllNames());

        boolean removeResult = repository.remove("Patrik Andersson");
        printNames(repository.getAllNames());

    }

    private static void printNames(String[] repoArray) {
        for (int i = 0; i < repoArray.length; i++) {

            if (repoArray[i] != null && repoArray[i] != "") {
                System.out.println(repoArray[i]);
            }

        }
    }

    private static void fillNames(String name, String[] repository) {

        if (repository == null) {
            repository = new String[10];
        } else {
            for (int i = 0; i < repository.length; i++) {

                if (repository[i] == null || repository[i] == "") {
                    repository[i] = name;
                    break;
                }
            }
        }

    }

    public static String find(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == fullName) {
                return names[i] + " found successfully";
            }
        }
        return fullName + " not found";
    }

    private static boolean add(final String fullName) {

        for (int i = 0; i < names.length; i++) {
            if (names[i] == fullName) {
                System.out.println(fullName + " is duplicated");
                return false;
            }
        }

        for (int i = 0; i < names.length; i++) {

            if (names[i] == null || names[i] == "") {
                names[i] = fullName;
                System.out.println(fullName + " added successfully");
                return true;
            }
        }

        return false;
    }
}




