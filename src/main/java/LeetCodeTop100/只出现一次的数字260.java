package LeetCodeTop100;

/**
 * @ClassName 只出现一次的数字260
 * @Author zhangxinkun
 * @Date 2019/12/30  4:59 PM
 * @Version 1.0
 */

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 解析：通过将数字分割成2各部分实现。
 */
public class 只出现一次的数字260 {
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        int[] bit0 = new int[len];
        int[] bit1 = new int[len];
        int ans = 0;
        for(int i=0;i<len;i++){
            ans ^= nums[i];
        }
        // System.out.println(ans);
        int bit = 0;
        for(int i=0;i<=32;i++){
            if((ans&(1<<i)) != 0){
                bit = i;
                break;
            }
        }
        // System.out.println(bit);
        int temp0 = 0;
        int temp1 = 0;
        for(int i=0;i<len;i++){
            if((nums[i] & (1<<bit)) != 0){
                bit1[temp1++] = nums[i];
            }else{
                bit0[temp0++] = nums[i];
            }
        }
        // System.out.println("asdfdsa");
        int ans0 = 0;
        int ans1 = 0;
        for(int i=0;i<temp0;i++){
            ans0 ^= bit0[i];
        }
        for(int i=0;i<temp1;i++){
            ans1 ^= bit1[i];
        }
        int[] resolve = new int[2];
        resolve[0] = ans0;
        resolve[1] = ans1;
        return resolve;
    }
}
