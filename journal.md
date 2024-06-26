## Indie Fitness App Project
*A weekly journal going over the changes and activities done while creating and researching the Fitness app.*

### Journal 1, 1/21-28/2024
I started getting the files and folders set up for the project.
As well as thinking about what to have the project be about and all do.
    <br><br>
### Journal 2, 1/29/2024 - 2/4/2024
I have a pretty decent idea of what I plan to make as well as some APIs I might use.
I added a sketch of quick wireframe I made for the website.
Three APIs I was thinking about using are
[ExerciseDB](https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb/)
& [Fitness Calculator](https://rapidapi.com/malaaddincelik/api/fitness-calculator/)
& [Exercises API-Ninjas](https://rapidapi.com/apininjas/api/exercises-by-api-ninjas/)
from [RapidAPI](https://rapidapi.com/search/fitness) for calculating the health totals as well as creating the exercises.
    <br><br>
### Journal 3, 2/5-12/2024
Looked into which HTTP client to use for connecting to APIs. Decided to go with OkHttpClient after reading a stack overflow [post](https://stackoverflow.com/questions/42392778/okhttp-or-httpclient-which-offers-better-functionality-and-more-efficiency) & [article](https://www.wiremock.io/post/java-http-client-comparison) by WireMock.
While creating my JSP pages I looked at this [site](https://www.freecodecamp.org/news/how-to-keep-your-footer-where-it-belongs-59c6aa05c59c/) to help set up my footer CSS.
Overall for this week I created the basic display JSPs and layouts for other files to be easily added as well as all the dependencies to the `pom.xml`.
I also searched which package to use for json files I decided to go with `org.json` because
[geeksforgeeks](https://www.geeksforgeeks.org/parse-json-java/)
& [tutorialspoint](https://www.tutorialspoint.com/how-can-we-read-a-json-file-in-java)
& [baeldung](https://www.baeldung.com/java-org-json)
all had tutorials going over how to use it.

My biggest trouble was getting the json files from the API into a map, I used a Stack Overflow
[article](https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java)
for help.

I ended up finding a different Stack Overflow
[article](https://stackoverflow.com/questions/443499/convert-json-to-map)
& a Baeldung [article](https://www.baeldung.com/java-json-maps-comparison)
which made putting the json in a map a lot easier, put I couldn't figure out how to still reverse the map order while in the list.

A problem I have been having it that when I change my CSS style sheet it doesn't update in the war, so it does not change for a while.

Using hibernate with foreign keys I used this [article](https://www.baeldung.com/hibernate-one-to-many) by Baeldung.
    <br><br>
### Journal 4, 2/12-18/2024
I plan on using a different API for health calculations as it offers 7 different kinds and seems less complicated for storing. 
[Mega Fitness Calculator.](https://rapidapi.com/bejjaothmane/api/mega-fitness-calculator1/) 
But because of switching I had to rewrite my SQL table creation scripts and DAOs a little.

I made the screen design as a storyboard, flowchart, and screen design so that it would cover 
the aspects of what a user would do. I also made the user stories more clear. 
I did get as much done as I was having a few problems I couldn't figure out.
    <br><br>
### Journal 5, 2/19-25/2024
I figured out most of the problems I was having. 
By changing the import I was using for hibernate annotation too `Jakarda`.
I also got most of my unit test to pass with the user profiles, record tables, and an API result.
    <br><br>
### Journal 6, 2/26/2024 - 3/3/2024
I didn't get much done for the week I felt pretty sick.
    <br><br>
### Journal 7, 3/4-10/2024
I made a servlet page to and jsp page to test displaying all the users. 
I also uploaded the war file to an AWS environment successfully.

I tried thinking of a way to combine by unit tests for the record classes, 
but I thought it was just simpler to have the 4 classes for unit testing the records.

I asked ChatGPT for a name for a fitness app and one of the recommendations was FitGenie (or GenieFit). 
Which I liked because creating the exercises is kind of like asking a genie a question.

I spent most of my time making the class and jsp page for the health calculations and allowing them to be null/empty.
   <br><br>
### Journal 8, 3/11-17/2024
I found this API from API-Ninjas which could be useful for tracking nutrition values
[Nutrition API-Ninjas](https://rapidapi.com/apininjas/api/nutrition-by-api-ninjas).

I fixed the coverage results problem I was having for my unit tests. 
I also got the unit tests my calculation formulas to be 100%.
    <br><br>
### Journal 9, 3/18-24/2024
Spring Break

I added a package for REST URLs to be used/available, currently only gets all the users.
But this helped me with allowing a user to download a json of their account information.

I read this [article](https://www.baeldung.com/jackson-object-mapper-tutorial)
by Baeldung & this [article](https://mkyong.com/java/how-to-download-file-from-website-java-jsp/)
by Mkyong for using jackson to download a json file. 
    <br><br>
### Journal 10, 3/25-31/2024
I changed the way jackson mapped the API Ninjas response so that it would return a list of objects.

I set up AWS Cognito and Beanstalk for the project and added the files that go with them. 
I made a servlet for linking to the sign-up form based off the login servlet.
I made another servlet for signing out which just removes the current user's attribute.

I generated logo for GenieFit using Copilot.

I didn't get as much done this week because I was having a few problems with AWS.
    <br><br>
### Journal 11, 4/1-7/2024
This week I mostly focused on improving a lot of my css. 

I also created the SignOutServlet to allow a user to sign out.
    <br><br>

### Journal 12, 4/8-14/2024
I created jsp pages and servlets linking to them for editing a users account and record input, 
deleting a record, or adding a new record. So I made four jsps and servlets. 
As well as classes to process a delete record, add record, or update account operations on the database.
    <br><br>

### Journal 13, 4/15-21/2024
I refactored and reviewed a lot of the code I had to see where I could remove code duplication.

Some areas where I refactored was in the IndexServlet and UpdateUserAccount by having them 
implement the RecentRecordLoader interface to call loadRecentRecords() for the most recent records.
    <br><br>

### Journal 14, 4/22-28/2024
I created generic method in DeleteRecord and AccountInsertUpdate where the generic
type is the record classes, the method is also what triggers the operation in the database.

I also added an interface for my API classes to use to generate a response.
    <br><br>

### Journal 15, 4/29 - 5/5 2024
I updated a lot of the CSS styles and the way the jsp were display.
    <br><br>

### Journal 16, 5/7/2024
I recorded the video for the project.
    <br><br>