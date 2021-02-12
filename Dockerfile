FROM adoptopenjdk/openjdk11-openj9:latest
ENV STAGE_NAME certification
WORKDIR /usr/app
COPY build/libs/mifel-service-saldo-0.0.1.jar .
COPY extras/newrelic/ newrelic/
CMD java -javaagent:newrelic/newrelic.jar -Dnewrelic.environment=$STAGE_NAME -Xms768m -Xmx768m -jar mifel-service-saldo-0.0.1.jar
