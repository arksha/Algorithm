//275. H-Index II 
//input is ascending order 
//use binary search O(logn)
public class Solution {
    public int hIndex(int[] citations) {//binary search
    //for paper[m]. there should be at least (len – m) papers with citations >= citations[m]
        int l = 0;
        int h = citations.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(citations[mid]==citations.length-mid){//
                return citations[mid];
            }else if(citations[mid]>citations.length-mid){
                h= mid-1;
            }else{
                l = mid+1;
            }
        }
    return citations.length-l;//
    }
}