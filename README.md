# SA_Group4

* Build a console application that shows the status of two services __Counter A, Counter B__
* If one of the services, say Counter A is down it prints out a message that __Counter A is down__ and posts a message to a __Queue[X]__
* A third Service __Counter C__ is subscribed to the Queue[X]. When it receives a message it mails to the list of subscribers(You can hardcode the email addresses)
* The application will be tested by manually turning off the services
