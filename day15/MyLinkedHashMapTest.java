package com.day9;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapTest {
    @Test
    public void givenASentenceWhenWordsAreAddedToListShouldReturnParanoidFrequency(){
        String sentence = "Paranoid are not paranoid because they are paranoid but "+
                          "because they keep putting themselves deliberately into "+
                          "paranoid avoidable situations";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split( regex:" ");
        for (String word : words){
            Integer value = myLinkedHashMap.get(word);
            if (value == null) value = 1;
            else value = value+1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println(myLinkedHashMap);
        int frequency = myLinkedHashMap.get("paranoid");
        Assert.assertEquals(expected: 3, frequency);
    }
}
