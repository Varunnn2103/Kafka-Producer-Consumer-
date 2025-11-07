# Kafka Producer & Consumer (Spring Boot)

[![Java](https://img.shields.io/badge/Java-17-blue.svg)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)]()
[![Apache Kafka](https://img.shields.io/badge/Kafka-3.x-black.svg)]()

This project demonstrates a **Kafka Producer and Consumer** implementation using **Spring Boot**.  
The producer publishes messages to a Kafka topic (`my-topic`), and the consumer listens to the same topic and processes the incoming messages.

---

## 🧠 Key Concepts Demonstrated
- Creating a Kafka topic and sending messages to it
- Consuming real-time messages using Kafka listeners
- Spring Kafka configuration & serialization
- Event-driven architecture fundamentals

---

## 📂 Project Structure
Kafka-Producer-Consumer/
├── producer/ # Spring Boot Producer Application
├── consumer/ # Spring Boot Consumer Application
└── README.md

yaml
Copy code

---

## ⚙️ Prerequisites

You must have the following installed:

| Tool | Version | Purpose |
|-----|---------|---------|
| Java | 17+ | Run Spring Boot apps |
| Maven | 3.x | Build and manage dependencies |
| Apache Kafka | 3.x | Message broker |
| Zookeeper | 3.x | Required for Kafka (unless using Kraft mode) |

---

## 🚀 How to Run Kafka

### 1. Start Zookeeper
```bash
zookeeper-server-start.sh config/zookeeper.properties
2. Start Kafka Broker
bash
Copy code
kafka-server-start.sh config/server.properties
3. Create the Topic (if not auto-created)
bash
Copy code
kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
▶️ Run the Applications
Run Producer:
bash
Copy code
cd producer
mvn spring-boot:run
Run Consumer:
bash
Copy code
cd consumer
mvn spring-boot:run
💡 How It Works
Producer Logic
Sends a message (string or object) to Kafka using KafkaTemplate.

Config defined under application.yml or application.properties.

Consumer Logic
Uses @KafkaListener(topics = "my-topic") to receive messages.

Processes message automatically on message arrival.

📝 Example Producer Request (If you exposed a REST endpoint)
bash
Copy code
curl --location 'http://localhost:8080/api/publish?message=HelloKafka'
Expected Consumer Output:

rust
Copy code
Received Message -> HelloKafka
🔧 Configuration Notes (Important)
Make sure these are correctly set:

properties
Copy code
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*
If these are wrong → the consumer will not read messages.
No magic. No hidden trick.

🛠️ Common Issues & Fixes
Problem	Cause	Fix
Consumer not receiving messages	Wrong group-id or offset settings	Set auto-offset-reset=earliest
Serialization errors	Model not registered or trusted	Set spring.json.trusted.packages=*
Connection refused	Kafka not running	Start Kafka before the apps

📈 Possible Enhancements
Add Avro Serialization + Schema Registry

Add Docker Compose for one-command startup

Implement retry & error-handling strategies

Add Kafka Streams real-time transformation

👤 Author
Varun
GitHub: https://github.com/Varunnn2103

📝 License
This project is released under the MIT License.

