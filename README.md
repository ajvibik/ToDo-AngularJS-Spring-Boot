<b>Spring Boot, MongoDB, Angular Restful API</b><br>

<strong>Requirements</strong><br>
Java - 1.8.x<br>
Angular 1.6.x<br>
Maven - 3.x.x<br>
MongoDB - 3.x.x<br>

<strong>Steps to Setup</strong><br>

1. Run the mongodb<br>

2. Clone the application<br>

     git clone https://github.com/ajvibik/ToDo-Application.git<br>

3. Build and run the backend app using maven<br>

    cd back-end<br>
    mvn package<br><br>
    java -jar target/ToDoApplication-0.0.1-SNAPSHOT.jar<br>
    Alternatively, you can run the app without packaging it using -<br>

    mvn spring-boot:run<br>
    The backend server will start at http://localhost:8080.<br>

4. Open the front-end folder and run the home.html file.<br>
