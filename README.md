# Library-Management-System
Spring Boot Application with AngularJS to implement Book issue, return and display book history

Books are stored on a shelf, based on the genre. Some sample genres are : Romance, Fiction, Non-Fiction, Art, Culture, History.
Location of the book can be updated.

# API Endpoints
* Add Books : /api/addbook 
* Issue Book : /api/books{id}/issue
* Return Book : /api/books/{id}/return
* Search Book : /api/books/search
* Get List of All Books : /api/books
* Book History : /api/books/{id}/book-history
* Update Book Location : /api/books/{id}/location

# Technology Stack Used
* Spring Initiliazaer Project
* Elastic Search Database
* AngularJS 

# Elastic Host
* Elastic can be either hosted on Docker or Kubernetes. I have used windows installer to create an instance of Elastic

# Elastic Indices
* borrower : id, name, dateOfIssue, returnDate, bookID
* books : id, title, genre, author, state, issuerID

Book can have three states : Issued, Available, maintainance (Book will be in maintainance if genre is not specified. IssuerID for the book is not mandatory, since book can be in either available / maintainance state)


# Elastic Data Snapshots
(https://github.com/sumukhbhandarkar/Library-Management-System/blob/master/src/main/resources/static/images/elasticData.PNG)



