package com.workshopPart1;

import java.util.Arrays;

public class NameRepositoryByChatGPT {

    public String[] names = new String[100]; // Maximum capacity of 100 names
    private int size = 0; // Current number of names in the array


    // Helper method to split the full name into first name and last name
    private String[] splitFullName(String fullName) {
        return fullName.split(" ");
    }


    // Helper method to format the first name and last name into "[first name] [last name]"
    private String formatName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }


    // Method to add a new name to the array
    public boolean add(String fullName) {
        String[] nameParts = splitFullName(fullName);
        if (nameParts.length != 2) {
            return false; // Invalid format, must have both first and last name
        }


        if (size == names.length) {
            return false; // Array is full, cannot add more names
        }


        names[size] = formatName(nameParts[0], nameParts[1]);
        size++;
        return true;
    }


    // Method to find a name in the array
    public String find(String fullName) {
        for (int i = 0; i < size; i++) {
            if (names[i].equals(fullName)) {
                return names[i];
            }
        }
        return null;
    }


    // Method to update a name in the array
    public boolean update(String original, String updatedName) {
        String[] updatedNameParts = splitFullName(updatedName);
        if (updatedNameParts.length != 2) {
            return false; // Invalid format, must have both first and last name
        }


        for (int i = 0; i < size; i++) {
            if (names[i].equals(original)) {
                // Check if the updated name already exists in the array
                for (int j = 0; j < size; j++) {
                    if (j != i && names[j].equals(updatedName)) {
                        return false; // Updated name already exists
                    }
                }


                // Update the name
                names[i] = formatName(updatedNameParts[0], updatedNameParts[1]);
                return true;
            }
        }
        return false; // Original name not found
    }


    // Method to get all names in the array that have the specified first name
    public String[] findByFirstName(final String firstName) {
        String[] matches = new String[size];
        int matchIndex = 0;


        for (int i = 0; i < size; i++) {
            String[] nameParts = splitFullName(names[i]);
            if (nameParts[0].equals(firstName)) {
                matches[matchIndex] = names[i];
                matchIndex++;
            }
        }


        return Arrays.copyOf(matches, matchIndex);
    }


    // Method to get all names in the array that have the specified last name
    public String[] findByLastName(final String lastName) {
        String[] matches = new String[size];
        int matchIndex = 0;


        for (int i = 0; i < size; i++) {
            String[] nameParts = splitFullName(names[i]);
            if (nameParts[1].equals(lastName)) {
                matches[matchIndex] = names[i];
                matchIndex++;
            }
        }


        return Arrays.copyOf(matches, matchIndex);
    }


    // Method to remove a name from the array
    public boolean remove(final String fullName) {
        for (int i = 0; i < size; i++) {
            if (names[i].equals(fullName)) {
                // Move all elements after the one to remove one position left
                for (int j = i; j < size - 1; j++) {
                    names[j] = names[j + 1];
                }
                names[size - 1] = null; // Clear the last element
                size--;
                return true; // Name removed successfully
            }
        }
        return false; // Name not found
    }


    // Method to get all names in the array
    public String[] getAllNames() {
        return Arrays.copyOf(names, size);
    }
}
