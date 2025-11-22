# XLIDO

## Overview
XLIDO is a command-driven Java application designed for event and question management.
It allows users to create events, add questions, reply, upvote, and list questions using predefined commands.

Each command is validated through automated test cases.
The application reads input commands, processes them, and generates an output file which is compared against expected results to ensure correctness.

---

## How Verification Works

### 1. Running Test Cases
To verify your implementation, run the test case from the **Testing tab (Beaker icon)**.
For example, running the test:

```
CREATE_USER()
```

A **green tick** indicates your implementation is correct.

---

### 2. Input, Output & Expected Output
Each test case uses:

- **Input File:**  
  `test/resources/<TEST_NAME>/input.txt`

- **Generated Output File:**  
  `test/resources/<TEST_NAME>/output.txt`

- **Expected Output File:**  
  `test/resources/<TEST_NAME>/expectedOutput.txt`

Your implementation is considered correct only if:

```
output.txt  ===  expectedOutput.txt
```

---

## Viewing and Comparing Output

You may manually check the generated output for debugging:

```
test/resources/CREATE_USER/output.txt
```

Use a diff/compare tool to identify mismatched lines.

Example mismatch:

```
Expected: USER_CREATED 2  
Actual:   <some error>
```

Fix your implementation based on these differences.

---

## Activities
The project includes multiple activities to help you sequentially implement and test commands.
Each activity folder in `test/resources/` contains:

- input.txt  
- expectedOutput.txt  
- output.txt  

Activities include:

- CREATE_USER  
- CREATE_EVENT  
- ADD_QUESTION  
- DELETE_EVENT  
- DELETE_QUESTION  
- LIST_QUESTIONS  
- REPLY_QUESTION  
- UPVOTE_QUESTION  

---

## Folder Structure

```
XLIDO/
│   .gitattributes
│   .gitignore
│   gradlew
│   run.sh
│   settings.gradle
│
├── .gradle/
│
├── app/
│   │   build.gradle
│   │
│   └── src/
│       ├── main/java/com/crio/xlido/
│       │       App.java
│       │
│       │── entities/
│       │       Event.java
│       │       Question.java
│       │       Reply.java
│       │       User.java
│       │
│       │── Repository/
│       │       EventRepository.java
│       │       IEventRepository.java
│       │       IQuestionRepository.java
│       │       IReplyRepository.java
│       │       IUserRepository.java
│       │       QuestionRepository.java
│       │       ReplyRepository.java
│       │       UserRepository.java
│       │
│       │── service/
│       │       EventService.java
│       │       IEventService.java
│       │       IQuestionService.java
│       │       IReplyService.java
│       │       IUserService.java
│       │       QuestionService.java
│       │       ReplyService.java
│       │       UserService.java
│
│       └── test/
│           ├── java/com/crio/xlido/AppTest.java
│           └── resources/
│               ├── ADD_QUESTION/
│               ├── CREATE_EVENT/
│               ├── CREATE_USER/
│               ├── DELETE_EVENT/
│               ├── DELETE_QUESTION/
│               ├── LIST_QUESTIONS/
│               ├── REPLY_QUESTION/
│               └── UPVOTE_QUESTION/
│
├── gradle/wrapper/
│       gradle-wrapper.jar
│       gradle-wrapper.properties
│
├── sample_input/
│       sample_input_one.txt
│       sample_input_two.txt
│
└── __CRIO__/
        metadata.json
```

---

## Setup

### Step 1 — Navigate to project folder
```bash
cd XLIDO
```

### Step 2 — Build the project (optional)
```bash
mvn clean install
```
or
```bash
gradle build
```

### Step 3 — Configure setup (if required)
- Set environment variables  
- Update `.properties` files (if any)

---

## Running the Application

### Using JAR
```bash
java -jar target/xlido-app.jar
```

### Using Maven
```bash
mvn spring-boot:run
```

Application will be available at:

```
http://localhost:8080
```

---

## Usage
Provide commands from input files under `test/resources/<ACTIVITY>`.  
Each command performs an operation such as:

- Creating users  
- Creating events  
- Adding questions  
- Listing questions  
- Replying to questions  
- Upvoting questions  

---
