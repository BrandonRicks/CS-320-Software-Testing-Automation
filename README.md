# Summary and Reflections Report

Brandon Ricks

CS 320

Dr. Angel Cross, DIT, MSMIS, CS

Southern New Hampshire University

06/19/21

## Contents

[Summary](#summary)

[Unit Testing Approach](#unit-testing-approach)

[Experience Writing JUnit Tests](#experience-writing-junit-tests)

[Reflection](#reflection)

[Testing Techniques](#testing-techniques)

[Mindset](#mindset)

[References](#references)

## Unit Testing Approach

The software requirements were outlined beforehand, and stated what should happen when certain criteria or circumstances took place. In contact submission, “The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null” is an example of a given requirement. This requirement was met with the code:
```
if (firstName == null || firstName.isEmpty()) {
    this.firstName = "NULL"
else if (firstName.length() > 10) {
    this.firstName = firstName.substring(0, 10)
else {
    this.firstName = firstName;
}
```

This example shows how the requirements given and the code align, and when tested, this requirement is met with both a test for the null and for the length:
```
*@Test*
*@DisplayName*("Contact First Name cannot have more than 10 characters")

void testContactFirstNameWithMoreThanTenCharacters() {
    Contact contact = new Contact("OllyOllyOxenFree", "LastName", "PhoneNumbr", "Address");
    if (contact.getFirstName().length() > 10) {
        *fail*("First Name has more than 10 characters.");
    }
}
    }

*@Test*
*@DisplayName*("Contact First Name shall not be null")

void testContactFirstNameNotNull() {
    Contact contact = new Contact(null, "LastName", "PhoneNumbr", "Address");
    *assertNotNull*(contact.getFirstName(), "First name was null.");
}
```

Each test runs through JUnit, and either completes, has an error, or a test failure. Each test covers the requirements with adding, updating, deleting, and modifying information to the specification of the requirements. In both cases with both programs, all tests ran and completed with no error. It’s important to note that while complete code coverage is no guarantee of errors, it does ensure some trust in a programs functionality (Testing Code Coverage in Eclipse, n.d.).

## Experience Writing JUnit Tests

I believe to be technically sound is to be skillful in making sure your code is both practical and effective. Easy to read formatting, commenting, and keeping code clean and simple are good ways to make create technically sound code. I believe it is also important to comment code in order to properly explain what the code does to others, such as explaining what is expected in constructors, or segregating portions of code for ease of use and readability. An example of this could be the top portion of Task.java, where the constructors for the ID, name, and description are, prior to the getters, as well as the explanation of how IDs are generated:
```
public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;
    private static AtomicLong *idGenerator* = new AtomicLong();

// CONSTRUCTORS
/*
 * Constructor takes task ID, task name, and task description as parameters.
 * All parameters are checked if null or empty. If either exists, the field is filled
 * with the phrase "NULL" to protect data integrity as a placeholder. Task ID is truncated
 * to a maximum of 10 characters, task name to 20 characters, and description to 50 characters.
 *
 */

    public Task(String taskName, String taskDesc) {

        // TASKID
        // Task ID is generated when the constructor is called. It is set as a final variable and has
        // no other getter or setter so there should be no way to change it.
        // The idGenerator is static to prevent duplicates across all tasks.

        this.taskID = String.*valueOf*(*idGenerator*.getAndIncrement());
            
        if (taskName == null \|\| taskName.isEmpty()) {
            this.taskName = "NULL";
        } else if (taskName.length() \> 20) {
            this.taskName = taskName.substring(0, 20);
        } else {
            this.taskName = taskName;
        }
            
        if (taskDesc == null \|\| taskDesc.isEmpty()) {
            this.taskDesc = "NULL";
        } else if (taskDesc.length() \> 50) {
            this.taskDesc = taskDesc.substring(0, 50);
        } else {
            this.taskDesc = taskDesc;
        }
    }
```

This code keeps things simple and neat, effective at meeting its requirements, but not excessive either. The structure of the code is kept neat as well, which is useful if others need to add or modify code in the future.

As another example, this code is meant to update a task name, using the task ID. This task IDs are kept in an array and automatically assigned an ID, so as to not create duplicates. This code gets the requested task with its ID, and then sets the name and updates this String. If it is not found, it notifies this result in the console:
```
public void updateTaskName(String updatedString, String taskID) {
    for (int counter = 0; counter \< taskList.size(); counter++) {
        if (taskList.get(counter).getTaskID().equals(taskID)) {
            taskList.get(counter).setTaskName(updatedString);
            break;
        }
        if (counter == taskList.size() - 1) {
            System.**out**.println("Task ID: " + taskID + " not found.");
        }
    }
}
```

This code does a good job of meeting the requirements needed, while also accounting for possible issues, should the input not be a valid one. This is enhanced by the requirements regarding the maximum length of the name in another portion of code within Task.class:
```
if (taskName == null \|\| taskName.isEmpty()) {
    this.taskName = "NULL";
} else if (taskName.length() \> 20) {
    this.taskName = taskName.substring(0, 20);
} else {
    this.taskName = taskName;
}
```

Efficiency with code is typically in relation to resource use, and efficient code will use less resources for its purpose than inefficient code (Bentley, 1981). As an example of efficiency on the tests coded and ran, code execution and test completion are measured in the hundredths or thousandths of a second, which is a good indication of efficient code:

![image](https://user-images.githubusercontent.com/79807877/191574745-7dad96dc-b727-460b-a532-dfe195f837fb.png)

# Reflection

## Testing Techniques

Objects in each milestone are tested individually to ensure that code functionality exists and works as intended. The results are then displayed in both the console for testing purposes, and shown in JUnit as a pass, fail, or error. An example of a type of test technique used in the milestones would be Equivalence Partition technique. This technique can be used to check that the input condition is within a certain range (Hambling et al, 2015, pg. 87,88). For example, the appointment description character limit of 50:
```
public void setAppointmentDesc(String appointmentDesc) {
    if (appointmentDesc == null \|\| appointmentDesc.isEmpty()) {
        this.appointmentDesc = "NULL";
    } else if (appointmentDesc.length() \> 50) {
        this.appointmentDesc = appointmentDesc.substring(0, 50);
    } else {
        this.appointmentDesc = appointmentDesc;
    }
}
```

This example shows the limit of the description to be a length of 50, after which all other characters will be cut off. EP testing can often be combined with Boundary Value analysis to test within a specified limit, but also test between extreme ends (Rungta, 2020).

There were a few software testing techniques that were not used in milestones as well. Decision Table testing is one such technique, which is primarily used to define functions and the conditions that those functions will operate, as well as any actions that take place, through testing combinations (Hambling et al, 2015). Another example of a technique that was not used during the milestones would be State Transition testing. This technique has a tester test behavior of an Application Under Test, or AUT (Rungta, 2020).

Equivalence Partition technique was used in many of the milestones to test a maximum character limit, such as in descriptions, IDs, and names. These would limit the number of characters, and would be useful in situations where such limits would benefit fitting information properly in a table, or in situations where no limit could be an issue, such as a post on a social media platform.

Boundary Value analysis, as mentioned prior, tests values between two extreme ends. Combining this with Equivalence Partition is often used in situations like password creation to ensure there is a specific character minimum and maximum limit, and character type allowed (Rungta, 2020).

Decision Table testing is a kind of technique can be used to test combinations of conditions and actions, as shown in *Example 4.3* in *Software Testing - An ISTQB-BCS Certified Tester Foundation Guide (3rd Edition)* (Hambling et al, 2015, pg. 92). This example shows the different rules and conditions for a customer at a supermarket, and states the actions when certain condition and rules are combined.

State Transition testing is another technique, and differs from Decision Table testing; where Decision Table testing checks combinations of inputs and conditions to produce actions, State Transition tests changes of state, in which the behavior depends on the transition between a current state and a past state (Hambling et al, 2015, pg. 94). This type of testing is similar to a button press, where something stays on until the button is pressed, changing the state (Hambling et al, 2015, pg. 94). This can be applied to any situation where a change from a past state to a current state causes an event.

## Mindset

According to O’Dell (2017), much of a software developer’s time, 35 to 50 percent, is spent validating and debugging software. With this in mind, a strong mind set to consider adopting would be one of problem solving. Much of testing is about finding and solving problems, and to also work to efficiently mitigate problems before they exist. This preventative approach is useful in a testing environment.

It is important to approach testing with as much importance and efficiency as coding. Approaching debugging as a problem solving exercise can be valuable as an effective learning strategy (O’Dell, 2017), and approaching testing in a similar mindset can do the same. Tests connect directly to their code, and all work together to reach the requirements needed. An example of this would be the connection between a string of a first name in contact required to be a certain number of characters, the code implementing this, and the test for this code ensuring it works effectively to meet these requirements. The code for first name in Contact.java is as follows:
```
if (firstName == null \|\| firstName.isEmpty()) {
    this.firstName = "NULL";
// If first name is longer than 10 characters, just grab the first 10 characters
} else if (firstName.length() \> 10) {
    this.firstName = firstName.substring(0, 10);
} else {
    this.firstName = firstName;
}
```

This code is then tested to ensure it functions, which will meet the requirements given:
```
*@Test*
*@DisplayName*("Contact First Name cannot have more than 10 characters")

void testContactFirstNameWithMoreThanTenCharacters() {
    Contact contact = new Contact("OllyOllyOxenFree", "LastName", "PhoneNumbr", "Address");
    if (contact.getFirstName().length() \> 10) {
        *fail*("First Name has more than 10 characters.");
    }
}
```

When testing your own code, it is important to have as little bias as possible. Being biased towards the effectiveness of your own code may allow an excessive amount of leniency in cutting corners or testing effectiveness. It is important to approach your own code with the same level of constructive critique and importance of functionality as one would of another’s code.

As mentioned by Calikli et al. (2010), it is important to consider failures as much as positive outcomes, and to refrain from confirmation bias. If one does not have the same level of due diligence in testing their own code, it could lead to poor testing, poorly written code, or an overall lack of quality (Calikli et al., 2010).

Being disciplined in your craft is a crucial skill in any situation where consistency and efficiency is valued, as well as following due diligence rules and considerations when working in the field. It is important to not cut corners in writing and testing code, as this can lead to unforeseen consequences, or problems within the development that could have been avoided with best practices and effort. This behavior can even lead to issues that can result in lost time, lost resources, and potentially having to do work over again (Farias, 2018).

I look at developing similarly to how I approach hobbies or skills I have learned or have taught myself. Bad habits can lead to improper learning of a skill, which can then ripple outward into the quality of one’s work. Cutting corners can, ultimately, be a disservice to one’s opportunity to learn a skill appropriately, and apply that skill effectively. I approach in a “measure twice, cut once” sort of mentality; trying to incorporate best practices in coding and testing, checking work, and making efforts to ensure the first attempt is a good attempt. Finding a strong balance of being humble and teachable can open up many opportunities in learning and improving.

# References:

Bentley, J. L. (1981). *Writing Efficient Code.* CARNEGIE-MELLON UNIV PITTSBURGH PA DEPT OF COMPUTER SCIENCE.

Calikli, G., Aslan, B., & Bener, A. (2010). Confirmation Bias in Software Development and Testing: An Analysis of the Effects of Company Size, Experience and Reasoning Skills - Open Research Online. *Open.ac.uk*. <https://doi.org/http://oro.open.ac.uk/45370/1/PPIG2010.pdf>

Farias, H. (2018, July 2). *Where you should never cut corners in software development*. InfoWorld. <https://www.infoworld.com/article/3286265/where-you-should-never-cut-corners-in-software-development.html>

Hambling, Brian Morgan, Peter Samaroo, Angelina Thompson, Geoff Williams, Peter. (2015). Software Testing - An ISTQB-BCS Certified Tester Foundation Guide (3rd Edition) - 4.5.1.3 Other Partitions. (pp. 87,88). BCS The Chartered Institute for IT. Retrieved from <https://app.knovel.com/hotlink/pdf/id:kt00UC2J6V/software-testing-an-istqb/other-partitions>

O’Dell, D. H. (2017). *The Debugging Mindset: Understanding the psychology of learning strategies leads to effective problem-solving skills.: Queue: Vol 15, No 1*. Queue. Retrieved from <https://dl.acm.org/doi/10.1145/3055301.3068754>

Rungta, K. (2020). *Software Testing Techniques with Test Case Design Examples*. Guru99.com; Guru99. Retrieved from <https://www.guru99.com/software-testing-techniques.html>

*Testing Code Coverage in Eclipse*. (n.d.). Cornell. Retrieved May 30, 2021, from <https://www.cs.cornell.edu/courses/JavaAndDS/files/codeCoverage.pdf>
