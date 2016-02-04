293.Flip Game
// You are playing the following Flip Game with your friend: 
// Given a string that contains only these two characters:+ and -, you and your friend take turns to flip two consecutive "++" into "--". 
// The game ends when a person can no longer make a move and therefore the other person will be the winner.

// Write a function to compute all possible states of the string after one valid move.

// For example, given s = "++++", after one move, it may become one of the following states:

// [
//   "--++",
//   "+--+",
//   "++--"
// ]
// If there is no valid move, return an empty list [].

//DFS
public List<String> getFlipResult(String s){
		List<String> res = new ArrayList<>();
		if(s.length()<2) return res;
		dfs(s,res,0);
		return res;
	}
	public void dfs(String s,List<String> res,int p){
		for(int i = p;i<s.length()-1;i++){
			if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
				String temp = s.substring(0, i) + "--"+ s.substring(i+2);
				res.add(temp);
			}else
				dfs(s,res,i+1);
		}
	}