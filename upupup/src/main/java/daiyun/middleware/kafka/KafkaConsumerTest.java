package daiyun.middleware.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTest extends Thread {

    private final KafkaConsumer kafkaConsumer;
    private final String topic;

    public static void main(String[] args) {
        KafkaConsumerTest kafkaConsumerTest = new KafkaConsumerTest("topic1");
        kafkaConsumerTest.start();
    }

    public KafkaConsumerTest(String topic) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "slave1:9092,slave2:9092,slave3:9092");

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumerTest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        kafkaConsumer = new KafkaConsumer(properties);

        kafkaConsumer.subscribe(Collections.singletonList(topic));
        this.topic = topic;
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<Integer, String> consumerRecords = kafkaConsumer.poll(1000);
            for (ConsumerRecord consumerRecord : consumerRecords) {
                System.out.println("get message:" + consumerRecord.value());

            }

        }
    }
}
