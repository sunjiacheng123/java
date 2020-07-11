import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();

    }
    //
    class CmpKV implements Comparator<Map.Entry<String,Integer>>{

        @Override
        public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
            if(o2.getValue()>o1.getValue()){
                return 1;
            }
            if(o1.getValue()==o2.getValue() && o1.getKey().compareTo(o2.getKey())>0){
                return 1;
            }
            if(o1.getValue()==o2.getValue() && o1.getKey().compareTo(o2.getKey())==0){
                return 0;
            }
            return -1;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String,Integer> m =new HashMap<>();
        for(int i=0;i<words.length;i++){
            int count =m.getOrDefault(words[i],0);
            m.put(words[i],count++);
        }
        //2.创建优先级队列
        PriorityQueue<Map.Entry<String,Integer>> p=new PriorityQueue<>(new CmpKV());
        for(Map.Entry<String,Integer> e : m.entrySet()){
            p.offer(e);
        }
        List<String> ret=new ArrayList<>(k);
        for(int i=0;i<k;i++){
            ret.add(p.poll().getKey());
        }
        return ret;
    }





    public static void main1(String[] args) {
        HashSet<Integer> a = new HashSet<>();
        a.add(5);
        System.out.println(a.contains(5));
    }
    public static void main0(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            //1.循环接收用户的输入
            String right=sc.nextLine().toUpperCase();
            String wrong=sc.nextLine().toUpperCase();
            //2.wrong中每个字符放置到set中
            //将正常的建保存在set中
            Set<Character> s=new HashSet<>();
            for(int i=0;i<wrong.length();++i){
                s.add(wrong.charAt(i));
            }
            //3.检测right中每个字符是否在set中出现
            for(int i=0;i<right.length();i++){
                if(!s.contains(right.charAt(i))){
                    s.add(right.charAt(i));
                    System.out.print(right.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
