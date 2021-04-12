public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int len = accounts.size();
    int[] parents = new int[len];
    for(int i = 0; i < len; i++){
        parents[i] = i;
    }
    Map<String, Integer> emails = new HashMap<>();
    for(int i = 0; i < len; i++){
        for(int j = 1; j <accounts.get(i).size(); j++){
            String email = accounts.get(i).get(j);
            if(!emails.containsKey(email)){
                emails.put(email, i);
            }
            else{
                int pre = emails.get(email);
                int parent1 = find(parents, pre);
                int parent2 = find(parents, i);
                parents[parent1] = parent2;
            }
        }
    }
    
    Map<Integer, TreeSet<String>> users = new HashMap<>();
    for(int i = 0; i<len; i++){
        int parent = find(parents, i);
        if(!users.containsKey(parent))
            users.put(parent, new TreeSet<String>());
        List<String> temp = accounts.get(i);
        users.get(parent).addAll(temp.subList(1, temp.size()));
    }
    
    List<List<String>> res = new ArrayList<>();
    for(int index: users.keySet()){
        String user = accounts.get(index).get(0);
        List<String> temp = new ArrayList<String>();
        temp.add(user);
        temp.addAll(new ArrayList<String>(users.get(index)));
        res.add(temp);
    }
    return res;
    
}

public int find(int[] parents, int node){
    if(node == parents[node])
        return node;
    parents[node] = find(parents, parents[node]);
    return parents[node];
}
