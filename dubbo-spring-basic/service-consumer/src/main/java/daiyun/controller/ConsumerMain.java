package daiyun.controller;

import daiyun.service.IBasicService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author godaiyun
 * @date 2018-09-28 14:08.
 */
public class ConsumerMain {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
        (new String[]{"application-dubbo.xml"});
    context.start();
    IBasicService demoService = (IBasicService) context.getBean("iBasicService"); // 获取远程服务代理
    String hello = demoService.hello("world"); // 执行远程方法
    System.out.println(hello); // 显示调用结果
  }
}
