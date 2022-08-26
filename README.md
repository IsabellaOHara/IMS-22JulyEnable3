Coverage: 61%
# Inventory Management System

This is functional inventory management system (IMS) application using Java which interacts with a managed database on MySQL.

This IMS can:
- Create: customers with a first and last name, items with a name and price, orders with a connected customer ID and it can add (multiple) items to orders using the item ID.
- Read: all customer details, detials about the items in the inventory and the orders.
- Update: customers first and last name, items name and price.
- Delete: Customers details, items in the inventory, entire orders and items from an order.

## Getting Started

Example user story path:
As an employee, I want to add an item into the system, so that I can put new items in the inventory.
1. Start the application
2. Type "items"
3. Type "create"
4. Type in the name of the item
5. Type in the price of the item
6. Finished! You've added an item to the inventory.

### Prerequisites

This IMS was built on:
- Maven version 3.8.6 which can be downloaded here: https://maven.apache.org/download.cgi
- Java version 1.8 which can be downloaded here: https://www.java.com/download/ie_manual.jsp

### Installing

To continue developing this application (on Eclipse)
1. Clone (or fork) this repo from https://github/IsabellaOHara/IMS-22JulyEnable3 into your eclipse-workspace file.
2. Go to File => Import => Maven => Existing Maven Projects => Browse your directory to find the file => finish.

## Running the tests

### Unit Tests 

Unit tests were completed using JUnit version 4.13.1 
Unit tests were run on the domain classes (Customers, Orders, Items, OrdersItems) and the DAO classes (CustomersDAO, OrdersDAO, ItemsDAO, OrdersItemsDAO). The tests in the DAO classes were run using a mock database (see below for example)

```
//For example in the ItemsDAO class
@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test 
	public void testCreate() {
		final Items newItem = new Items(2L, "hoodie", 50.00);
		assertEquals(newItem, DAO.create(newItem));
	}
```

### Integration Tests 
The integration tests were done using Mockito version 3.7.7
These test allow us to check the behaviour of the system without having to connect to the database.
These tests were run on the Controller classes (CustomerController, ItemsController, OrdersController, OrdersItemsController)

```
//An example from the ItemsController
@Mock
	private Utils utils;
	
	@Mock
	private ItemsDAO dao;
	
	@InjectMocks
	private ItemsController controller;
	
	@Test
	public void testCreate() {
		final String I_NAME = "tshirt";
		final double PRICE = 25.00;
		final Items created = new Items(I_NAME, PRICE);
		
		Mockito.when(utils.getString()).thenReturn(I_NAME);
		Mockito.when(utils.getDouble()).thenReturn(PRICE);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com) - Database Management System
* [Java](https://www.java.com) - Back End Programming Language
* [JUnit](https://junit.org/junit5/) - Unit testing

## Versioning

I used [Git](https://git-scm.com) for version control.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Isabella O'Hara** - *Project completion* - [IsabellaOHara](https://github.com/IsabellaOHara)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* Thank you to Chirs Perrins for the inital work and code on this project.
* An additional thank you to Victoria, Jordan, Anoush, Chris and Edward for all your teaching, guidance and help over the past 5 weeks enabling me to complete this project.
