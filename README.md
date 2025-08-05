# Reddit Clone - Spring Boot Application

A full-stack Reddit clone built with Spring Boot backend and modern JavaScript frontend, featuring user authentication, communities (subreddits), posts, comments, and voting functionality.

## 🚀 Features

### Backend (Spring Boot)
- **User Authentication & Authorization**
  - JWT-based authentication
  - Email verification with verification tokens
  - Secure password encryption with BCrypt
  - Refresh token support

- **Core Functionality**
  - Create and manage subreddits (communities)
  - Create, read, update posts
  - Comment on posts
  - Upvote/downvote system
  - User profiles

- **API Documentation**
  - Swagger UI integration
  - RESTful API endpoints


## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot 2.7.18
- **Language**: Java 8
- **Database**: MySQL 8
- **Security**: Spring Security with JWT
- **ORM**: Hibernate/JPA
- **Email**: Spring Mail with Mailtrap
- **Mapping**: MapStruct 1.5.5.Final
- **Build Tool**: Maven



### Additional Libraries
- **Lombok** - Reduces boilerplate code
- **Swagger/Springfox** - API documentation
- **Timeago** - Relative time display (Kotlin library)

## 📋 Prerequisites

- **JDK 20** or compatible version
- **MySQL 8.0+** installed and running
- **Maven** (wrapper included)
- **Git** (for cloning)

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd Reddit-Clone-Spring-boot
```

### 2. Database Setup
```sql
CREATE DATABASE `spring-reddit-clone`;
```

### 3. Configure Application Properties
Edit `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/spring-reddit-clone
spring.datasource.username=root
spring.datasource.password=your_mysql_password

# Mail Configuration (Update with your SMTP details)
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=your_username
spring.mail.password=your_password

# Server Port
server.port=8086
```

### 4. Build and Run

**Windows (PowerShell):**
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-20"
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
export JAVA_HOME=/path/to/jdk-20
./mvnw spring-boot:run
```

### 5. Access the Application

- **Swagger UI**: http://localhost:8086/swagger-ui.html
- **API Base URL**: http://localhost:8086/api/

## 📁 Project Structure

```
Reddit-Clone-Spring-boot/
├── src/
│   ├── main/
│   │   ├── java/com/programming/pratya/springredditclone/
│   │   │   ├── config/          # Security, CORS, Password Encoder
│   │   │   ├── controller/      # REST Controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── exceptions/      # Custom Exceptions
│   │   │   ├── mapper/          # MapStruct Mappers
│   │   │   ├── model/           # JPA Entities
│   │   │   ├── repository/      # JPA Repositories
│   │   │   ├── security/        # JWT Provider, Filters
│   │   │   └── service/         # Business Logic
│   │   └── resources/
│   │       ├── templates/       # Email templates
│   │       └── application.properties
│   └── test/                    # Unit tests
├── pom.xml                      # Maven dependencies
└── README.md
```

## 🔌 API Endpoints

### Authentication
- `POST /api/auth/signup` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout
- `POST /api/auth/refresh/token` - Refresh JWT token
- `GET /api/auth/accountVerification/{token}` - Verify email

### Subreddits
- `GET /api/subreddit` - Get all subreddits
- `GET /api/subreddit/{id}` - Get subreddit by ID
- `POST /api/subreddit` - Create new subreddit (Auth required)

### Posts
- `GET /api/posts/` - Get all posts
- `GET /api/posts/{id}` - Get post by ID
- `POST /api/posts/` - Create new post (Auth required)
- `GET /api/posts/by-subreddit/{id}` - Get posts by subreddit
- `GET /api/posts/by-user/{username}` - Get posts by user

### Comments
- `POST /api/comments/` - Create comment (Auth required)
- `GET /api/comments/by-post/{postId}` - Get comments for post
- `GET /api/comments/by-user/{username}` - Get comments by user

### Votes
- `POST /api/votes/` - Vote on post (Auth required)


## 🔧 Development Notes

### Fixed Issues
- Resolved circular dependency in SecurityConfig
- Updated dependencies for JDK 20 compatibility
- Added CORS configuration for frontend-backend communication
- Configured static resource serving

### Known Deprecations
- `WebSecurityConfigurerAdapter` is deprecated (Spring Security 5.7+)
- Consider migration to component-based security configuration for future updates

## 🐛 Troubleshooting

### Port Already in Use
If port 8086 is in use, change it in `application.properties`:
```properties
server.port=8087
```

### Database Connection Issues
- Ensure MySQL is running
- Verify database credentials in `application.properties`
- Check database name matches: `spring-reddit-clone`

### Build Errors
```bash
# Clean and rebuild
.\mvnw.cmd clean install
```

## 📝 License

This project is open source and available for educational purposes.

## 👨‍💻 Author

**Pratya Amrit**
