
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static TPBank bank = new TPBank();

    public static void main(String[] args) {
        Main m = new Main();
        Locale vi = new Locale("vi");
        Locale en = new Locale("en");
        while (true) {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            int choice = m.getChoice("Please choice one option: ", 1, 3);
            switch (choice) {
                case 1:
                    bank.setLocate(vi);
                    m.login();
                    break;
                case 2:
                    bank.setLocate(en);
                    m.login();
                    break;
                case 3:
                    return;
            }
        }
    }

    public int getChoice(String mes, int min, int max) {
        while (true) {
            try {
                int n;
                System.out.print(mes);
                n = Integer.parseInt(in.readLine());
                if (n < min || n > max) {
                    System.out.println("Enter a number from " + min + " to " + max);
                    continue;
                }
                return n;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Enter a number from " + min + " to " + max);
            }

        }
    }//check select user

    public void login() {
        getAccount();
        getPassword();
        getCaptcha();
        System.out.println(bank.bundle().getString("success"));
    }

    public void getAccount() {
        while (true) {
            try {
                System.out.print(bank.bundle().getString("account"));
                String account = in.readLine();
                String check = bank.checkAccountNumber(account);
                if (check.equals("")) {//check = "" <=> không có dòng báo lỗi nào
                    break;
                }
                System.out.println(check);//in ra dòng báo lỗi 
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public void getPassword() {
        while (true) {
            try {
                System.out.print(bank.bundle().getString("password"));
                String password = in.readLine();
                String check = bank.checkPassword(password);
                if (check.equals("")) {//check = "" <=> không có dòng báo lỗi nào
                    break;
                }
                System.out.println(check);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void getCaptcha() {
        String captchaGenerate = bank.generateCaptcha();
        System.out.print("Enter Captcha: " + captchaGenerate);
        System.out.println();
        while (true) {
            try {
                System.out.print(bank.bundle().getString("captcha"));
                String captchaInput = in.readLine();
                String check = bank.checkCaptcha(captchaInput, captchaGenerate);
                if (check.equals("")) {//check = "" <=> không có dòng báo lỗi nào
                    break;
                }
                System.out.println(check);
            } catch (IOException e) {//in ra dòng báo lỗi nếu có
                System.out.println(e);
            }
        }
    }
}
