//324. Wiggle Sort II.java

//1.separate and choose from 2 groups to form pairs
//O(nlogn) 
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length<2) return;
        int mid =   (nums.length-1)/2;
        int l = mid;
        int r = nums.length-1;
        int[] temp = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i%2==0){
                temp[i] = nums[l];
                l--;
            }else{
                temp[i] = nums[r];
                r--;
            }
            
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}
//2. quick select O(n)

public class Solution {
    public void wiggleSort(int[] nums) {//O(n) time and O(1)extra space for swap
        if(nums==null||nums.length<=1) return;
        int n = nums.length;
        //find median
        int median = findmedian(nums,0,n-1,(n-1)/2);
        //put all small to left , all big to right,do projection
        int[] proj = new int[n]; 
        int l = 0;
        int r = n-1;
        
        for(int i= 0;i<n;i++){
            if(nums[i]<nums[median]){
                proj[l] = nums[i];
                l++;
            }else if(nums[i]>nums[median]){
                proj[r] = nums[i];
                r--;
            }
        }
        //patch median to middle
        for(int i = l;i <= r;i++){ //have to i<=r other wise there is willbe empty in the array
            proj[i] = nums[median];
        }
        //wiggle sort , combine left part and right part to wiggle fashion
        l = (n-1)/2;
        r = n-1;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                nums[i] = proj[l];
                l--;
            }else{
                nums[i] = proj[r];
                r--;
            }
        }
    }
    
    public int findmedian(int[] nums, int l, int h, int k){
        if(l>=h) return l;
        int pivot = partition(nums,l,h);
        if(pivot==k) return pivot;
        
        if(pivot>k) return findmedian(nums,l,pivot-1,k);
        else return findmedian(nums,pivot+1,h,k);
    }
    public int partition(int[] nums, int l, int h){
        int pivot = nums[l];
        int i = l+1;
        int j = h;
        while(i<=j){
            while(i<=j&&nums[i]<pivot) i++;
            while(i<=j&&nums[j]>=pivot) j--;
            if(i<=j) swap(nums,i,j);
        }
        swap(nums,l,j);//should swap again with low and j
        return j;
    }
    public void swap(int nums[],int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}