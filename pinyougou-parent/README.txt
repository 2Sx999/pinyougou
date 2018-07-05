# 配置记录
所有service
    tomcat端口:8080
sellergoods-service 
    dubbo暴露端口:20881
user-service
    dubbo暴露端口:20882




manager-web
    tomcat端口:8081
shop-web
    tomcat端口:8082
user-web
    tomcat端口:8083



sms-service短信微服务
    tomcat端口:9000



# 安装FastDFS客户端到本地仓库
mvn install:install-file -DgroupId=org.csource.fastdfs -DartifactId=fastdfs  -Dversion=1.2 -Dpackaging=jar -Dfile=d:\setup\fastdfs_client_v1.20.jar