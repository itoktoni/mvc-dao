# mvc-dao
this is project example for connect database with DAO pattern 
hr
## installation 
hr
just grab in github using command git clone https://github.com/itoktoni/mvc-dao.git
## setting
database using sqlite in folder \WebContent\database, sqlite.db (please attach in d)
for setting mysql and sqlite in com.driver.demo
## configuration
- interface = i make interface to force all of member for interaction with database called driver();
that used for setup database and make connection with that
- abstract connection = i make connection with abstract class called AbstactSinglePatternConnection,
that force all class member for make open connection and make update and select method
- factory pattern = you can change mysql or sqlite for database connection, you can found in FactoryPatternConnection
## controller
- there is 2 method post and get in homecontroller, in get method its will get all data and send to view home.jsp
## model
- i make DAO (data access object) for design pattern, its will make sparate logic and bussiness. 
- entity is representation of database model
- DAO class is all operation with database
# view
- you can found view in WebContent call home.jsp
- i am using jstl template engine.

