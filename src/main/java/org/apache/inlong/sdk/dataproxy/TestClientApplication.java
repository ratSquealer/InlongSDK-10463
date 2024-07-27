package org.apache.inlong.sdk.dataproxy;//package org.apache.inlong.sdk.dataproxy;
//
//
//import org.apache.inlong.sdk.dataproxy.ProxyClientConfig;
//import org.apache.inlong.sdk.dataproxy.MessageSender;
//import org.apache.inlong.sdk.dataproxy.MessageSenderFactory;
//import org.apache.inlong.sdk.dataproxy.common.SendResult;
//
//import java.util.concurrent.TimeUnit;
//import java.util.Scanner;
// ------------------------------------------------
import org.apache.inlong.sdk.dataproxy.ProxyClientConfig;
import org.apache.inlong.sdk.dataproxy.common.SendResult;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class TestClientApplication {
//    public static void main(String[] args) {
//        try {
//            // 初始化配置
//            ProxyClientConfig config = ProxyClientConfig.getInstance();
//
//            // 让用户输入最大消息长度
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入最大消息长度（字节）：");
//            int maxMessageLength = scanner.nextInt();
//            config.setMaxMessageLength(maxMessageLength);
//
//            // 让用户选择是否启用截断
//            System.out.println("是否启用自动截断？（true/false）：");
//            boolean enableTruncation = scanner.nextBoolean();
//            config.setEnableTruncation(enableTruncation);
//
//            // 获取消息发送者并发送消息
//            DefaultMessageSender sender = new DefaultMessageSender(config);
////            SendResult result = sender.sendMessage(message.getBytes("utf8"), groupId, streamId, System.currentTimeMillis(), msgUUID, 100, TimeUnit.MILLISECONDS, false, true);
//            Boolean result = sender.sendMessage("这是一个测试消息。");
//
//            if (result) {
//                System.out.println("消息发送成功！");
//            } else {
//                System.out.println("消息发送失败！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 初始化配置
            ProxyClientConfig config = ProxyClientConfig.getInstance();

            System.out.println("请输入最大消息长度（字节）：");
            int maxMessageLength = scanner.nextInt();
            config.setMaxMessageLength(maxMessageLength);

            System.out.println("是否启用自动截断？（true/false）：");
            boolean enableTruncation = scanner.nextBoolean();
            config.setEnableTruncation(enableTruncation);

            // 用户输入其他必要参数
            scanner.nextLine(); // 清空缓冲区
            System.out.println("请输入 groupId：");
            String groupId = scanner.nextLine();
            System.out.println("请输入 streamId：");
            String streamId = scanner.nextLine();
            System.out.println("请输入 msgUUID：");
            String msgUUID = scanner.nextLine();
            System.out.println("请输入消息内容：");
            String message = scanner.nextLine();

            // 获取消息发送者并发送消息
            DefaultMessageSender sender = new DefaultMessageSender(config);
            SendResult result = sender.sendMessage(message.getBytes("utf8"), groupId, streamId, System.currentTimeMillis(), msgUUID, 100, TimeUnit.MILLISECONDS, false, enableTruncation);

            if (result == SendResult.OK) {
                System.out.println("消息发送成功！");
            } else {
                System.out.println("消息发送失败！原因：" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}