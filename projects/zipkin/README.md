# Download
[Zipkin Server最新版本](https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec)

# Quickstart
[https://zipkin.io/pages/quickstart](https://zipkin.io/pages/quickstart)

## Java
If you have Java 8 or higher installed, the quickest way to get started is to fetch the latest release as a self-contained executable jar:
```
cd ../projects/zipkin
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```

注意：springboot 2.x不能自行搭建zipkin-server服务

# 附录
[使用Elasticsearch作为Zipkin Server的后端存储](http://www.itmuch.com/spring-cloud/finchley-26/)