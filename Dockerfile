FROM frolvlad/alpine-oraclejdk8:slim

WORKDIR /opt

VOLUME /tmp

RUN mkdir /opt/app

EXPOSE 8080

ADD build/libs/rxjava-0.0.1-SNAPSHOT.jar   /opt/app/rxjava-0.0.1-SNAPSHOT.jar

ENV JAVA_OPTS="-Xmx1g -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSConcurrentMTEnabled"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /opt/app/rxjava-0.0.1-SNAPSHOT.jar " ]

