This is a sample online BUS Boking system project with very basic bus booking functionality. Developed using Spring boot and JPA.

Database used - MariaDB.



Feature Endpoints:

1. Register user:
http://localhost:8080/user/register POST
Sample request body:
{
	"userEmail":"chandan493@gmail.com",
	"userName":"chandan",
	"userLastName":"ghosh"
}

2. Adding BUS:
http://localhost:8080/bus/addbus/ POST
Sample request body:
{
	"busOrigin":"Bangalore",
	"busDestination":"GOA",
	"noOfSeat":70,
	"busDate":"13-05-2017"
}
3. Search a bus with filters (origin,destination,date,no of seats)
http://localhost:8080/bus/search/Bangalore/GOA/13-05-2017/2 GET

4. Book a bus using bus id found in search
http://localhost:8080/bus/bookBus POST
Sample request body:
{
	"busId":3,
	"userEmailId":"chandan493@gmail.com",
	"journeyDate":"13-05-2017",
	"seats":2
}

5. Get booking details of a user email id
http://localhost:8080/user/bookingDetails POST
Sample request body:
{
	"userEmail":"chandan493@gmail.com"
}




Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.
