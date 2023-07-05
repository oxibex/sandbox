# Docker image with Java and Filebeat installed
# here just to keep how to build own filebeat + java image
FROM amazoncorretto:17-alpine as builder
ENV FILEBEAT_VERSION=8.8.2
COPY ./filebeat.yml /
RUN apk update && \
    apk add libc6-compat && \
    wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz -O /filebeat.tar.gz && \
    tar xzf filebeat.tar.gz && \
    rm filebeat.tar.gz && \
    mv filebeat-${FILEBEAT_VERSION}-linux-x86_64 filebeat && \
    cd filebeat && \
    cp filebeat /usr/bin && \
    rm -rf /filebeat/filebeat.yml && \
    mv /filebeat.yml /filebeat/ && \
    ls -ltr /filebeat && \
    cat /filebeat/filebeat.yml
CMD ["filebeat","-e","-strict.perms=false","--path.config","/filebeat/"]
