# Parcel Delivery System

Java project that simulates a parcel delivery service.

## Features

- Different parcel types
- Parcel tracking interface
- Parcel boxes with weight limits
- Generics usage
- Unit tests

## Project Structure

src/main/java/delivery

app  
- DeliveryApp

model  
- Parcel  
- StandardParcel  
- FragileParcel  
- PerishableParcel  
- ParcelBox  

interfaces  
- Trackable

src/test/java/delivery/tests

- ParcelBoxTest
- ParcelCostTest
- PerishableParcelTest

## Technologies

- Java
- OOP
- Generics
- JUnit
- Git

## Example

```java
ParcelBox<StandardParcel> box = new ParcelBox<>(10);

StandardParcel parcel =
    new StandardParcel("Book", 5, "Vienna", 1);

box.addParcel(parcel);
