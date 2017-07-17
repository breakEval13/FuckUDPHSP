# FUCKUDPHSP


## 成功图
![](QQ20170713-214330@2x.png)


## 服务器简易部署

```bash
docker run -d --restart=always 
    -e 'SS_PASSWORD=123123' 
    -p 8338:8338/tcp 
    -p 150:150/udp 
    -p 150:150/tcp 
    --name=my-fs-ss 
    firshme/nssserver:latest

```
  * `8338` SS端口
  * `150`  FS加速端口
  * 用docker启动即可
  * SS默认协议 `aes-256-cfb`
  * SS_PASSWORD = SS密码
  * 端口不要随意更改
  
  * 启动必要配置 `conf/client_config.json`
  
 ```json
{
//  FS 加速
  "recent_address_list":["IP"],
  "upload_speed":2383127,//速率
  "download_speed":4766254,//速率
  "server_port":150, //FS端口（同步即可)
  "server_address":"IP",
  "protocal":"udp",//管道模式 TCP，UDP
  "auto_start":false, //默认值即可
  
//  端口映射
  "listen_port":1085,//服务端的端口
  "name":"fuckGFW", //（默认即可）
  "dst_port":8338,//SS端口
  
//  SS 配置
  "password": "123123",//SS加密后的密码 `SS_PASSWORD=123123`
  "localPort": 1081,//本地要映射的端口
  "method": "aes-256-cfb",//加密协议
  "logLevel": "INFO",//日志级（默认即可）
  "remotePort": 1085,//转发到本地的某个端口
  "proxyType": "socks5",//ss协议 （默认即可）
  "localIpAddress": "0.0.0.0",//default Value
  "remoteIpAddress": "127.0.0.1"//default Value

}

 ```
 
  * IP  = 部署Docker 的那台服务器的IP
  
## 该版本是临时版本（用来试试水)

## 本项目用FinalSpeed 修改而来，感谢Finalspeed作出的贡献。

## 该版本更加稳定，修改了依赖版本，添加了Socket5加密代理。

## socket5 是仿照SS 改版本的Java 版本。

## 如果想用老版本有图形界面的请移步 NSS，也是鄙人修改的版本。

## 里面的yaml文件是集群部署使用。（KUBERNETES)

## 转载请注明出处 https://firsh.me 鄙人博客。

## 专业版用Flink 做数据的发送以及接受。

