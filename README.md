# Spring Applications

This repository contains some of the sample implementation of spring projects and concepts.

###REST- REpresentational State Transfer
<b>HTTP verbs</b>:

We can use HTTP verbs to manipulate the data represented by those URIs.

* The HTTP <b>GET</b> verb tells the service to get, or retrieve, the resource designated by a URI. How it does this is, of course, implementation specific. The backend code might talk to a database, a file system, another webservice, etc. The client doesn’t need to be aware of this, though. To the client, all resources are HTTP resources, and in the world of HTTP, there’s only one way to ask for data: GET. GET calls have no body in the request, but typically return a body. The response to an HTTP GET request for /bob/bookmarks/6 might look like:


			{
				id: 6,
				uri: "http://bookmark.com/2/bob",
				description: "A description"
			}
			

* The HTTP <b>DELETE</b> verb tells the service to remove the resource designated by a URI. Again, this is implementation specific. DELETE calls have no body.

* The HTTP <b>PUT</b> verb tells the service to update the resource designated by a URI with the body of the enclosed request. Thus, to update the resource at /bob/bookmarks, I might send the same JSON representation returned from the GET call, with updated fields. The service will replace the value.

* The HTTP <b>POST</b> verb tells the service to do something with the enclosed body of the request. There’s no hard and fast rules here, but typically an HTTP POST call to /bob/bookmarks will add, or append, the enclosed body to the collection (database, filesystem, whatever) designated by the /bob/bookmarks URI. It can be a little confusing, though. An HTTP POST to /bob/bookmarks/1, on the other hand, might be treated in the same way as an HTTP PUT call; the service could take the enclosed body and use it to replace the resource designated by the URI.
		
<b>Status Code</b>:
	
	1. Status codes in the 100x range (from 100-199) are informational, and describe the processing for the request.
	
	2. Status codes in the 200x range (from 200-299) indicate the action requested by the client was received, understood, accepted and processed successfully.
	
	3. Status codes in the 300x range (from 300-399) indicate that the client must take additional action to complete the request, such as following a redirect.
	
	4. Status codes in the 400x range (from 400-499) is intended for cases in which the client seems to have erred and must correct the request before continuing. The aforementioned 404 is an example of this.
	
	5. Status codes in the 500x range (from 500-599) is intended for cases where the server failed to fulfill an apparently valid request.
	

### <b>REST Applications</b>

REST api based application.

	1. REST-HATEOAS (Hypermedia As The Engine Of Application State)
	
		reference: https://spring.io/guides/gs/rest-hateoas/
		
	2. REST-WITH-SPRING (in-progress)
	
		sample Bookmark application.
		reference: https://spring.io/guides/tutorials/bookmarks/
    
	
		