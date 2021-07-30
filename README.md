<img alt="cool logo" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/main/LBL-Logo-01.svg">

LBL Trucking Company sells fleets of Trucks to large companies all over the world. They need a new CRM system to manage prospective and live customers.


Use and Class Diagrams
==========================

<img alt="use diagram" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/main/Use%20diagram%20LBL.png">

The use diagram reflects the project from the Sales Associate's perspective, defined as the primary user of the CRM system.
The functionality of the system is presented in the diagram below.

<img alt="class diagram" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/main/Class_diagram_LBL-Page-1.png">

Menu and Commands
==========================

<img alt="menu screenshot" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/Natalia/Screenshots/menu%20screen.png">

The menu provides instructions for using the system and covers a number of important requirements:
1. Track Leads, Opportunities and Accounts;
2. Convert Leads into Opportunities;
3. Associate an Opportunity with an Account.
4. Associate Contacts with an Opportunity.

Information Display
==========================

<img alt="information display example" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/Natalia/Screenshots/output%20screen.png">

Our uniform UI throught allows the user to easily find and understand information. 
We also introduced various colours to allow the user to separate blocks of information from one another. 
For example, all error methods are displayed in red colour.

Input Validation
==========================

In addition to the core search functionality, a number of input validations has been introduced to ensure correct and uniform input. 
Email, name and city inputs need to follow specific pattern.
Country input is checked against the *ISO list of countries* (in English only for simplicity and uniform input). 
Product, status and industry are checked against a set list of options organised in enums.
Think of this as a *'drop down'* list implemented in a console.
What's more, we don't let users go wild and put all sorts of things in our beautiful CRM. You'll be told off until you stop joking around.

How to
==========================

Firstly, you will need to log on. If you want to have full functionality, use ***Admin*** as username and ***admin*** as password.
Alternatively, if you just want to have a little nosey, you can use username ***Guest*** and password ***guest***. 
The *guest* access will allow you to view things but won't allow you to change anything. We don't want random curiosity mess up our CRM :P

<img alt="login screenshot" src="https://github.com/EN-IH-WDPT-JUN21/Stolen-Name-LBL-Trucking-Company-Homework-2/blob/Natalia/Screenshots/login%20screen.png">

Please, pay attention dual screen users! The login window tends to pop up in the second screen...
In addition, all peer reviewers will receive their own login details (*we love to please those in power!*).

**The code** is split in various sections, with the main chunk of code being in the **MainMenu**. Exceptions are handled in each class as well as in the MainMenu. A number of tests has been created to test inputs, validations and methods.

***Enjoy!***
