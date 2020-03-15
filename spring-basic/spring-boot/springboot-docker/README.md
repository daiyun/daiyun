# SpringBoot 容器化docker部署

## 通过Maven插件构建镜像

1. pom.xml 中添加插件
```xml
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
                <!--将 docker:build 绑定到package 自动执行-->
                <executions>
                    <execution>
                        <id>build-image</id>
                        <!--将插件绑定到pageage-->
                        <phase>package</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <!--镜像名称-->
                    <imageName>daiyun/${project.artifactId}</imageName>
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

2. 编辑Dockerfile
```shell
FROM harisekhon/centos-java
VOLUME /tmp
ADD springboot-docker-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

3. 执行mvn打包并生成镜像
```shell
mvn package docker:build
mvn pageage
mvn docker:build
```