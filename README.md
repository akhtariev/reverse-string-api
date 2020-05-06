# reverse-string-api
An api made with SpringBoot that supports a single get request to reverse a given string

To run:
`./mvnw spring-boot:run`

Then, `localhost:8080/reverse/<string>` will provide the reversed string


### Thought process:
1. Read about SpringBoot and Maven more in depth
2. Decided to choose VS Code instead of an IDE
3. Installed all the required frameworks: JDK, Maven, VS Code extensions
4. Set up system environment variables
5. Followed the tutorial on the SpringBoot website
6. Realized that the tutorial has some additional functionality that this app does not need
7. Found a simpler example and refactored the base of the app
8. Wrote basic tests
9. Implemented the actual "reverse string" functionality
10. Tested, fixed minor bugs and made minor desing changes, the requirement for which was discovered after running the tests.
11. Wrote additional tests which passed right away
12. Tested with Postman

### Challenges:
- Using Java after mostly working with C++ and JavaScript in the past year.
- Familiarizing myself with the new frameworks: SpringBoot, Maven
- Installing everything in VS Code. Prior to that I mainly used Intellij for Java but since I didn't have it installed on my personal machine, I decided to learn how it works in the new environment.

### Design and implementation choices:

##### Using TDD-like approach
I decided to first write the tests and then implement the reversing functionality. Although I knew one of the most optimal solutions from doing Leetcode,
I was surprised to see half of my tests failing after running them for the first time. Working in a TDD-like approach probably helped.

##### Edge case handling
I discovered that if no string is supplied after the `localhost:8080/reverse/`, 404 is returned by default so it should be impossible for 
the `toReverse` string in the code to be of length 0 but decided to handle that case as a sanity check

Returning bad request (400) when the string consists of white spaces

Supporting both non-alphanumeric and alpahnumeric characters

Supporting trailing white spaces (not trimming)

### Notes

Apparently, applications such as Postman trim whitespaces at the end so testing some cases of this API with this application is not possible.
