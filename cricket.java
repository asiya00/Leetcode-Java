import java.util.*;

class TreemapHandson {
    
    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
      TreeMap<Integer, String> dataset = new TreeMap<>();
      String[] data = cricketDataset.split("\\|");
      for (String i: data){
        String[] d = i.split(",");
        dataset.put(Integer.parseInt(d[0]), d[1]);
      }
      return dataset;
    }
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {
      TreeMap<String, Integer> dataset = new TreeMap<>();
      String[] data = cricketDataset.split("\\|");
      for (String i: data){
        String[] d = i.split(",");
        dataset.put(d[1], Integer.parseInt(d[2]));
      } 
        
      return dataset;
    }
    public TreeMap<String,ArrayList<Integer>> createMatchesMap(String cricketDataset)
    {
        TreeMap<String, ArrayList<Integer>> ans = new TreeMap<>();
        String[] data = cricketDataset.split("\\n");
        ArrayList<String> opener = new ArrayList<>();
        for (String i: data){
          String[] dataset = i.split("\\|");
          for (String set: dataset){
            String[] op = set.split(",");
            if (op[0].equals("1")){
              if (!ans.containsKey(op[1])){
                ArrayList<Integer> o = new ArrayList<>();
                o.add(Integer.parseInt(op[2]));
                o.add(1);
                ans.put(op[1], o);
              }
              else{
                ArrayList<Integer> val = ans.get(op[1]);
                val.set(0, val.get(0)+Integer.parseInt(op[2]));
                val.set(1, val.get(1)+1);
                ans.put(op[1], val);
              }
            }
          }
        }
        return ans;
    }
    
    
    public String getQuery(String cricketDataset,String query)
    {
      String ans = "";
      if(query.length() != 1){
        String[] q = query.split(" ");
        if (q.length != 3){
          TreeMap<Integer, String> players = createPlayerPositionMap(cricketDataset);
          TreeMap<String, Integer> scores = createPlayerScoreMap(cricketDataset);
          Integer t = Integer.parseInt(q[1]);
          HashMap<Integer, String> finalans = new HashMap<>();
          for (Integer p: players.keySet()){
            String pl = players.get(p);
            if (scores.get(pl) >= t){
              finalans.put(p, pl);
            }
          }
          Map<Integer, String> map = new TreeMap<>(finalans);
          for (Integer i:map.keySet()){
            ans += i+" "+map.get(i)+"\n";
          } 

        } else{
          if (Integer.parseInt(q[0]) == 1){
            TreeMap<Integer, String> sco = createPlayerPositionMap(cricketDataset);
            Integer p1 = Integer.parseInt(q[1]);
            Integer p2 = Integer.parseInt(q[2]);
            for (Integer i: sco.keySet()){
              if (i>=p1 && i<=p2){
                ans += i +" "+ sco.get(i)+"\n";
              }
            }
          }
        }
      } else{
        TreeMap<String, ArrayList<Integer>> an = createMatchesMap(cricketDataset);
        double max = 0;
        String op_name = "";
        for (String l: an.keySet()){
          ArrayList<Integer> v = an.get(l);
          Integer avg = v.get(0)/v.get(1);
          if (avg>max){
            max = avg;
            op_name = l;
          }
        }
        ans = "The Efficient Opener is "+op_name;
      }
        
       return ans; 
    }
  }

public class cricket{
  public static void main(String[] args) {
    TreemapHandson th = new TreemapHandson();
    // String answer = th.getQuery("1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
    String answer = th.getQuery("3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "2 50");
    System.out.println(answer);
  }
}
            

        