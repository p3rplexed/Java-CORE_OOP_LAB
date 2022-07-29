
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class TPBank {

    private ResourceBundle bundle = null;
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    //gọi 2 properties để chọn ngôn ngữ cho chương trình
    public void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("language", locale);
    }

    public ResourceBundle bundle() {
        return bundle;
    }

    //check input account(là số và có độ dài = 10)
    public String checkAccountNumber(String accountNumber) {
        String s = "";
        if (!accountNumber.matches("[0-9]{10}")) {
            s = bundle.getString("errAccount");
        }
        return s;
    }

    //check password,có ít nhất 1 số,có ít nhất 1 chữ cái và có độ dài 8->30
    public String checkPassword(String password) {
        String s = "";
        if (password.length() < 8 || password.length() > 31) {
            s += bundle.getString("errPassword.length");
        }
        if (!password.matches("[a-zA-Z0-9]*[a-zA-z]+[a-zA-Z0-9]*")) {
            s += bundle.getString("errPassword.letter");
        }
        if (!password.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) {
            s += bundle.getString("errPassword.digit");
        }
        return s;

    }

    //check input capcha
    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        String s = "";
        if (!captchaGenerate.contains(captchaInput) || captchaInput.isEmpty()) {
            s += bundle.getString("errCaptcha");
        }
        return s;
    }

    public String generateCaptcha() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

}
