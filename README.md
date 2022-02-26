# Project1

Reimbursement Request &amp; Email APIs. This app allows employees to submit reimbursement requests that their manager can then view, accept, or deny.

## Technologies Used

- Java 1.8
- Spring Framework 2.6.3
- Spring Data
- Postgresql
- Mockito 4.2.0
- Project Lombok
- JUnit 4.12
- Log4j 1.8.0
- JavaDocs
- Docker

## Features

- View all requests by employee
- View all reimbursements by manager
- Employee can submit request given their

To-do list:

- Allow Managers to accept and deny requests
- Employees should be notified by email for an accepted or denied request

## Getting Started

1.  git clone https://github.com/cphall/Project1.git
2.  Download and install Insomnia and IntelliJ or IDE of your choice.
3.  Setup a GCP database instance. Smallest available is fine.
4.  Configure Insomnia for the proper requests and request URL
    - POST: Employee Request: http://localhost:8080/request/createRequest
      - {
        "email": "pwnfest7@gmail.com",
        "cost": 777.99,
        "status": "Requested",
        "expenseDate": "2/18/2022"
        }
    - GET: Get All Requests: http://localhost:8080/request/getAllRequests/pwnfest7@gmail.com
    - GET: Get All Expenses: http://localhost:8080/expense/getAllExp/1
      - 1 at the end of the URL is the manager id. Currently there is only one.
    - GET: Get Expense By Employee: http://localhost:8080/expense/getExpByEmployee/2
      - 2 at the end of the URL is the employee id. There are currently multiple.
5.  Download Dbeaver and connect to GCP instance.
6.  Add SQL script "Script-1" to Dbeaver and run it.
7.  Run both APIs within the IDE.

## Usage

You are now ready to use Insomnia, sending requests and inputting information for the employee request. Note: the email you supply in the employee request will be where the confirmation email will be sent.
