# oauth2-github-keycloak
github,spring-boot,spring-security,keycloak
包含三个模块github,keycloak,keycloaksecurity
## github 模块
#### 环境配置
1. 登录https://github.com,在个人setting页面配置OAuth Application,其他选项自己选择，仅仅需要注意的是在callback页面填写正确的回调地址，此项目使用spring-security，所以默认登录地址为/login,所以回调地址用该填写为http://localhost:8080/login
2. 在src/main/resources/application.yml页面配置github页面显示的client_id及其他字段
#### 运行
```
./gradlew :github:bootRun
```
## keycloak模块
### 说明
本模块采用spring-boot配置，相应权限拦截由web容器完成
#### 环境配置
1. 下载http://www.keycloak.org,直接运行bin/standalone.sh,登录后，创建自定义的realm，默认是master
2. 将相应配置填入application.properties
#### 运行
```
./gradlew :github:bootRun
```
### keycloaksecurity模块
### 说明
本模块采用spring-boot-security配置，权限拦截由spring-security完成，自定义化程度更高
步骤同keycloak一致