FROM firshme/tcpspeed:latest
MAINTAINER zhangjianxin

ENV TZ 'Asia/Shanghai'

RUN rm -rf /fuckgfw

RUN mkdir -p /app/conf/

ADD conf /app/conf

ADD FuckUDPHSP-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

WORKDIR /app

CMD ["java","-jar","app.jar"]