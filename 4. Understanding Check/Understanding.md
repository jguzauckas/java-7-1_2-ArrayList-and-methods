# Understanding Check

We are going to make a grade calculator for this class. Your grade is calculated as 20% practice assignments and 80% assessments. All practice assignments are out of `10` points, quizzes out of `12` points, and tests/projects out of `40` points.

Using the `Scanner` class, we are going to have the user enter their scores on various assignments and calculate their class grade for them.

First, have the `Scanner` ask for how many practice assignments they will enter. Then, create an array to store that many practice assignments.

Using a loop, ask the user to enter each practice assignment grade (they just enter the number of points, since we know it is out of `10`), saving each of them to the elements of the array.

Second, have the `Scanner` ask for how many quizzes they will enter. Then, create an array to store that many quizzes.

Using a loop, ask the user to enter each quiz grade (they just enter the number of points, since we know it is out of `12`), saving each of them to the elements of the array.

Third, have the `Scanner` ask for how many tests/projects they will enter. Then, create an array to store that many tests/projects.

Using a loop, ask the user to enter each tests/projects (they just enter the number of points, since we know it is out of `40`), saving each of them to the elements of the array.

Now, calculate the total grade on practice assignments. This can be done by adding each practice assignment up and dividing by the number of practice assignments multiplied by `10` (watch for double division and order of operations here). Example: `24 / (3 * 10)`

Then, calculate the total grade on assessments. This can be done by adding up all the quizzes and tests/projects and dividing by the number of quizzes multiplied by `12` plus the number of tests/projects multiplied by `40` (watch for double division and order of operations here). Example: `59 / (1 * 12 + 2 * 40)`

Finally, multiply the practice assignment grade by `0.2` and multiply the assessment grade by `0.8`, and add them together to get your final grade! Example: `0.2 * 0.8 + 0.8 * 0.64`

Here is a sample output of the program:

```
How many practice assignments?
3

Enter practice assignment grade:
8

Enter practice assignment grade:
6

Enter practice assignment grade:
10

How many quizzes?
1

Enter quiz grade:
8

How many tests/projects?
2

Enter test/project grade:
21

Enter test/project grade:
30

Your grade is 67.30%
```

This could change drastically by entering more/fewer of each type of assignment. It should be handling that dynamically!

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.
