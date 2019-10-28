./mvnw package && java -jar registration-service-rest/target/registration-service-rest-0.0.1-SNAPSHOT.jar
Change java version on mac:
    - /usr/libexec/java_home -V (Kiem tra xem co bao nhieu jdk tren may)
    - export JAVA_HOME=`/usr/libexec/java_home -v 1.8` (set version thanh 1.8)
    
    
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">

  <!-- <servers>
    <server>
      <id>nexus-release</id>
      <username>admin</username>
      <password>123456</password>
    </server>
    <server>
      <id>nexus-snapshot</id>
      <username>admin</username>
      <password>123456</password>
    </server>
    <server>
      <id>nexus-maven-central</id>
      <username>admin</username>
      <password>123456</password>
    </server>
  </servers> -->

  <servers>
    <!-- <server>
      <id>nexus-release</id>
      <username>core-downloader</username>
      <password>SwyOLxB92L</password>
    </server> -->
    <server>
      <id>nexus-snapshot</id>
      <username>admin</username>
      <password>syphan</password>
    </server>
  </servers>

  <!-- <mirrors>
    <mirror>
      <id>central</id>
      <name>central</name>
      <url>http://localhost:2222/repository/maven-public/</url>
      <mirrorOf>*</mirrorOf>
    </mirror>
  </mirrors> -->

</settings>