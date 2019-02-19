package daiyun.middleware.activemq.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMqProducer {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        try {
            Connection connection = factory.createConnection();
            connection.start();

            //是否是事务状态，消息确认方式
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("firstTopic");

            MessageProducer producer = session.createProducer(destination);

            Message message = session.createTextMessage("first message!");

            producer.send(message);

            session.commit();
            session.close();

            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
