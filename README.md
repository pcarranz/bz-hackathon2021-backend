# bz-hackathon2021-backend
Backblaze Hackathon Demo to showcase microservice architecture with Spring Boot, Consul and React.

Frontend repo: https://github.com/pcarranz/bz-hackathon2021-frontend

## Run the App
Consul is needed to run the app. Start by installing the Consul agent and then run `consul agent -dev`.
For this app, create the following KV using the Consul UI or CLI: `/config/hackathon-demo/props/renderFilesButton` and assign it a boolean value.

Consul UI endpoint: http://localhost:8500/ui/

### IntelliJ
1. Import the project in IntelliJ
2. Run the Gradle build
3. Open `HackathonDemoApplication.java`
4. Press Play button

### Command Line
`./gradlew bootRun`

## Endpoints
List B2 Buckets [http://localhost:8080/b2/buckets](http://localhost:8080/b2/buckets)

View K/Vs stored in Consul [http://localhost:8080/getConfigFromValue](http://localhost:8080/getConfigFromValue)

## References
Spring Boot https://spring.io/guides/gs/spring-boot/

Spring Initialzr https://start.spring.io/

Spring Cloud Consul https://spring.io/projects/spring-cloud-consul

Spring Boot Actuator https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html

Install Consul https://learn.hashicorp.com/tutorials/consul/get-started-install
