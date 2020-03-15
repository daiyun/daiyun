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



## 配置中心

Git地址：https://github.com/daiyun/conf.git

目录：springcloud

配置中心：http://spring-app:8899/

