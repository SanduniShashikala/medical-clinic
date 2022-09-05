package lk.ijse.dep9.clinic.misc;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoUtil {
    public static void main(String[] args) {
        String[] plainPasswords = {"admin", "doc123","doc123", "rec123", "rec456"};
        for (String passwaod: plainPasswords) {
            System.out.println(getSha256x(passwaod));
        }

    }
    public static String getSha256x(String text){
        return DigestUtils.sha256Hex(text);
    }
}
