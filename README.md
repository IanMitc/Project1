# Project 1

## Expense Reimbursement System (ERS)

The Expense Reimbursement System (ERS) manages the process of reimbursing employees for expenses incurred while on
company time. All employees in the company can login and submit requests for reimbursement and view their past tickets
and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees
in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Techonologies Used
* Hibernate Core version 5.6.1
* MySql version 8.0.27
* MySql Connector Java 8.0.26
* Java 17
* JavaServer Pages
* Javax Servlet API version 4.0.1
* HTML5
* Bootstrap version 4.6.1
* JQuery version 3.5.1
* Tomcat Web Server version 9
* Maven version 3.8.1

## Features
Available features:
* Accessible login forms for home, failed login and logout pages
* Variable navigation bars depending on status of user
* Auto-fill data for expense claims submissions
* Modal window pop-outs for manager memos to expense claim approvals/denials
* Tabular data for easy employee identification as part of the approval/denial process
* Consistent CSS themed styling for business type

To-do list:
* Addition of name specific search and filter to approval denial page
* Addition of search feature to past submissions page

## Getting Started
1. Create a database of your choice - it must be one for which there is an available hibernate dialect
2. Open and modify main/resources/hibernate.cfg.xml properties to point to the preferred database, username, password and dialect of your choice
3. Run main/java/com.revature/Data/initializeDatabase to populate the database with test data
4. Open the database Employee table and select a username and password for at least one Employee and one Manager
5. Install Tomcat 9
6. Start the webserver, open your browser and enter localhost:8080/Project1 in the address bar
7. Alternatively login as Employee and Manager to see the available options


## Usage
* Logging in as an Employee:

    * On the login page enter an appropriate Employee username and password
      ![Screenshot from 2021-12-09 06-13-17](https://user-images.githubusercontent.com/92759483/145387783-87615891-4072-48e3-ac61-e4f0f0ba5421.png)

    * Actions:
        1. To submit a reimbursement claim, fill in the amount and a short memo as to why and hit "Submit"
           ![Screenshot from 2021-12-09 06-15-35](https://user-images.githubusercontent.com/92759483/145387281-412d4ac1-ac11-4188-9d1f-80ef6dd6c98f.png)

        2. To view all past claims, choose Past Submissions on the navigation bar
           ![Screenshot from 2021-12-09 06-18-04](https://user-images.githubusercontent.com/92759483/145387350-22f5e8e0-2372-49f2-a7e6-70d5bb8ed09c.png)

        3. To view pending submissions, choose Pending Submissions on the navigation bar
           ![Screenshot from 2021-12-09 06-19-05](https://user-images.githubusercontent.com/92759483/145387379-1fa93a63-0c2f-4b69-8930-56ec3266258d.png)

        4. Click Logout to log out
           ![Screenshot from 2021-12-09 06-22-30](https://user-images.githubusercontent.com/92759483/145387586-723f4a07-d065-41ef-b594-eb91144c3ff8.png)

* Logging in as a Manager
    * Log in using a designated Manager's username and password

    * Actions:
        1. To approve or deny Employee claims select the appropriate button in the column labelled Approve/Deny
           ![Screenshot from 2021-12-09 06-27-17](https://user-images.githubusercontent.com/92759483/145388292-0fa2fe6b-e785-4bd4-975b-49d03b66f70d.png)

            * Fill in a corresponding memo to identify a reason for approval or denial and click Update Expense Status to update the record
              ![Screenshot from 2021-12-09 06-29-58](https://user-images.githubusercontent.com/92759483/145388715-e4f629b4-9dfc-4698-80f2-1e7808e61312.png)

        2. Click All Past Submissions on the navigation bar to see a complete record of all approved/denied submissions to date
           ![Screenshot from 2021-12-09 06-31-46](https://user-images.githubusercontent.com/92759483/145388903-cac92f80-39f7-41e4-ac38-343eb632f457.png)

        3. As with any other employee, choose Submit Reimbursements, Past Submissions or Pending submissions to see the Manager's own personal record of expense claims or to file a new claim

        4. Click Logout to log out

## Contributors
* Frank Walser - front end and servlet development
* Ian Mitchell - back end JDBC and Hibernate implementation


