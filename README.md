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
-  **INPUT**
-  RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
-  **OUTPUT**
-  The amount to pay RENE is: 215 USD

------------
Case 2:
-  **INPUT**
-  ASTRID =MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
-  **OUTPUT**
-  The amount to pay ASTRID is: 85 USD
------------

# Resolution
## General Description
The language proposed for the resolution of this problem was java, due to the simplicity of its syntax and its high performance.
The solution to the problem consists in the first instance in reading the content of the .txt file. The next step is the validation of the data entered, to avoid later problems during compilation. With the validated String, the decomposition of its content was carried out in the name of the employee and in an arrangement that contained the days and hours of work. Subsequently, a two-dimensional arrangement was created that contained the information of hours and days for its treatment in individual portions. Finally, the two-dimensional arrangement was run with repetitive cycles to make the necessary comparisons and thus be able to determine the rate to pay. For the comparison, we simply used conditional if statements. Finally the result was stored in variables to later be read and printed on the console. The following graphic shows the solution for better understanding.

![Solution](https://i.ibb.co/kS9Qwhx/Untitled-Diagram-10.png "Solution")
## Architecture
The architecture applied for this program is an adaptation of the ***controller view model*** architecture, basing the principle of separating the data and mainly what is the business logic from the rest of the components. It is not a complete MVC, because being a console application it does not have a view layer, but the principle is similar. This pattern of software architecture is based on the ideas of code reuse and the separation of concepts, characteristics that seek to facilitate the task of application development and its subsequent maintenance.

![Architecture](https://i.ibb.co/YySxCyh/ioet-1.png "Architecture")
## Approach and methodology
The approach of the application is oriented to the object-oriented programming paradigm (OOP), that is, a model or a programming style that gives us guides on how to work with it. It is based on the concept of classes and objects. This type of programming is used to structure a software program into simple, reusable pieces of code planes (classes) to create individual instances of objects.
Something to highlight of the application is the use of the sigleton or single instance design pattern, which is a design pattern that allows restricting the creation of objects belonging to a class or the value of a type to a single object.
Currently, development tools such as NetBeans and Eclipse have plugins that allow the automatic generation of the necessary templates for the automatic creation of unit tests, making it easier to focus on the test and the expected result. For this particular case, Junit 4 was used to perform unit tests.

Unit tests are intended to test the correct behavior of classes in isolation; this means that the class is tested by isolating it from its interaction with other classes.

FIRST principles were considered for writing unit tests

- F: Fast, the tests have to be executed quickly.
- I: Isolated, the tests are carried out on a class without interaction with others.
- R: Repeatable, the order of execution of the tests should not influence the final result.
- S: Self-validating, the tests must be executed automatically.
- T: Timely, they have to be created at the same time as the software being created. ¡
## Instructions
Inside the solution there is a file called "example1.txt". Inside this file you must place the input string, necessary for the execution of the program.

To run the program on your local computer, you will need to have a Java compiler installed. This comes with the Java Development Kit, or JDK. It is an essential tool for Java development on any platform. The JDK is not the same as the Java Runtime Environment, or JRE, that you will already have installed if you have ever used a Java application on your computer.

The easiest way to run the program is by using an integrated development environment (IDE) that provides compilation tools. There are several IDE examples that can be used: NetBeans, IntelliJ IDEA, Ecplise, among others.

Another method for running the program is using the command prompt. This method is more complex to execute, but I am attaching a link that carefully shows the steps to follow.
[How to compile a java program in CMD](https://www.skylit.com/javamethods/faqs/javaindos.html)

# End
