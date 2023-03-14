package com.pritam.ayushman.reflection.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> arrays  = Arrays.asList("a","a","b","c","d");
//        Map<String, Long> data = arrays.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<String> lisData = arrays.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
       //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect2 = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() <= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect2); //output : {1=linode.com, 2=heroku.com, 3=digitalocean.com}
    }
}
