package daiyun.product;

import kafka.common.FailedToSendMessageException;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * kafka发送器.
 * Company UnionBigdata Technology Co., Ltd.
 * Copyright (C) 2012-2016 All Rights Reserved.
 */
public class KafkaSent {
  static Producer<String, String> producer = null;

  public static void init() {
    Properties props = new Properties();
    props.setProperty("metadata.broker.list", "0.0.0.0:9092,0.0.0.0:9093,0.0.0.0:9094");
    props.setProperty("serializer.class", "kafka.serializer.StringEncoder");
    props.setProperty("request.required.acks", "1");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    ProducerConfig config = new ProducerConfig(props);
    producer = new Producer<String, String>(config);
  }

  public static void topicKafka(String topic, String key, String str) throws FailedToSendMessageException {
    if (producer == null) {
      init();
    }
    KeyedMessage<String, String> keyedMessage = new KeyedMessage<String, String>(topic, key, str);
    producer.send(keyedMessage);
  }

}
