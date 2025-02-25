# Template for Scalable System Design

## 1️⃣ Step 1: Problem Understanding
- Clearly define the use case
- Identify the system type:
    - Read-heavy vs. Write-heavy
    - Real-time vs. Batch Processing
    - Monolithic vs. Microservices

## 2️⃣ Step 2: Functional & Non-Functional Requirements
### Functional Requirements (FRs)
- Define core functionalities users expect.
- List API endpoints if needed.

### Non-Functional Requirements (NFRs)
- High Availability
- Scalability
- Latency Requirements
- Data Consistency Model (Strong vs. Eventual Consistency)

## 3️⃣ Step 3: Traffic Estimation
- Monthly Active Users (MAU)
- Daily Active Users (DAU)
- Read-to-Write Ratio
- Requests per Second (RPS) Calculation

## 4️⃣ Step 4: Database Schema & Storage
- Define key tables, attributes, and relationships.
- Decide between SQL vs. NoSQL.
- Storage estimates.

## 5️⃣ Step 5: Backend Server Estimation
- Requests per Second (RPS) Breakdown.
- Server specification and estimation.

## 6️⃣ Step 6: High-Level Architecture
| Component | Technology |
|-----------|------------|
| Load Balancer | Nginx, HAProxy |
| Backend API | Node.js, Spring Boot |
| Database | PostgreSQL, DynamoDB |
| Caching | Redis, Memcached |
| Messaging Queue | Kafka, RabbitMQ |
| CDN | Cloudflare, Akamai |

## 7️⃣ Step 7: Scalability & Optimization
- Caching Mechanisms
- Horizontal Scaling Strategy
- Sharding & Partitioning

## 8️⃣ Step 8: Trade-offs & Challenges
| Trade-off | Explanation |
|-----------|------------|
| Consistency vs. Performance | Eventual consistency for faster reads |
| Storage Cost vs. Query Speed | Indexed vs. Non-indexed fields |

---

# Template for Stream and Batch Systems

## 1️⃣ Step 1: Problem Understanding
- Is it Batch or Streaming?
- Expected Data Volume per second/day.
- Real-time or Near real-time processing?

## 2️⃣ Step 2: Functional & Non-Functional Requirements
### Functional Requirements (FRs)
- Data ingestion
- Processing and aggregation logic
- Querying and analytics

### Non-Functional Requirements (NFRs)
- Low latency requirements
- Fault tolerance and recovery mechanisms

## 3️⃣ Step 3: Data Volume & Processing Estimation
| Metric | Estimation |
|--------|------------|
| Daily Data Volume | TBs/PBs |
| Events per Second | 100K - 500K |

## 4️⃣ Step 4: Processing Framework Choice
| System Type | Technology Stack |
|------------|-----------------|
| Batch Processing | Apache Spark, Hadoop |
| Stream Processing | Apache Flink, Kafka Streams |

## 5️⃣ Step 5: Backend Server Estimation
| Service | Throughput | Server Spec | Servers Needed |
|---------|-----------|-------------|----------------|
| Kafka Ingestion | 500K RPS | 128GB RAM | 10 |
| Flink Processing | 200K RPS | 256GB RAM | 20 |

## 6️⃣ Step 6: High-Level Architecture
| Component | Technology |
|-----------|------------|
| Data Ingestion | Kafka, AWS S3 |
| Stream Processing | Flink, Kafka Streams |
| Batch Processing | Spark, Hadoop |
| Query Engine | Presto, Druid |

## 7️⃣ Step 7: Scalability & Optimization
- Scaling Kafka Brokers
- Event Deduplication Mechanisms
- Indexing for Fast Querying

## 8️⃣ Step 8: Trade-offs & Challenges
| Trade-off | Explanation |
|-----------|------------|
| Throughput vs. Latency | Higher throughput may cause event lag |
| Cost vs. Performance | More resources reduce processing time |

---

✅ **This template ensures a structured and scalable approach to system design problems!** 🚀
