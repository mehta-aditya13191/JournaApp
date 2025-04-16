📔 Timelogger - Sentiment-based Journal Logging App
Timelogger is a personal mental-wellness and productivity tracking application built with Spring Boot and MongoDB.
It enables users to log daily journal entries along with their emotional sentiment, such as HAPPY, SAD, ANGRY, or ANXIOUS.
With role-based access control and JWT-secured authentication, the app provides a personalized and secure journaling experience.
A unique feature includes weekly mood analysis, where users automatically receive an email every Sunday summarizing their past week's emotional patterns based on logged entries.

✨ Key Features

👤 User Management:

🔐 Secure Authentication: Users can register and log in with JWT-based token authentication secured by Spring Security.

🛡️ Role-Based Access Control: Distinct roles for Admin and User, ensuring secure and structured API access.

🔄 Token Refresh & Logout: Session management with token renewal support and secure logout functionality.

📘 Journal Entry Management:

📝 Create/Edit/Delete Entries: Users can write daily journal entries with a title, description, and emotional sentiment.

🗂️ View Entries by Date: Quickly retrieve entries for specific dates or view the full journal history.

🔄 Update/Delete Control: Users have full access to modify or delete their own entries.

😊 Sentiment Tracking:

❤️ Emotion Tagging: Every journal entry includes a sentiment (e.g., HAPPY, SAD, ANGRY, ANXIOUS) for emotional analysis.

📊 Weekly Mood Summary: Each Sunday, users receive a sentiment report via email analyzing their emotional trends from the past week (only if sentiment tracking is enabled).

📨 Email Integration:

✉️ Automated Weekly Emails: Mood-based analytics sent automatically to users' registered emails summarizing their week’s mental well-being.

📑 API & System Management:

📄 Swagger UI Integration: Interactive API documentation for easy testing and development.

🔁 Enum Normalization: User-friendly input handling using @JsonCreator to accept flexible sentiment input (e.g., "Happy", "HAPPY").

✅ Spring Boot Health Endpoint: Health-check API for monitoring backend service uptime.

🛠️ Technologies Used:

☕ Java: Language used to develop the entire backend.

🚀 Spring Boot: Framework for building the RESTful backend and managing dependencies.

🔐 Spring Security + JWT: To ensure secure login, role-based access, and data protection.

🧠 MongoDB: NoSQL database for storing journal entries and user details in a flexible schema.

📮 JavaMailSender: For sending personalized weekly sentiment reports.

🧪 JUnit: For unit testing and ensuring API reliability.

🛠️ Swagger: For auto-generating and testing RESTful endpoints.

☁️ GitHub Actions (optional): For CI/CD pipeline setup (if configured).

📥 Installation and Setup

bash
Copy
Edit
git clone https://github.com/mehta-aditya13191/Timelogger.git
cd Timelogger
# Set up your environment variables (email credentials, JWT secret, etc.)
# Run the application
./mvnw spring-boot:run
