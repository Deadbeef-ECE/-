import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//http://www.1point3acres.com/bbs/thread-250016-1-1.html
public class TopKFrequencyElements {
	// Bucket Sort O(n+k) time, O(n+k) space
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            if(!map.containsKey(n))
                map.put(n, 1);
            else map.put(n, map.get(n) + 1);
        }
        List<Integer>[] list = new List[nums.length+1];
        for(int n : map.keySet()){
            int freq = map.get(n);
            if(list[freq] == null)  list[freq] = new LinkedList<Integer>();
            list[freq].add(n);
        }
        List<Integer> ret = new LinkedList<Integer>();
        for(int i = list.length - 1; i > 0 && k > 0; i--){
            if(list[i] == null) continue;
            List<Integer> curList = list[i];
            ret.addAll(list[i]);
            k -= list[i].size();
        }
        return ret;
    }
}
