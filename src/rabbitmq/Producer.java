package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ClassName: Producer 生产者
 * @Description: rabbitMQ 学习
 * @author: jkcho
 * @date: 2018年2月8日上午11:35:16
 */
public class Producer {
	// 定义队列名称
	public final static String QUEUE_NAME = "rabbit.test";

	public static void main(String[] args) throws Exception {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置RabbitMq相关信息
		//factory.setHost("localhost");
		// factory.setUsername("");
		// factory.setPassword("");
		// factory.setPort(2008);
		Connection connection = factory.newConnection();
		// 创建一个通道
		Channel channel = connection.createChannel();
		// 声明一个队列
		// queueDeclare();
		// 第一个参数表示队列名称、
		// 第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
		// 第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
		// 第四个参数为当所有消费者客户端连接断开时是否自动删除队列、第五个参数为队列的其他参数
		channel.queueDeclare(QUEUE_NAME, false, false, true, null);
		String message = "Hello RabbitMQ";
		// 发送消息到队列中
		// basicPublish();
		// 第一个参数为交换机名称、
		// 第二个参数为队列映射的路由key、
		// 第三个参数为消息的其他属性、
		// 第四个参数为发送信息的主体
		for (int i = 0; i < 5; i++) {
			StringBuffer sb=new StringBuffer(message);
			sb.append(i);
//			Thread.sleep(5000);
			channel.basicPublish("", QUEUE_NAME, null, sb.toString().getBytes("UTF-8"));
			System.out.println("Producer Send +'" + sb + "'");
		}
//		System.out.println("Producer Send +'" + message + "'");
		channel.close();
		connection.close();
	}
}
