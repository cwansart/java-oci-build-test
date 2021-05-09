FROM openliberty/open-liberty:21.0.0.4-full-slim-java11-openj9-ubi

COPY --chown=1001:0 server.xml /config

RUN features.sh

COPY --chown=1001:0 target/app.war /config/apps

RUN configure.sh
