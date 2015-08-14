package Utils;

import org.apache.tomcat.util.codec.binary.Base64;

public class StringUtils {
    public static boolean isNullOrEmpty(String value) {
        return  value== null || value.length() == 0;
    }

    public static  byte[] toBase64(StringBuilder imageData) {
        byte[] bytesEncoded = Base64.encodeBase64(imageData.toString().getBytes());
        return bytesEncoded;
    }

    public static  byte[] fromBase64(byte[] media) {
        byte[] bytesEncoded = Base64.decodeBase64(media.toString().getBytes());
        return (bytesEncoded);
    }
}
