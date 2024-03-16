
# Log Collection and Analysis Application

This project is designed for collecting, forwarding, and analyzing logs. It consists of several components, including `api-collector`, `app-collector`, and `api-demo`, which work together to process and store log data efficiently.

## Overview

- **api-collector**: Accepts logs and forwards them to RabbitMQ.
- **app-collector**: Reads logs from RabbitMQ and sends them to Elasticsearch for storage and analysis.
- **api-demo**: Generates exceptions and sends the log data to `api-collector`.

These components are orchestrated using Docker, making the setup and deployment process straightforward.

## Getting Started

### Prerequisites

- Docker and Docker Compose installed on your machine.



