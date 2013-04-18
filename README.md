README
======

Introduction
------------

This app is used to record most details of most quantum simulations on the Palmetto Cluster. It is divided into two parts. 
The first is responsible for extracting information from the standard output text files and store into database. The second 
part is responsible for visualize the data through a web interface and small modification of the data.

Build
-----
The first part is done by standard Java I/O and spring roo for persistence use MYSQL database.
The main web interface is planned to be done using Ruby on Rails, some simple admin functions is planned to be done with 
Spring MVC.

Todo
----
1. Finish the persistence data part. Currently about 10% data is persisted
2. Initial scaffold of the web interface and initial deployment onto Amazon EC2 