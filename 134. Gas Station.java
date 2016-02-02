//134. Gas Station
// typical greedy
//Analize: contains 2 problem: 
//1.can round a circle? 2. if can, where is the start poiont?
//for 1. add up remaingas
//for 2. get total to for a certain interval,if total is >0,then start point cannot in this interval
//
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;//total gas along the road
	    int remain = 0; //remain gas for now
        int start = 0;// start point
	    for(int i =0 ; i<gas.length;i++){
            int remaingas = gas[i]- cost[i];//extra gas to add
            if(remain<0)// have no gas, cannot reach next station
            {
                remain = remaingas;//current remain to load up
                start = i;// change a new start point
            }else{
              remain += remaingas;//still have gas when reach this gas station
            }
            total += remaingas;//
        }
        return total<0? -1: start;// total gas 
    }
}

