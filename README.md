# Koombea - Technical Test


  # About the project


Features
- As a user, I must be able to register on the platform. For this, it will only be
necessary to enter a username and password.
- As a user, I must be able to log into the system using an email and a password.
- As a user, I should be able to see a list of all the pages that I have scrapped with
the number of links that the scraper found.
- As a user, I should be able to see the details of all the links of a particular page,
that means the url of a link and the “name” of a link.
- As a user I should be able to add a url and the system should be able to check
for all the links and add it to the database. A link will have the following format
<a href="https://www.w3schools.com"> Visit W3Schools.com! </a> the href will
be the link and the body will be the name of the link. Keep in mind that the
body of a link sometimes is not only text and could be other html elements, in
those cases you could save only a portion of the html. The title of the web page
will be the page name. Keep in mind that some pages will take more time than
others to scrape.

Nice to have:
- Pagination in the list of pages and the list of links
- As a user, when I see the list of pages, I should be able to see the ones that are
currently being processed.


# Technologies used
## Backend
- Java 17
- Spring Boot 3
- JPA / Hibernate
- Maven
- Open API 2.2.0


Prerequisites: 
- Java 17
- Spring Boot 3
- Swagger: http://localhost:8080/swagger-ui/index.html#/


  
```bash
# Github repository
git clone https://github.com/crynusdrum/koombea.git

# get into project folder
cd koombea

# run the project
./mvnw spring-boot:run
```


```

# Autor

Thiago Baldês

