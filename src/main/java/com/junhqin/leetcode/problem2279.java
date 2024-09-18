package com.junhqin.leetcode;

import java.util.Arrays;

public class problem2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++){
            rocks[i] = capacity[i]-rocks[i];
        }

        Arrays.sort(rocks);
        int count = 0;
        for(int i=0;i<rocks.length;i++){
            if(rocks[i] > 0 && additionalRocks >= rocks[i]){
                additionalRocks -= rocks[i];
                rocks[i] =0;
            }
            if (rocks[i] == 0){
                count++;
            }
        }
        return count;
    }
}
