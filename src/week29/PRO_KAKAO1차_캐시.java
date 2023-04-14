package week29;

public class PRO_KAKAO1차_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }

        String[] redis = new String[cacheSize];

        int[] used = new int[cacheSize];

        int recentlySize = 0;
        int index = 0;

        while(index <  cities.length){
            String city = cities[index].toUpperCase();
            // 캐시에 있는지 확인 - cacheHit = 1
            if(cacheHit(redis, used, city, recentlySize)){
                answer += 1;    // 캐시 히트
            }else{  // 히트 실패
                if(recentlySize < cacheSize){ // 캐시 자리 남음.
                    redis[recentlySize] = city;
                    used[recentlySize++] = 0;

                }else{  //캐시 꽉참
                    //제일 고참이 누고?
                    int max = 0;
                    int maxIndex = 0;
                    for(int i=0; i<cacheSize; i++){
                        if(used[i] > max){
                            max = used[i];
                            maxIndex = i;
                        }
                    }
                    redis[maxIndex] = city; // 페이지 교체
                    used[maxIndex] = 0;
                }
                answer += 5;
            }
            for(int i=0; i<recentlySize; i++){
                used[i]++;
            }
            index++;
        }
        return answer;
    }
    public boolean cacheHit(String[] redis, int[] used, String city, int recentlySize){
        // 캐시 히트인지 확인
        for(int i=0; i<recentlySize; i++){
            if(redis[i].equals(city)){
                used[i] = 0;
                return true;
            }
        }
        return false;
    }
}
