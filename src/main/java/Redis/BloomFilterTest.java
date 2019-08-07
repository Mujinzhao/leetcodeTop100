package Redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import lombok.Data;

/**
 * @ClassName BloomFilterTest
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/24  10:55 AM
 * @Version 1.0
 */
public class BloomFilterTest {

    private static int size = 1000000;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size , 0.01);

    public void intoBlooFilter(){
        for (int i=0 ;i<size ; i++){
            bloomFilter.put(i);
        }
    }

    public void getFalseVote(){
        int right = 0;
        int worry = 0;
        for(int i= size+1;  i < size + size;  i++){
            if(bloomFilter.mightContain(i)){
                worry++;
            }else{
                right++;
            }
        }
        System.out.println("成功： " + right);
        System.out.println("失误： " + worry);
        System.out.println("失误率： " + (double)worry/size);
        System.out.println("成功率： " + (double)right/size);
    }

    @Data
    public static class FincTest{
        private int x;
        private int y;
    }
}
