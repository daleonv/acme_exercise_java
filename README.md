# Exercise

The company ACME offers their employees the flexibility to work the hours they want. They will pay for the hours worked based on the day of the week and time of day, according to the following table:

Monday - Friday
- 00:01 - 09:00 25 USD
- 09:01 - 18:00 15 USD
- 18:01 - 00:00 20 USD

Saturday and Sunday
- 00:01 - 09:00 30 USD
- 09:01 - 18:00 20 USD
- 18:01 - 00:00 25 USD

The goal of this exercise is to calculate the total that the company has to pay an employee, based on the hours they worked and the times during which they worked. The following abbreviations will be used for entering data:

- MO: Monday
- TU: Tuesday
- WE: Wednesday
- TH: Thursday
- FR: Friday
- SA: Saturday
- SU: Sunday

**Input:** 
The name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our two examples below.

**Output:**
Indicate how much the employee has to be paid.

**For example:**

Case 1:

>** INPUT**
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
**OUTPUT**
The amount to pay RENE is: 215 USD

Case 2:

>** INPUT**
ASTRID =MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
**OUTPUT**
The amount to pay ASTRID is: 85 USD

# Resolution
## General Description
The proposed resolution for the present problem was done in Java.
## Architecture
The architecture applied for this program is an adaptation of the ***controller view model*** architecture, basing the principle of separating the data and mainly what is the business logic from the rest of the components. It is not a complete MVC, because being a console application it does not have a view layer, but the principle is similar. This pattern of software architecture is based on the ideas of code reuse and the separation of concepts, characteristics that seek to facilitate the task of application development and its subsequent maintenance.

![Architecture](https://i.ibb.co/YySxCyh/ioet-1.png "Architecture")
## Approach and methodology
The approach of the application is oriented to the object-oriented programming paradigm (OOP), that is, a model or a programming style that gives us guides on how to work with it. It is based on the concept of classes and objects. This type of programming is used to structure a software program into simple, reusable pieces of code planes (classes) to create individual instances of objects.
Something to highlight of the application is the use of the sigleton or single instance design pattern, which is a design pattern that allows restricting the creation of objects belonging to a class or the value of a type to a single object. 
## Instructions
earring 



# End
