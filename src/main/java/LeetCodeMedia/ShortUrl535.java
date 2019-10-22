package LeetCodeMedia;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShortUrl535
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/17  10:43 PM
 * @Version 1.0
 */

/**
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法一：如下
 * 解法二：hashcode  会产生冲突，不过概率比较低
 * 解法三：随机数加密 一样再次使用数字和字母表集合来为 URL 生成加密结果。这种方法中，加密后的长度固定是 6 位。
 * 如果产生出来的加密结果与之前产生的结果一样！！！！，就换一个新的加密结果。
 *
 *
 */
public class ShortUrl535 {
    int num = 0;
    Map<String,String> urlMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = "http://tinyurl.com/"+num;
        urlMap.put(shortUrl,longUrl);
        num++;
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = urlMap.get(shortUrl);
        return longUrl;
    }

    public static void main(String[] args){

    }
}
