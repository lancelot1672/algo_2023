package week28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 길이가 같을 시 사전 순으로 배치
 * word1.compareTo(word2) 사용!!
 */
public class B20920_영단어암기는괴로워 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> dict = new HashMap<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();

            int len = word.length();
            if(len < M) continue;

            if(dict.containsKey(word)){
                Integer count = dict.get(word);
                dict.put(word, ++count);
            }else{  //키가 없으면
                dict.put(word, 1);
            }
        }
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(String key : dict.keySet()){
            Word word = new Word(key, key.length(),dict.get(key));

            pq.add(word);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().word + "\n");
        }
        System.out.println(sb.toString());
    }
    static class Word implements Comparable<Word>{
        String word;
        int len;
        int count;

        public Word(String word, int len, int count) {
            this.word = word;
            this.len = len;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if(o.count > this.count){
                return 1;
            }else if(o.count < this.count){
                return -1;
            }else{
                if(o.len > this.len){
                    return 1;
                }else if(o.len < this.len){
                    return -1;
                }else{
                    return this.word.compareTo(o.word);
                }
            }
        }
    }
}
