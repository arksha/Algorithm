332. Reconstruct Itinerary.java

//dfs with Eurlarian path on directied graph
//HashMap<String,PriorityQueue<String>>, LinkedList, 

//First keep going forward until you get stuck. Put the stuck element always at the front of the result list. 
//Try if it is possible to travel to other places from the airport on the way.

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();//use linkedlist to add first
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        if(tickets.length==0||tickets==null) return res;
        
        for(String[] ticket: tickets){
            if(!graph.containsKey(ticket[0])) graph.put(ticket[0],new PriorityQueue<String>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        dfs(res,graph,tickets,"JFK");
        return res;
    }
    public void dfs( LinkedList<String> res,HashMap<String, PriorityQueue<String>> graph,String[][] tickets,String cur){
        while(graph.containsKey(cur)&&!graph.get(cur).isEmpty()){
            dfs(res,graph,tickets,graph.get(cur).poll());
        }
        res.addFirst(cur);//always add to first of res, thus we can use stack instead too
    }
}

//another version with stack to implement dfs without recursion

public class Solution {
    public List<String> findItinerary(String[][] tickets) {//another version using stack
        List<String> res  = new ArrayList<>();
        if(tickets.length==0||tickets==null) return res;
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> st = new Stack<>();
        
        for(String[] ticket: tickets){
            if(!graph.containsKey(ticket[0])) graph.put(ticket[0],new PriorityQueue<String>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        String cur = "JFK";
        for(int i = 0;i<tickets.length;i++){
            while(!graph.containsKey(cur)||graph.get(cur).isEmpty()){
                st.push(cur);
                cur = res.remove(res.size()-1);//push to stack and remove last one from res list
            }
            res.add(cur);
            cur = graph.get(cur).poll();
        }
        res.add(cur);
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }
}