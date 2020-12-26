# SA_Group4

* Build a console application that shows the status of two services __Counter A, Counter B__
* If one of the services, say Counter A is down it prints out a message that __Counter A is down__ and posts a message to a __Queue[X]__
* A third Service __Counter C__ is subscribed to the Queue[X]. When it receives a message it mails to the list of subscribers(You can hardcode the email addresses)
* The application will be tested by manually turning off the services



Steps to configure email :- 

1.Read application.properties of counter C.
2.Update your email and password there.
3.After that login into browser and click on one link and turn on access for app.
 Login in to your gmail account in browser and go to this link : https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4Neelqc6YR2AnSaHNod7HGZrNNJOGAY3k39e_H3Twv85u_IHbv8gnPWh7eFHuFvN6_EW-7FsjCkjqixzuC8Qr7aTQn91A
 and turn it on 
4.Then go to receiver.java and put  address which you want to send mail.
5.After that bring up counter C A and B
6.Then down A or B
7.The To address will receive a mail
