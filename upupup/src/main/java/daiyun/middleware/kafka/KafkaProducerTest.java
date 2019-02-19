package daiyun.middleware.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class KafkaProducerTest {

    private final KafkaProducer<Integer, String> producer;

    private final String topic;

    public static void main(String[] args) {
        KafkaProducerTest kafkaProducerTest = new KafkaProducerTest("topic1");

        kafkaProducerTest.sent("sent message:ok!");


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public KafkaProducerTest(String topic) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "slave1:9092,slave2:9092,slave3:9092");

        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducerTest");
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
    }

    public void sent(String mes) {
        System.out.println(mes);
        producer.send(new ProducerRecord<Integer, String>(topic, mes));
    }
}
