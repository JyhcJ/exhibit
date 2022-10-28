import java.util.Scanner;

public class CMUtility {
    Scanner s = new Scanner(System.in);

    public char readMenuSelection() {
        while (true) {

            String input = s.nextLine();
            if("".equals(input)){
                System.out.println("请输入内容!");
                continue;
            }
            if (is_AllNumeric(input)) {
                System.out.println("你的输入有误,请输入1-5的数字!");
                continue;
            }
            int format = Integer.parseInt(input);
            if (format > 5 || format < 1) {
                System.out.println("输入的数字不符合要求!");
                continue;
            }
            return input.charAt(0);
        }
    }

    public char readChar() {
        while (true) {
            String input = s.nextLine();
            if("".equals(input)){
                System.out.println("char类型不允许为空!");
                continue;
            }
            if (input.length() > 1) {
                System.out.println("你的输入有误.请输入一个char类型的字符!");
                continue;
            }

            return input.charAt(0);
        }
    }

    public char readChar(char defaultValue) {
        while (true) {
            String input = s.nextLine();
            if ("".equals(input)) {
                return defaultValue;
            }
            if (input.length() > 1) {
                System.out.println("你的输入有误.请输入一个char类型的字符!");
                continue;
            }
            return input.charAt(0);
        }
    }

    public int readInt() {
        while (true) {
            String input = s.nextLine();
            if("".equals(input)){
                System.out.println("请输入数字!");
                continue;
            }
            if (is_AllNumeric(input)) {
                System.out.println("你的输入有误,请输入全数字!");
                continue;
            }


            return Integer.parseInt(input);
        }

    }

    public int readInt(int defaultValue) {
        while (true) {
            String input = s.nextLine();
            if ("".equals(input)) {
                return defaultValue;
            }
            if (is_AllNumeric(input)) {
                System.out.println("你的输入有误,请输入全数字!");
                continue;
            }
            return Integer.parseInt(input);
        }


    }

    public String readString(int limit) {
        while (true) {
            String input = s.nextLine();
            if("".equals(input)){
                System.out.println("请输入内容!");
                continue;
            }
            if (input.length() > limit) {
                System.out.println("超出内容长度限制!");
                continue;
            }
            return input;
        }
    }

    public String readString(int limit, String defaultValue) {
        while (true) {
            String input = s.nextLine();
            if ("".equals(input)) {
                input = defaultValue;
            }
            if (input.length() > limit) {
                System.out.println("超出内容长度限制!");
                continue;
            }
            return input;
        }
    }


    public boolean is_AllNumeric(String judge) { //大于0的整数
        for (int i = judge.length()-1; i > 0; i--) {
            if (!Character.isDigit(judge.charAt(i))) {
                return true;
            }
        }//除了第一位都是数字

        return judge.charAt(0) != '-' && !Character.isDigit(judge.charAt(0));
    }

}
