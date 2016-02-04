//274. H-Index
// 3 0 6 1 5 original
// 0 1 2 3 4 index
// 6 5 3 1 0 sorted descendent
//if index> citation num i, then return i-1 ,is h index
//can sort ascendent by sort(), then iterate array from end
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for(int i = citations.length-1;i>=0;i--){
            if(citations[i]<=res)
                return res;    
            res++;
        }
        return res;
    }
}

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