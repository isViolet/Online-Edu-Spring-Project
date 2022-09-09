# 工程简介

github地址：https://github.com/isViolet/Online-Edu-Spring-Project

# 安装工具

- 使用彩色日志需要安装`grep-console`插件
- 使用 `@data` 注解安装`lombok`插件

# nginx.config
```
http {
    include mime.types;
    default_type application / octet - stream;

    sendfile on;
    #tcp_nopush on;

    #keepalive_timeout 0;
    keepalive_timeout 65;

    #gzip on;

    server {
        listen 81;
        server_name localhost;


        location / {
            root html;
            index index.html index.htm;
        }


        error_page 500 502 503 504 / 50 x.html;
        location = /50x.html  {
            root html;
        }

    }

    server {

        listen 8201;
        server_name localhost;

        location~/edu-service/ {
            proxy_pass http: //localhost:8001;
        }

        location~/oss-service/ {
            proxy_pass http: //localhost:8002;
        }
    }

}
```