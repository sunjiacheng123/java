import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        String str=new String("测试");
        System.out.println(new String(DigestUtils.md5(str)));//md5加密
        System.out.println(DigestUtils.md5Hex(str));// MD5加密，返回32位字符串
        System.out.println(DigestUtils.md2Hex(str));
        // SHA-1加密
        System.out.println(new String(DigestUtils.sha1("123456")));
        System.out.println(DigestUtils.sha1Hex("123456"));
        // SHA-256加密
        System.out.println(new String(DigestUtils.sha256("123456")));
        System.out.println(DigestUtils.sha256Hex("123456"));
        // SHA-512加密
        System.out.println(new String(DigestUtils.sha512("123456")));
        System.out.println(DigestUtils.sha512Hex("123456"));

        String Str1= UUID.randomUUID().toString();//随机获取uuid
        System.out.println(Str1);
        //System.out.println(UUID.fromString("sad4a6"));//根据字符串获取UUID

        System.out.println("****************");
        Base64 base64=new Base64();
        String s=base64.encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);//base64加密
        System.out.println(new String(base64.decode(s)));//解密

        System.out.println(System.currentTimeMillis()+60000);

    }
}
