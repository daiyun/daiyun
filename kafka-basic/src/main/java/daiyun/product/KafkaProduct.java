package daiyun.product;

import java.io.IOException;

/**
 * @author godaiyun
 * @date 2018-11-19 14:35.
 */
public class KafkaProduct {

  public static void main(String[] args) throws IOException {


    KafkaSent.init();

    KafkaSent.topicKafka("test01", "huang", "今天有点冷！");

    System.in.read();

  }
}
