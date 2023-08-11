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
password: pradeepPadmakumar  
role: user  

username : user1  
password: user1Password  
role: user  

username : user2  
password: user2Password  
role: user  