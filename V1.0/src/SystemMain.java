import java.util.Scanner;

/**
 * 校园资源预约系统 V1.0 程序入口。
 *
 * <p>本版本按照课程任务要求，将登录交互与校验逻辑集中在主类中，
 * 暂不进行分层或工具类抽取，为后续迭代重构保留基础。</p>
 */
public class SystemMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      校园资源预约管理系统");
        System.out.println("             V1.0");
        System.out.println("================================");

        System.out.print("请输入账号：");
        String username = scanner.nextLine().trim();

        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        if ("admin".equals(username) && "123456".equals(password)) {
            System.out.println("登录成功，欢迎管理员 admin！");
        } else if ("student".equals(username) && "123456".equals(password)) {
            System.out.println("登录成功，欢迎学生 student！");
        } else {
            System.out.println("登录失败：账号或密码错误！");
        }
    }
}
