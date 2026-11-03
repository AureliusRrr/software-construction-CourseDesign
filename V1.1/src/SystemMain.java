import java.util.HashMap;
import java.util.Scanner;

/**
 * 校园资源预约系统 V1.1 程序入口。
 *
 * <p>本版本使用 HashMap 在内存中管理动态注册的学生账号，
 * 并将输入校验逻辑从控制台主流程中抽离。</p>
 */
public class SystemMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<String, String>();
        boolean running = true;

        printTitle();

        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    login(scanner, users);
                    break;
                case "2":
                    register(scanner, users);
                    break;
                case "0":
                    running = false;
                    System.out.println("系统已退出。");
                    break;
                default:
                    System.out.println("输入无效，请选择 0、1 或 2。");
                    break;
            }

            System.out.println();
        }
    }

    private static void printTitle() {
        System.out.println("================================");
        System.out.println("      校园资源预约管理系统");
        System.out.println("             V1.1");
        System.out.println("================================");
    }

    private static void printMenu() {
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("0. 退出");
        System.out.print("请选择操作：");
    }

    private static void register(Scanner scanner, HashMap<String, String> users) {
        System.out.println("--- 学生注册 ---");
        System.out.print("请输入用户名：");
        String username = scanner.nextLine().trim();

        String usernameError = validateUsername(username);
        if (usernameError != null) {
            System.out.println("注册失败：" + usernameError);
            return;
        }

        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        String passwordError = validatePassword(password);
        if (passwordError != null) {
            System.out.println("注册失败：" + passwordError);
            return;
        }

        if (users.containsKey(username)) {
            System.out.println("注册失败：用户名已存在！");
            return;
        }

        users.put(username, password);
        System.out.println("注册成功，现在可以使用该账号登录。");
    }

    private static void login(Scanner scanner, HashMap<String, String> users) {
        System.out.println("--- 用户登录 ---");
        System.out.print("请输入用户名：");
        String username = scanner.nextLine().trim();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        if (username.length() == 0 || password.length() == 0) {
            System.out.println("登录失败：用户名和密码不能为空！");
        } else if (!users.containsKey(username)) {
            System.out.println("登录失败：用户不存在！");
        } else if (!users.get(username).equals(password)) {
            System.out.println("登录失败：密码错误！");
        } else {
            System.out.println("登录成功，欢迎学生 " + username + "！");
        }
    }

    private static String validateUsername(String username) {
        if (username == null || username.length() == 0) {
            return "用户名不能为空！";
        }
        return null;
    }

    private static String validatePassword(String password) {
        if (password == null || password.length() == 0) {
            return "密码不能为空！";
        }
        if (password.length() < 6) {
            return "密码长度不能少于 6 位！";
        }
        return null;
    }
}
