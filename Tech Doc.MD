# Tech Documentaion

## Project Structure

/

|--Daos

|--Repositories

|--Entities

&nbsp;&nbsp;|--Pizza

## Entities
Person

|--Customer

|--Store Manager

Address

Phone

Store

Promo

PizzaOrder

Piza

|--Cheese

|--Sauce

|--Size

|--Base

|--Topping

## General API Pattern
GET /api/entity

POST /api/entity

GET /api/entity/id

PUT /api/entity/id

DELETE /api/entity/id

## Strategies Used
* The Single Table per class hierarchy strategy for the database
* /api trailing convention for RESTful APIs
* Multiple OneToOne, OneToMany, ManyToOne and ManyToMany relationships making use of joined tables wherever necessary and defining suitable column aliases
* Code structured into "Entities", "Daos" and "Repositories"

## Challenges Faced
Time: To implement a full fledged tested system in 2 days turned out to be very challenging. This is the reason we try and give the client a release date which falls after the testing phase and try to keep as much testing time as possible.
