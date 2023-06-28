package week43;
import java.util.HashMap;
public class PRO_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> memory = setMemory(name, yearning);

        int index = 0;
        for(String[] persons : photo){
            for(String person : persons){
                if(memory.get(person) != null){
                    answer[index] += memory.get(person);
                }
            }
            index++;
        }
        return answer;
    }
    public HashMap<String, Integer> setMemory(String[] name, int[] yearning){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        return map;
    }
}
