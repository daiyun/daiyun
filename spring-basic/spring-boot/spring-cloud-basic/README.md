# springcloud 组件信息记录

## springcloud 依赖版本

 

`pox.xml`

```xml
    <groupId>daiyun</groupId>
    <artifactId>**</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.5.RELEASE</version>
        <relativePath/>
    </parent>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR2</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <!--镜像名称-->
                    <imageName>daiyun/${project.artifactId}:${project.version}</imageName>
                    <!--Dockerfile所在路径-->
                    <dockerDirectory>src/main/docker</dockerDirectory>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <!--需要复制打包的应用所在路径-->
                            <directory>${project.build.directory}</directory>
                            <!--需要复制打包的应用文件-->
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                </configuration>
            </plugin>
        </plugins>
    </build>
```



`Dockerfile`

```dockerfile
FROM harisekhon/centos-java
VOLUME /tmp
ADD **.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```



`bootstrap.yml`

```properties
# 配置中心服务的地址
spring:
  cloud:
    config:
      uri: http://spring-app:8899/
      label: master
      name: admin
      profile: dev

```



创建运行容器

```shell
docker run -d --name springcloud-* -p *:* *
```



容器日志查看

```shell
docker logs -f -t --tail 10 springcloud-eureka
```



网络

```
127.0.0.1    spring-app
```



## 注册中心

注册中心：http://spring-app:8660/eureka/



```properties
eureka:
  instance:
    hostname: spring-app
    statusPageUrlPath: http://${eureka.instance.hostname}:${server.port}//swagger-ui.html
    healthCheckUrlPath: http://${eureka.instance.hostname}:${server.port}/actuator/health
    lease-expiration-duration-in-seconds: 30
    lease-renewal-interval-in-seconds: 10
  client:
    registry-fetch-interval-seconds: 10
    healthcheck:
      enabled: true
    serviceUrl:
      defaultZone: http://spring-app:8660/eureka/
```



## 配置中心

Git地址：https://github.com/daiyun/conf.git

目录：springcloud

配置中心：http://spring-app:8899/



```properties
# 配置中心服务的地址
spring:
  cloud:
    config:
      uri: http://spring-app:8899/
      label: master
      name: admin
      profile: dev

```



## spring-admin

地址：<http://spring-app:8766/>

账号密码：sa/sa



## appNo*

WEB地址：<http://spring-app:*/swagger-ui.html>

`pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>daiyun</groupId>
    <artifactId>springcloud-eureka-*</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.5.RELEASE</version>
        <relativePath/>
    </parent>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR2</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <!--镜像名称-->
                    <imageName>daiyun/${project.artifactId}:${project.version}</imageName>
                    <!--Dockerfile所在路径-->
                    <dockerDirectory>src/main/docker</dockerDirectory>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <!--需要复制打包的应用所在路径-->
                            <directory>${project.build.directory}</directory>
                            <!--需要复制打包的应用文件-->
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```



`bootstrap.yml`

```properties
# 配置中心服务的地址
spring:
  cloud:
    config:
      uri: http://spring-app:8899/
      label: master
      name: appNo1
      profile: dev

```



`application.yml`

```properties
spring:
  profiles:
    active: dev
```



`application-dev.yml`

```properties
server:
  port: 9001

spring:
  application:
    name: springcloud-eureka-appNo1
debug: false

eureka:
  instance:
    hostname: spring-app
    statusPageUrlPath: http://${eureka.instance.hostname}:${server.port}/swagger-ui.html
    healthCheckUrlPath: http://${eureka.instance.hostname}:${server.port}/actuator/health
    lease-expiration-duration-in-seconds: 30
    lease-renewal-interval-in-seconds: 10
  client:
    registry-fetch-interval-seconds: 10
    healthcheck:
      enabled: true
    serviceUrl:
      defaultZone: http://spring-app:8660/eureka/

management:
  endpoint:
    health:
      show-details: ALWAYS #health endpoint是否必须显示全部细节
  endpoints:
    web:
      exposure:
        include: "*" #暴露所有的端点我们可以看到更多的服务实例相关信息
        exclude: env
    jmx:
      exposure:
        include: "*"
        exclude: env

```



`SwaggerConfig`

```java
package daiyun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("daiyun.*"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("daiyun")
                .description("ADC RESTful APIs doc")
                .version("1.0")
                .build();
    }

}
```



`Controller Swagger2`

```java
package daiyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author godaiyun
 * @date 2018-09-29 16:31.
 */
@Api("Index")
@RestController
@RequestMapping("/")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name:no name}")
    String appName;

    @RequestMapping("/")
    public String home() {
        return "Hello world :" + appName;
    }

    @ApiOperation(value = "hi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "path", required = true)
    })
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        LOGGER.info("get request...");
        return "hi " + name + " ,i am from port:" + port;
    }


}

```

