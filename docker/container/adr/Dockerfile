FROM alpine:3.7

ARG adr_version

RUN apk add --no-cache bash

ADD adr-tools-${adr_version}.tar.gz /opt

RUN mv /opt/adr-tools-${adr_version} /opt/adr-tools \
    && mkdir /tmp/adr

WORKDIR /tmp/adr

ENTRYPOINT ["/opt/adr-tools/src/adr"]