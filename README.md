# FastSpring-Pizza-Challenge
### Akshay Sadarangani
This is a two day attempt at implementing a RESTful API solution for a pizza management system using Spring. The project is by no means production level as it lacks some validations (while some others being covered) and in the essence of time contains only the skeleton. The project is however developed with flexibility and extension in mind and can be easily extended or modified without breaking other parts of the code.

## Running the application
LOCAL ENVIRONMENT

Download the project and browse to the root folder in the terminal and type the following command (requires Maven)

>$ mvn spring-boot:run

HOSTED ENVIRONMENT

Alternatively, use the follwing AWS link for a hosted environment

[AWS](http://fastspringpizza-env.hpcfvibs88.us-west-2.elasticbeanstalk.com)

## Tech Details
[Click here](https://github.com/aksh4y/FastSpring-Pizza-Challenge/blob/master/Tech%20Doc.MD) to check out the tech document detailing some of the tech and design details of the project.

## Example Usage
The following demonstrates creating a Customer with a Phone and Address, a Store Manager, a Store, a Promotional Deal, a Pizza of Small Size, Hand Tossed Base, Marinara Sauce, Cheddar Cheese and Bacon and Ham as Toppings, and finally a PizzaOrder between the Customer and the Store making use of the Promotional Code.

### Customer
> POST /api/Customer/
```json
{
  "firstName": "Alice",
  "lastName": "Wonderland",
  "username": "alice",
  "password": "alice",
  "email": "alice@wonderland.com",
  "dob": "1992-11-27"
}
```
### Address
> POST /api/Address/
```json
{
  "street1": "360 Huntington Ave",
  "street2": "Apt 57",
  "city": "Boston",
  "State": "MA",
  "zipcode": "02115",
  "person_id": 1
}
```
### Phone
>POST /api/Phone/
```json
{
  "number": "8570000000",
  "person_id": 1
}
```
### Store Manager
>POST /api/storeManager/
```json
{
  "firstName": "Bob",
  "lastName": "Marley",
  "username": "bob",
  "password": "bob",
  "email": "bob@marley.com",
  "dob": "1992-11-27"
}
```
### Store
>POST /api/store/
```json
{
  "name": "California Pizza Kitchen"
}
```
Let's associate our store manager with this store with ID 3 and manager ID 2
>PUT /api/store/3/manager/2
### Promo
The promo code is automatically generated and is unique and has a default value for a column "used" which we use to make sure the code is used only once
>POST /api/promo/
```json
{
  "discount_percent": 10,
  "expiration": "2018-11-21"
}
```
We will associate the promo with a storeId
Promo code generated = de491ea8-c419-4a19-a6ea-8e0d85604ea3
StoreId = 3
>PUT /api/promo/de491ea8-c419-4a19-a6ea-8e0d85604ea3/store/3

This associates the above created promo code with store ID 3
### Pizza
We already have the Size, Base, Sauce, Cheese and Toppings in the database so we'll not show the creation in this example. 
Important thing to note is each of them are an entity of their own and have their own DAOs and Repositories so as to have flexibility with future changes in mind. They have the same fields in this example: type, quantity, price

>POST /api/pizza/

A Pizza instance is created in the database and a pizzaId is created (let's say 1)
All we need to do now is a bunch of PUT requests to update the pizza instance with the respective IDs of the Base, Size, Sauce, Cheese and Toppings. If any of these lack in quantity, the object will fail to update and return a null.
Ideally we will not show the entities in the frontend if their quantities are not available i.e. they are out of stock 

>PUT /api/pizza/1/base/2

>PUT /api/pizza/1/size/3

>PUT /api/pizza/1/cheese/2

>PUT /api/pizza/1/sauce/1

>PUT /api/pizza/1/topping/6

>PUT /api/pizza/1/topping/8

### Pizza Order
Now we have a Customer, a Store, a Store Manager for the Store, a Promo for the Store, and a Pizza (ideally created on the client side during order placing). Now, we create an order out of these and then apply the promo code to get a discount

Create an instance of a pizza order
>POST /api/order

Link the order with a store, customer and pizza (if any of these fail validations, the order will not go through
>PUT /api/order/2/store/1/customer/5/pizza/1

We now have all of our entities linked and say the total price (which is an auto-calculated object) is 15. Now let's apply the promo code
>PUT /api/order/2/promo/de491ea8-c419-4a19-a6ea-8e0d85604ea3

TOTAL PRICE = 13.5

