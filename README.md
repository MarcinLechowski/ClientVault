# ClientVault

ClientVault is a web application designed for managing clients. The program allows you to create, edit, view, and delete client data in an easy and intuitive way.

Note: This program is currently under development.

Features

Home Page: A user-friendly starting interface available at /.

Add Client: A form for adding new client data available at /new.

Client List: A view displaying all clients available at /clients.

Client Details: Detailed information about a specific client available at /clients/{id}.

Update Client: Ability to edit client data through an update form.

Requirements

Java 17+

Maven

Spring Boot 3.x

Database (e.g., H2, MySQL, PostgreSQL - depending on application configuration)

Installation

Clone the repository:

git clone https://github.com/your-account/ClientVault.git
cd ClientVault

Build the project using Maven:

mvn clean install

Run the application:

mvn spring-boot:run

Open your browser and navigate to:

http://localhost:8080

Application Structure

Controller: ClientController

The controller handles HTTP requests and manages the data flow in the application.

@GetMapping("/"): Renders the home page.

@GetMapping("/new"): Displays the form for adding a new client.

@PostMapping("/new"): Handles saving a new client.

@GetMapping("/clients"): Displays the client list.

@GetMapping("/clients/{id}"): Displays the details of a specific client.

@PostMapping("/clients/update"): Handles updating client data.

Example Client Data

{
  "id": 1,
  "name": "John Doe",
  "country": "USA",
  "goodsHeBuy": "Electronics",
  "goodsHeSell": "Home Appliances",
  "creditLimit": 50000,
  "acceptedPrice": 45000,
  "offeredPrice": 47000,
  "contact": "john.doe@example.com",
  "info": "Regular client."
}

Logging

The application uses the Lombok library and the @Slf4j logging mechanism to:

Log successes (e.g., adding a new client).

Log errors (e.g., attempting to edit a non-existent client).

