package com.day16;

public class StaticPermutationOfString {
    // Recursive function to generate all permutations of a string
    private static void permutations(String finn, String search)
    {
        if (search.length() == 0) {
            System.out.println(finn);
        }

        for (int i = 0; i < search.length(); i++)
        {
            String newCandidate = finn + search.charAt(i);

            String newRemaining = search.substring(0, i) +
                    search.substring(i + 1);

            permutations(newCandidate, newRemaining);
        }
    }

    // Find Permutations of a string in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations("", s);
    }
}
