package com.pritam.ayushman.reflection.java8;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;

public class Java8 {

    public static void main(String[] args) {
        Map<Integer, String> mapData = new HashMap<>();
        mapData.put(14,"AA");
        mapData.put(41,"BB");
        mapData.put(11,"CC");
        mapData.put(18,"DD");
        mapData.put(91,"EE");
        String value = mapData.getOrDefault(55,"0");
        System.out.println(value+" "+mapData.size()+" "+mapData);
        // if key present , do not override previous value & return previous value
        // if key not present then add new entry in map with key value.
//        String shirt = mapData.computeIfAbsent(91, key -> "Shirt");
//        System.out.println(shirt+" "+mapData.size()+" "+mapData);

        // if key present, then we can update value.
        // if key not present, then it will return null value & will not create new entry in map
//        String shirt = mapData.computeIfPresent(91, (key, value1) -> key + "No");
//        System.out.println(shirt+" "+mapData.size()+" "+mapData);

        // key already not present in HashMap
        mapData.putIfAbsent(2, "JavaScript");
        System.out.println("Updated Languages: " + mapData);
        // key already present in HashMap
//        mapData.putIfAbsent(11, "Swift");
//        System.out.println("Updated Languages: " + mapData);
    }


    public void data(){
        List<Integer> data = new ArrayList<>();
        data.add(41);
        data.add(4);
        data.add(1);
        data.add(2);
        data.add(21);
        data.add(11);
        System.out.println(data+" "+data.size());
        data.removeIf(item->item.equals(11));
        System.out.println(data+" "+data.size());
        data.set(2,250); // replace/override
        data.add(2,90); // add new element.
    }
}
