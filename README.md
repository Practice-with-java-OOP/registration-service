./mvnw package && java -jar registration-service-rest/target/registration-service-rest-0.0.1-SNAPSHOT.jar
Change java version on mac:
    - /usr/libexec/java_home -V (Kiem tra xem co bao nhieu jdk tren may)
    - export JAVA_HOME=`/usr/libexec/java_home -v 1.8` (set version thanh 1.8)