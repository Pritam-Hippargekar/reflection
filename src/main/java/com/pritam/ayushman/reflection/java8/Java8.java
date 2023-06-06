package com.pritam.ayushman.reflection.java8;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Java8 {

    public static void main(String[] args) {
      System.out.println(new Java8().returnValue());
    }

    public Boolean returnValue(){
        try{
            System.exit(0);
        }catch (Exception ex){
            System.exit(0);
        } finally {
          return true;
        }
    }

//https://www.linkedin.com/pulse/asynchronous-programming-java-completablefuture-aliaksandr-liakh/
//    Types
//    There are 4 types of primary/compute calls supported.
//            Supply: Used to supply value. No input, provides output.
//            Apply: Used to apply a function on an input. Takes input, provides output.
//            Accept: Used to accept a value and run a function using the same. Takes input, doesn’t provide output.
//            Run: Used to run a function. No input, no output.


//    public static void main(String[] args) {

//        String name = "Sagar";
//        new Java8().callByValue(name);
//        System.out.println(name);
//
//       Map<String,String> map = new HashMap<>();
//       map.put("1","One");
//       map.put("2","Two");
//       System.out.println(map);
//       new Java8().callByReference(map);
//       System.out.println(map);

//        List<String> list = new ArrayList<>();
//        list.add("One");
//        list.add("Two");
//       System.out.println(list.size()+" "+list);
//       new Java8().callByReference(list);
//       System.out.println(list.size()+" "+list);

//        Parent parent = new Parent();
//        parent.display();
//          parent.data(null);

//        Parent child = new Child();
//        child.display();
//        child.show();
//    }


    public void callByReference(Map<String,String> map){
        map.put("3","Three");
    }

    public void callByReference(List<String> list){
        list.add(0,"Three");
    }

    public void callByValue(String value){
        value = value.concat("Ravan");
        System.out.println("callByValue " + value);
    }

//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        //manually complete the Future with the given value
//        boolean result = completableFuture.complete("Future result value");
//
//        //when we need a result back, then use supplyAsync.
//        //we don’t need any result back, then use runAsync.
//        Runnable runnableTask = () -> {
//            System.out.println("Async Task Thread: "+ Thread.currentThread().getName());
//            System.out.println("Runnable EXECUTED!");
//        };
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnableTask);
//        System.out.println("Main Task Thread: "+ Thread.currentThread().getName());
//        completableFuture.join();


//        thenRun and thenRunAsync
//        These methods accept a Runnable as a callback, so it doesn’t either consume a result nor produce any element.

//        thenAccept and thenAcceptAsync
//        These methods accept a Consumer as a callback, so it accepts a result from the CompletableFuture, but it doesn’t produce any result.

//        thenApply and thenApplyAsync
//        These methods accept a Function as a callback, which accept a result from the CompletableFuture and transforms the result using this function.


//        thenCompose and thenComposeAsync
//        To be used when a CompletableFuture depends on the completion of a previous CompletableFuture to start.

//        thenCombine and thenCombineAsync
//        To be used when we need to run two CompletableFutures at the same time and we produce a result when both CompletableFutures complete.

//        thenAcceptBoth and thenAcceptBothAsync
//        To be used when we run two CompletableFutures at the same time but in this case we just consume the outcome of these two CompletableFutures, not producing any result.

//        acceptEither and acceptEitherAsync
//        In this case we run two CompletableFutures at the same time but we just care about the first one to complete.



//       A) Catch exceptions and recover using exceptionally method
//        .exceptionally(ex -> {
//            log.error("Received exception {}, returning empty list.", ex.getMessage());
//            return Set.of();
//        });

//      B)  Catch exceptions and recover using the handle method
//        .handle((response, ex) -> {
//            log.info("Executing exception handler for purchase transaction CF...");
//            if (ex != null) {
//                log.error("Received exception {}, returning empty list.", ex.getMessage());
//                return Collections.EMPTY_SET;
//            }
//            return response;
//        });

//      C)  Catch exceptions and don't recover
//        .whenComplete((response, ex) -> {
//            log.info("Executing whenComplete for purchase transaction CF...");
//            if (ex != null) {
//                log.error("Received exception {}, throwing exception to consumer", ex.getMessage());
//            }
//        });

//       D) Rethrow different types of an exception
//        .exceptionally(ex -> {
//            log.error("Received exception {}, throwing new exception!", ex.getMessage());
//            throw new IllegalArgumentException();
//        });

//        E)  .completeOnTimeout(Set.of(), timeOut, TimeUnit.SECONDS);


//    get and join should be used with extra caution. These can block the current thread waiting for the CF to complete.
//    join() - Returns the result value when complete, or throws an (unchecked) exception if completed exceptionally.
    public Future<String> getResultOverNetwork2() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            delay(5000l); //simulate network call
            future.complete("{\"result\":\"success\"}");
        }).start();
        return future;
    }

    public Future<String> getResultOverNetwork1() {
        return CompletableFuture.supplyAsync(() -> {
            delay(5000l);
            return "{\"result\":\"success\"}";
        });
    }

//    ExecutorService executor = Executors.newSingleThreadExecutor();
//    Future<String> firstApiCallResult = executor.submit(() -> firstApiCall(someValue));
//    String stringResult = firstApiCallResult.get();
//    Future<String> secondApiCallResult = executor.submit(() -> secondApiCall(stringResult) );
//    == SAME ==
//var finalResult = CompletableFuture.supplyAsync(() -> firstApiCall(someValue))
//        .thenApply(firstApiResult -> secondApiCall(firstApiResult));

    public void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void dataMap(){
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


    public void dataList(){
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
