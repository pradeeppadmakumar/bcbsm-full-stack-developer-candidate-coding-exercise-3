# BCBSM Full Stack Developer Candidate Coding Exercise
  
## Requirements:
1.	Create a single page web application with a login screen (username, password)
2.	Demonstrate user login and authentication/authorization using Spring WebSecurity with USER and ADMIN roles
3.	Upon login as a USER present the user with the ability to submit feedback with a number rating and a comment. User must be logged in to access this page
4.	Upon login for ADMIN users show the feedback of all users
5.	regular users should only be able to see their feedback. Admin users should be able to see all feedback
6.	Create a REST service to receive the feedback form input and store in a database with the below structure:  
    a.  rating_value    
    b.  comment  
    c.  user  
    d.  date  
7.	Display success message on web page and show the feedback entered. If any error show the error message as well.
8.	Fork this repository and we will review your code from the fork.
9.  Mandatory to provide a code and workable application walk through 

## Tech Stack:  
Springboot  
Angular/NextJS/ReactJS  
MongoDB/MySql


# Pradeep Padmakumar (developer notes):
frontend implementation is in folder : frontend-event-service

default users available:

username : admin  
password: admin  
role: admin  


username : pradeep  
password: pradeep  
role: user  

username : user1  
password: user1Password  
role: user  

username : user2  
password: user2Password  
role: user  


#Curl commands

1.  Register user   
        curl --location --request POST 'localhost:8080/auth/register' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "username": "newuser",
        "password": "samplePassword",
        "name": "new user",
        "email": "new.user@demo.com"
        }'
2.  Login user (use username and password from above)  
    curl --location --request POST 'localhost:8080/auth/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "username": "newuser",
    "password": "samplePassword"
    }'
3.  Get All events details
    curl --location --request GET 'localhost:8080/api/v1/event/' \
    --header 'Authorization: Bearer <jwt token from the login response>'
4.  Get event details by event ID
    curl --location --request GET 'localhost:8080/api/v1/event/1' \
    --header 'Origin: http://localhost:4200' \
    --header 'Authorization: Bearer <jwt token from the login response>'
5. Create Feedback by User
   curl --location --request POST 'localhost:8080/api/v1/user/6/event/2/feedback' \
   --header 'Authorization: Bearer  <USER jwt token from the login response>' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "comment": "Great Experience!!!",
   "rating": 5
   }'
6. Get Feedback for User
   curl --location --request GET 'localhost:8080/api/v1/user/6/event/2/feedback' \
   --header 'Authorization: Bearer <USER jwt token from the login response>'
7. Get All Feedbacks for Event by Admin
   curl --location --request GET 'localhost:8080/api/v1/admin/1/event/2/feedback' \
   --header 'Authorization: Bearer <ADMIN jwt token from the login response>'
   