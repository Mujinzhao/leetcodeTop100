package LeetCodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证原始的序列 org 是否可以从序列集 seqs 中唯一地重建。序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104。重建是指在序列集 seqs 中构建最短的公共超序列。（即使得所有  seqs 中的序列都是该最短序列的子序列）。确定是否只可以从 seqs 重建唯一的序列，且该序列就是 org 。
 *
 * 示例 1：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 *
 * 输出：
 * false
 *
 * 解释：
 * [1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
 *  
 *
 * 示例 2：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2]]
 *
 * 输出：
 * false
 *
 * 解释：
 * 可以重建的序列只有 [1,2]。
 *  
 *
 * 示例 3：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 *
 * 输出：
 * true
 *
 * 解释：
 * 序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
 *  
 *
 * 示例 4：
 *
 * 输入：
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 *
 * 输出：
 * true
 */
public class torpeSort444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] into = new int[org.length+1];
        int N = org.length;
        if(seqs.size() == 0){
            return false;
        }
        int emptyNum = 0;
        for(int i=0;i<seqs.size();i++){
            if(seqs.get(i).size() == 1 || seqs.get(i).size() == 0){
                if(seqs.get(i).size() == 0){
                    emptyNum++;
                }
                if(seqs.get(i).size() == 1){
                    if(seqs.get(i).get(0) <=0 || seqs.get(i).get(0) > N){
                        return false;
                    }
                }
                continue;
            }
            for(int j=1;j<seqs.get(i).size();j++){
                if(seqs.get(i).get(j)>=1 && seqs.get(i).get(j)<=N){
                    into[seqs.get(i).get(j)]++;
                }else {
                    return false;
                }
            }
        }
        if(emptyNum == seqs.size()){
            return false;
        }
        int[] ans = new int[N];
        int number = 0;
        for(int cnt=0;cnt<N;cnt++){
            int temp = 0;
            boolean flag = true;
            for(int j=1;j<=N;j++){
                if(into[j] == 0){
                    if(flag == false){
                        return false;
                    }
                    temp = j;
                    ans[number++] = temp;
                    into[j] = -1;
                    flag = false;
                }
            }
            if(flag){
                return false;
            }
            for(int i=0;i<seqs.size();i++){
                if(seqs.get(i).size() == 1 || seqs.get(i).size() == 0){
                    continue;
                }
                for(int j=1;j<seqs.get(i).size();j++){
                    if(seqs.get(i).get(j-1) == temp){
                        if(seqs.get(i).get(j)>=1 && seqs.get(i).get(j)<=N){
                            into[seqs.get(i).get(j)]--;
                        }
                    }
                }
            }
        }
        return isEOk(org,ans);
    }

    boolean isEOk(int[] org,int[] num){
        int N = org.length;
        for(int i=0;i<N;i++){
            if(org[i] != num[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        torpeSort444 test = new torpeSort444();
        int[] orgs = {4,1,5,2,6,3};
        List<List<Integer>> seq = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(5);
        temp.add(2);
        temp.add(6);
        temp.add(3);
        seq.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(5);
        temp.add(2);
        seq.add(temp);
        test.sequenceReconstruction(orgs,seq);
    }
}
