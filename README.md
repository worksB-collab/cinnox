# Spring Boot LINE Bot Project

This project demonstrates the integration of a Spring Boot application with the LINE Messaging API and MongoDB for
storing and querying user messages. It provides Restful endpoints to receive messages from a LINE bot, save these
messages, and query them.

## Features

* Receive and echo messages using LINE Messaging API
* Save messages to MongoDB
* Query saved messages by user ID
* Restful API documentation with Swagger

## Prerequisites

* JDK 11
* Maven 3.2+
* MongoDB 4.0+
* ngrok for local testing
* LINE Developer account and a Messaging API channel

## Steps for Testing

### 1. Setup and Configuration

Clone the Repository

```bash
git clone https://github.com/worksB-collab/cinnox.git
```

### 2. Configure Application Properties

Update the `application.properties` file with your MongoDB connection details and LINE Messaging API credentials:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/${yourDatabase}
line.bot.channel-token=${YOUR_CHANNEL_ACCESS_TOKEN}
line.bot.channel-secret=${YOUR_CHANNEL_SECRET}
```

### 3. Start the Application

#### 1. Run the server:

Run the application in its folder:

```bash
cd cinnox
mvn spring-boot:run
```

#### 2. Run ngrok:

* Run ngrok in the terminal to expose your local server:
    ```bash
    ngrok http http://localhost:80
    ```

* Update **Webhook URL** under Messaging API settings in Line developer console
  as `${the forwarding https url}/callback`.

    ```
    e.g.  https://f53b-114-36-202-33.ngrok-free.app/callback
    ```

### 4. Test with Postman

#### Send a Message to a User

    method: POST
    url: http://localhost:80/sendMessage/
    header: Content-Type: application/json
    body: {
            "userId": ${userId},
            "text": ${text}
           }

Replace `${userId}` with the user's id, and `${text}` with the desired message.

#### Query a Message List by User ID:

    method: GET
    url: http://localhost:80/messages/${userId}

Replace `${userId}` with the user's id, which you want to retrieve message from.

#### Receive Message from User

Send message to the account, which will trigger `handleTextMessageEvent` and save the message into DB.

## Documentation and Testing with Swagger

* Visit http://localhost:80/swagger-ui.html, which provides interactive API documentation and testing capabilities, in
  your browser.
* Explore the API endpoints and test them directly from the Swagger UI.