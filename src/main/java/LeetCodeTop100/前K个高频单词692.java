package LeetCodeTop100;

/**
 * @ClassName 前K个高频单词692
 * @Author zhangxinkun
 * @Date 2020/1/12  10:01 PM
 * @Version 1.0
 */

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * 解析：使用最小堆，学会使用java的最下堆就行。
 *
 *
 */
public class 前K个高频单词692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordsMap = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            if(wordsMap.containsKey(words[i])){
                wordsMap.put(words[i],wordsMap.get(words[i])+1);
            }else{
                wordsMap.put(words[i],1);
            }
        }
        PriorityQueue<String> queue = new PriorityQueue<String>(k, new Comparator<String>() {
            @Override
            public int compare(String p1, String p2) {
                if(wordsMap.get(p1).equals(wordsMap.get(p2)) ){
                    return p1.compareTo(p2);
                }else{
                    return wordsMap.get(p2).intValue() - wordsMap.get(p1).intValue();
                }
            }
        });
        for(String temp : wordsMap.keySet()){
            queue.offer(temp);
        }
        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty() && k>0){
            ans.add(queue.poll());
            k--;
        }
        return ans;
    }
}
