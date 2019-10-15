import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=scanner.nextLine();

        for (int i=0;i<username.length();i++){
            char ch=username.charAt(i);
            boolean isSmall=ch >='a' && ch <= 'z';
            boolean isBig=ch >='A' && ch <= 'Z';
            if (!(isSmall || isBig)){
                throw new IllegalCharException("出现非法字符:"+ ch);
            }
        }

    }
}

class IllegalCharException extends RuntimeException{
    public IllegalCharException(String message) {
        super(message);
    }
}
