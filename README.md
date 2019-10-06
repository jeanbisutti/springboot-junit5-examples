This **Spring Boot project** illustrates how to use **QuickPerf** with **JUnit 5** during testing of a *repository*, a *service* or a *controller*.<br><br>
This project uses a SNAPSHOT version of QuickPerf. Indeed, the JUnit 5 version of QuickPerf is being developed. `Core` and `SQL` annotations of QuickPerf should work fine. To use the SNAPSHOT you may have to add the profile in `~/.m2/settings.xml`:
```xml
<profile>
     <id>allow-snapshots</id>
        <activation><activeByDefault>true</activeByDefault></activation>
     <repositories>
       <repository>
         <id>snapshots-repo</id>
         <url>https://oss.sonatype.org/content/repositories/snapshots</url>
         <snapshots><enabled>true</enabled></snapshots>
       </repository>
     </repositories>
   </profile>
```





