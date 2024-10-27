
<div align="center">
  <h1> :taxi: Taxi Booking System :taxi:</h1>
<h3>
  :zap: <a href="http://13.201.204.129:8080/home">Live Project </a>
</h3>
   
</p>
  
  </div>


<!-- Table of Contents -->
# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
  * [Screenshots](#camera-screenshots)
  * [Technologies Used](#space_invader-technologies-used)
  * [Features](#dart-features)
  * [Environment Variables](#key-environment-variables)
- [Getting Started](#toolbox-getting-started)
  * [Prerequisites](#bangbang-prerequisites)
  * [Installation](#gear-installation)
- [Deployment](#deployment)
- [Usage](#eyes-usage)
- [Contributing](#wave-contributing)
- [License](#warning-license)
- [Contact](#handshake-contact)


<!-- About the Project -->
## :star2: About the Project
The Taxi Booking System is a web application developed using Spring Boot and Java 17, designed to streamline taxi bookings with features like admin management, user authentication, file uploads, and car management. Built using Thymeleaf for the frontend and MySQL for data storage, this application provides a user-friendly experience on a Tomcat server, with Lombok reducing code verbosity.
<!-- Screenshots -->
### :camera: Screenshots

<div align="center">
  <table>
    <tr>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016440/Screenshot_2024-10-27_133155_qjoimq.png" alt="screenshot" width="400"/></td>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016440/Screenshot_2024-10-27_133314_q1y8xc.png" alt="screenshot" width="400"/></td>
    </tr>
    <tr>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016439/Screenshot_2024-10-27_133454_t7cbgy.png" alt="screenshot" width="400"/></td>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016439/Screenshot_2024-10-27_133336_ejmucn.png" alt="screenshot" width="400"/></td>
    </tr>
    <tr>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016438/Screenshot_2024-10-27_133523_ibhbpt.png" alt="screenshot" width="400"/></td>
      <td><img src="https://res.cloudinary.com/divq45mjo/image/upload/v1730016438/Screenshot_2024-10-27_133543_rafxrq.png" alt="screenshot" width="400"/></td>
    </tr>
  </table>
</div>

  
  
</div>


<!-- TechStack -->
### :space_invader: Technologies Used

<details>
  <summary>Backend</summary>
  <ul>
    <li><a href="https://www.java.com/en/">Java</a></li>
    <li><a href="https://spring.io/projects/spring-boot">Spring Boot</a></li>
    <li><a href="https://hibernate.org/">Hibernate</a></li>
  </ul>
</details>

<details>
  <summary>Frontend</summary>
  <ul>
    <li><a href="https://www.thymeleaf.org/">Thymeleaf</a></li>
    <li><a href="https://html.com/">HTML</a></li>
    <li><a href="https://www.w3.org/Style/CSS/Overview.en.html">CSS</a></li>
    <li><a href="https://www.javascript.com/">JavaScript</a></li>
  
  </ul>
</details>

<details>
<summary>Database</summary>
  <ul>
    <li><a href="https://www.mysql.com/">MySQL</a></li>
  </ul>
</details>

<details>
<summary>Deployment</summary>
  <ul>
    <li><a href="https://aws.amazon.com/ec2/">AWS EC2</a></li>
  </ul>
</details>

<!-- Features -->
### :dart: **Features**

- **Admin Panel**: Manage admin credentials, user bookings, and cars.
  
- **Authentication**: Admin login and logout functionality.

- **File Upload**: Upload files for add services or booking details.
  
- **Contact Form**: Users can reach out to the admin.
  
- **Car Booking**: Users can book cars by providing necessary details.
  
- **About Page**: Overview of the taxi booking service.
  
- **Services Page**: Displays services provided.

 <!-- Env Variables -->
### :key: Environment Variables

To run this project, you will need to add the following environment variables to your .env file or application.properties

`db_url`

`db_username`

`db_password`

<!-- Getting Started -->
## 	:toolbox: Getting Started

<!-- Prerequisites -->
### :bangbang: Prerequisites

- Java 17
- Spring Boot 3.2.5
- MySQL
- Maven

<!-- Installation -->
### :gear: Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Vineet1025/Taxi-Booking-Application.git
   cd Taxi-Booking-Application
   ```
2. **Configure your application.properties for openweathermap api, database connection and notification alert**:
    ```bash
    
    //DB connection
    spring.datasource.url=${db_url} //Enter your database url (jdbc:mysql://localhost:3306/taxibooking_db)
    spring.datasource.username=${db_username}  //Enter your database username
    spring.datasource.password=${db_password}  //Enter your database passward
    
    ```
3. **Run the application**:
   ```bash
   mvn spring-boot:run
    ```
4. **Access the application in your browser at** http://localhost:8080/home
   
   **Access the Admin Dashboard in your browser at** http://localhost:8080/admin/dashboard
   - **Username**: admin
   - **Password**: admin123

### :triangular_flag_on_post: Deployment

The application has been successfully deployed on an AWS EC2 instance, allowing for easy access and management of real-time weather data globally.

**Accessing the Deployed Application**
- You can access the live application at: http://13.201.204.129:8080/home
- For Admin Dashboard : http://13.201.204.129:8080/admin/dashboard
   - **Username**: admin
   - **Password**: admin123

<!-- Usage -->
## :eyes: Usage
1. **Admin Operations**: Manage bookings, users, and cars from the admin panel.

2. **User Booking**: Users can browse and book cars.

3. **Navigation**: View and interact with services, about, and contact pages.
<!-- Contributing -->
## :wave: Contributing
  <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" />

Contributions are welcome! Please feel free to submit issues or pull requests.

<!-- License -->
## :warning: License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/Vineet1025/Taxi-Booking-Application/blob/master/LICENSE.md) file for details.


<!-- Contact -->
## :handshake: Contact

Vineet Jain - [LinkedIn](https://www.linkedin.com/in/vineet-jain1025/) - jvineet1025@gmail.com

Project Link: [https://github.com/Vineet1025/Taxi-Booking-Application](https://github.com/Vineet1025/Taxi-Booking-Application)
