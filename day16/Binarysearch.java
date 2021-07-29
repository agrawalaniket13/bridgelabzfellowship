package com.day16;

import java.util.*;

public class Binarysearch {
    public static void main(String[] args)
    {
        // Create a list
        List<Domain> l = new ArrayList<Domain>();
        l.add(new Domain(10, "ani"));
        l.add(new Domain(20, "agr"));

        Comparator<Domain> c = new Comparator<Domain>() {
            public int compare(Domain u1, Domain u2)
            {
                return u1.getId().compareTo(u2.getId());
            }
        };

        // Searching a domain with key value 10. To search
        // we create an object of domain with key 10.
        int index = Collections.binarySearch(
                l, new Domain(10,"ani"), c);
        System.out.println("Found at index  " + index);
    }
}

// A user-defined class to store domains with id and url
class Domain {
    private int id;
    private String url;

    // Constructor
    public Domain(int id, String url)
    {
        this.id = id;
        this.url = url;
    }

    public Integer getId() { return Integer.valueOf(id); }
}
