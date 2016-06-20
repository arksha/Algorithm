// 170. Two Sum III - Data structure design [locked]

// Design and implement a TwoSum class. It should support the following operations:add and find.
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
// ---------------------------------------------------------------------------------------------------------------------

// about duplicate? use the second method
// Hash Map operation: put O(N) , get O(1)

// ------------------------------------------------------------------------------------------------------------------------
// Use arrayList and HashMap, use array to store all the number

	public class TwoSum {
    private List<Integer> array;
    public TwoSum(){
        this.array = new ArrayList<Integer>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    array.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashMap<Integer,Integer> map = new HashMap<>();
	    for(int i = 0;i<array.size();i++){
	        if(!map.containsKey(array.get(i)))
	            map.put(value-array.get(i),array.get(i));
	        else
	            return true;
	    }
	    return false;
	}
	}

// ------------------------------------------------------------------------------------------------------------------------
// key: number 
// value: frequency
// go through HashMap and find remain if in map, or if the remain is in map and more than 1 exist( like 1,1 equals target 2)
public class TwoSum { 
	HashMap<Integer,Integer> map = new HashMap<>();
	public void add(int number){
		if(map.containsKey(number))
			map.put(number,map.get(number)+1);
		else
			map.put(number, 1);

	}
	public boolean find(int number){
		for(int key: map.keyset()){
			int remain = number - key;
			if(remain==key && map.containsKey(key)>1) return true;
			else if(remain!=key &&map.comtains(remain)) return true;

		}
		return false;
	}
}

	// Your TwoSum object will be instantiated and called as such:
	// TwoSum twoSum = new TwoSum();
	// twoSum.add(number);
	// twoSum.find(value);
