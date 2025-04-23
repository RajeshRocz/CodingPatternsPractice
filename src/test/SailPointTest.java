package test;


/*
---- Multithreading ----
1. Task: Create a Java program that spawns three threads. Each thread should increment a shared counter 1000 times.
   Use synchronization to ensure thread safety.
2. Task: Implement a Java program using ExecutorService to execute tasks that calculate the factorial of numbers from 1 to 5.
   Use Callable and Future to retrieve results.
3. Task: Implement a program that uses ConcurrentHashMap to store and update the frequency of words in a list of strings concurrently.
   Use advanced operations like compute and merge.
4. Task: Implement a Java program using ExecutorService and CompletionService to execute a set of tasks that simulate network requests.
   Each task should return a response time, and the program should process the results as they become available.

---- Streams ----
5. Task: Write a program that uses the Stream API to process a list of integers. Filter out odd numbers, square the remaining numbers,
   and then find the sum of these squares.
6. Task: Implement a program that uses parallel streams to process a large list of integers, calculating their factorial and collecting
   the results using a custom collector.
7. Task: Implement a Java program that processes a list of transactions. Each transaction has an ID, amount, and type (e.g., "credit" or "debit").
   Use a custom collector to group transactions by type and calculate the total amount for each type.
8. Task: Write a program that processes a list of users, where each user has a list of orders. Each order may or may not have a discount.
   Use flatMap to extract all discounts and calculate the average discount using Optional.
*/
import java.util.List;
import java.util.Arrays;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.*;

public class SailPointTest {
    public static void main(String[] args) {

        List<String> names=List.of("Ricardo", "Jhon", "Fernando", "Ricardo", "Alberto", "Jhon");

        //Ricardo-2, Jhon-2, Fernando-1, Alberto-1


        Map<String, Long> frequency=names.parallelStream()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));


        System.out.println("Frequency map:"+frequency);

    }


}
