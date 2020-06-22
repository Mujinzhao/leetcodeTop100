package LeetCodeTop100;

/**
 * @ClassName 验证UTF8编码
 * @Author zhangxinkun
 * @Date 2019/12/30  1:00 PM
 * @Version 1.0
 */

/**
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * 示例 1:
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2:
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 *
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 * 解析：就是个字符串操作，没什么难的
 */
public class 验证UTF8编码 {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        if(len == 0){
            return true;
        }
        for(int i=0;i<len; ){
            if(this.isOne(data[i])){
                i++;
                continue;
            }else if(this.isTwo(data[i])){
                if( (i+1) < len && this.isTicp(data[i+1])){
                    i+=2;
                    continue;
                }else{
                    return false;
                }
            }else if(this.isThree(data[i])){
                if( (i+2)<len && this.isTicp(data[i+1]) && this.isTicp(data[i+2])){
                    i+=3;
                    continue;
                }else{
                    return false;
                }
            }else if(this.isFour(data[i])){
                if((i+3)<len && this.isTicp(data[i+1]) && this.isTicp(data[i+2]) && this.isTicp(data[i+3])){
                    i+=4;
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isFour(int data){
        return (data&248) == 240;
    }

    public boolean isThree(int data){
        return (data&240) == 224;
    }

    public boolean isTwo(int data){
        return (data&224) == 192;
    }

    public boolean isOne(int data){
        return (data&128) == 0;
    }

    public boolean isTicp(int data){
        return (data&192) == 128;
    }
}
