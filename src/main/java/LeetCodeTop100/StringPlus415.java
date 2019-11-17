package LeetCodeTop100;

/**
 * 字符串相加
 */
public class StringPlus415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder builder1 = new StringBuilder(num1);
        StringBuilder builder2 = new StringBuilder(num2);
        builder1 = builder1.reverse();
        builder2 = builder2.reverse();
        int minLen = Math.min(len1,len2);
        int i = 0;
        int bit = 0;
        StringBuilder ans = new StringBuilder();
        while(i < minLen){
            int a = builder1.charAt(i) - '0';
            int b = builder2.charAt(i) - '0';
            if(a + b + bit <= 9){
                ans.append(String.valueOf(a+b+bit));
                bit = 0;
            }else{
                ans.append(String.valueOf((a+b+bit)%10));
                bit = (a+b+bit)/10;
            }
            i++;
        }
        while(i < len1){
            int a = builder1.charAt(i++) - '0';
            if(a + bit <=9){
                ans.append(String.valueOf(a+bit));
                bit = 0;
            }else{
                ans.append((a+bit) % 10);
                bit = (a+bit) / 10;
            }

        }
        while(i < len2){
            int a = builder2.charAt(i++) - '0';
            if(a + bit <=9){
                ans.append(String.valueOf(a+bit));
                bit = 0;
            }else{
                bit = (a+bit) / 10;
                ans.append((a+bit) % 10);
            }
        }
        if(bit!=0){
            ans.append(String.valueOf(bit));
        }
        return ans.reverse().toString();
    }

    /**
     * 学习一下别人的  精简写法
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args){
        String num1 = "9133";
        String num2 = "0";
        StringPlus415 test = new StringPlus415();
        test.addStrings(num1,num2);
    }
}
