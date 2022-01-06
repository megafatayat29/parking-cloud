CONTENTS OF THIS FILE
---------------------

* Introduction
* Requirements
* Installation
* Configuration
* Maintainers

INTRODUCTION
------------

ParkirAJA-Boot is an parking cloud application which is a product of the start-up ParkirAJA Group.
In this application you can register your own parking lot to start rent your parking space.
To register a parking lot on ParkirAJA-Boot you need to prepare several registration data,
there are: Name, Address, Area, Capacity, Category and Hourly Parking Fee.

## Prerequisites

* [Oracle JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

## Installation

Use the package manager [maven](https://maven.apache.org/) to install and build Shopaa app.

```bash
mvn clean install
```

running apps

```bash
java -jar target/parkiraja-0.0.1-SNAPSHOT.jar
```

## API

####Parking Lot
1. GET
* Get Parking Lot By Id

``GET: http://localhost:8081/parkingLot/{id}``

  => This API returns all information of Parking Lot and number of vehicles currently parked 
  in the parking lot, with the given String of Parking Lot id from PathVariable. 

* Get Vehicles By Parking Lot Id

``GET: http://localhost:8081/parkingLot/{id}/vehicles``

=> This API returns list of vehicle which is currently parked in Parking Lot 
with the given String of Parking Lot Id from PathVariable.

2. POST
* Create Parking Lot

``POST: http://localhost:8081/parkingLot``

  => This API returns the Parking Lot entity that was created. Need RequestBody of Parking Lot without id.
  Area is the parking area in square meters. Capacity is the capacity of vehicles that can be parked in the parking lot.
  Category is the category of vehicles that can be parked in the parking lot.

####
Request body:

```json
{
  "name": "All You Can Parked",
  "address": "Jl. Semua",
  "area": 1000000,
  "capacity": 150,
  "category": "All",
  "hourlyParkingFee": 13000
}
```

3. DELETE
* Exit Vehicle From Parking Lot  

``DELETE: http://localhost:8081/parkingLot/{parkingLotId}/vehicles?vehicleId=value``

  => This API returns Integer total bill of vehicle, with the given String of Parking Lot Id from PathVariable
  and need RequestParam String vehicleId of Vehicle you want to exit from parking lot.

####Vehicle
1. POST
* Create Vehicle 

``POST: http://localhost:8081/vehicle``

  => This API returns the Vehicle entity that was created. Need RequestBody of Vehicle without id.
  Vehicles can only be parked in the parking lot with categories according to the type of vehicle. 
  The "All" category in parking lot can accept both motorcycles and cars.

####
Request body:

```json
{
  "plateNumber": "Q 6666 RX",
  "type": "Motorcycle",
  "parkingLotId": "8a8ab2a07c1baa83017c1baf2da40004"
}
```

## Support

Further information email me : [megafatayat9@gmail.com]()

## License

[Apache Software Foundation](https://www.apache.org/licenses/LICENSE-2.0)