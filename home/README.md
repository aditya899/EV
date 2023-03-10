Restful API
RESTful API for CRUD operations, developed with Spring Boot in Java.

Function
Six RESTful APIs for the Game Store web application.

API	Description	URL
GET /ElectricStation	Get all products	GET http://127.0.0.1:8080/ElectricStation/
GET /ElectricStation/show/{station_id}	Get a product by ID	GET http://127.0.0.1:8080/ElectricStation/show/1
POST /ElectricStation/save	Add a new product	POST http://127.0.0.1:8080/ElectricStation/save
PUT /ElectricStation/edit/{station_id}	Update a product	PUT http://127.0.0.1:8080/ElectricStation/edit/1
DELETE /ElectricStation/delete/{station_id}	Delete a product	DELETE http://127.0.0.1:8080/ElectricStation/delete/1
POST /ElectricStation/api/upload	Upload an image	POST http://127.0.0.1:8080/ElectricStation/api/upload


Setup Locally
mvn spring-boot:run

Access http://127.0.0.1:8080/ElectricStation/ in web browser or PostMan, you should get the following JSON as response.

[
    {
        "station_id": 2,
        "stationName": "MG Road",
        "stationImage": "http://127.0.0.1:8080/ElectricStationhttps://tinyurl.com/vt6ymemk",
        "stationPrice": 20,
        "stationAddress": "MG Road, Bangalore"
    },
    {
        "station_id": 3,
        "stationName": "Bangalore",
        "stationImage": "http://127.0.0.1:8080/ElectricStationhttps://tinyurl.com/vt6ymemk",
        "stationPrice": 10,
        "stationAddress": "Marathahalli, Bangalore"
    }
]