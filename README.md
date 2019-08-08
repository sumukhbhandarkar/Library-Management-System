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

# Steps to install
* Download the code onto IDE that supports Sprint Boot, such as IntelliJ Ultimate Edition / Spring Tool Suite.
* Download Elastic Search and start instance on port 9200, with transport port as 9300. 
* Create index named 'test' with mapping as here 
"""
{
	"settings" : {
		
			"number_of_shards" : 3
			
	},
    "mappings": {
            "properties": {
                "bookTitle": {
                    "type": "keyword"
                },
                "bookID": {
                    "type": "keyword"
                },
                "bookGenre": {
                    "type": "keyword"
                },
                "bookAuthor": {
                    "type": "keyword"
                },
                "bookState": {
                    "type": "keyword"
                },
                "issuerID": {
                    "type": "keyword"
                }
            }
        }
}

"""
To add books : Check the elastic data snapshot.

Run the application using Spring Boot. 
Test the API endpoints using Postman.

If API endpoints are working, open resources/static folder in IDE such as Webstorm. 
perform bower and npm install to download packages. 

* Install bower
$ npm install bower --save-dev -g

* Install grunt-serve
$ npm install grunt-serve --save-dev -g
$ npm install grunt-cli --save-dev -g
$ npm install grunt --save-dev -g

* Perform grunt serve from command line to get the Angular Application up and running.




