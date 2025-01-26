package Heap;

import java.util.*;

public class KMostFrequentStrings {
    public static void main(String[] args) {
        String[] input=new String[]{"go","coding","byte","byte","go","interview","go"};

        System.out.println("getKMostFrequentStringsUsingMaxHeap Result:"+getKMostFrequentStringsUsingMaxHeap(input, 2));
        System.out.println("getKMostFrequentStringsUsingMinHeap Result:"+getKMostFrequentStringsUsingMinHeap(input, 2));

    }

    private static List<String> getKMostFrequentStringsUsingMaxHeap(String[] input,int k){
        Map<String, Integer> frequency=new HashMap<>();
        for(String i:input){
            frequency.put(i,frequency.getOrDefault(i,0)+1);
        }

        PriorityQueue<Pair<String, Integer>> maxHeap=new PriorityQueue<>((a,b)->{
            int valueComparision= b.freq.compareTo(a.freq);
            if(valueComparision==0){
                return a.str.compareTo(b.str);
            }
            return valueComparision;
        });

        for(Map.Entry<String, Integer> m: frequency.entrySet()){
            maxHeap.add(new Pair<>(m.getKey(),m.getValue()));
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(Objects.requireNonNull(maxHeap.poll()).str);
        }

        return result;

    }

    private static List<String> getKMostFrequentStringsUsingMinHeap(String[] input,int k){
        Map<String, Integer> frequency=new HashMap<>();
        for(String i:input){
            frequency.put(i,frequency.getOrDefault(i,0)+1);
        }

        PriorityQueue<Pair<String, Integer>> minHeap=new PriorityQueue<>((a,b)->{
            int valueComparision= a.freq.compareTo(b.freq);
            if(valueComparision==0){
                return a.str.compareTo(b.str);
            }
            return valueComparision;
        });

        for(Map.Entry<String, Integer> m: frequency.entrySet()){
            minHeap.add(new Pair<>(m.getKey(),m.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<String> result=new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(Objects.requireNonNull(minHeap.poll()).str);
        }
        //Collections.reverse(result);

        return result.reversed();

    }
}

class Pair<K ,V >{
    K str;
    V freq;

    public Pair(K str, V freq) {
        this.str = str;
        this.freq = freq;
    }

    public K getStr() {
        return str;
    }

    public void setStr(K str) {
        this.str = str;
    }

    public V getFreq() {
        return freq;
    }

    public void setFreq(V freq) {
        this.freq = freq;
    }
}
