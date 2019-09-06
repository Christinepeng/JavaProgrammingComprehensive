CONNECT 'jdbc:derby:BineetDB;create=true';


CREATE TABLE Products
(
    ProductCode VARCHAR(10), 
    Description VARCHAR(50), 
    Price DOUBLE
);

INSERT INTO Products 
VALUES ('bvbn', 'Murach''s Beginning Visual Basic .NET', 49.5); 
    	
INSERT INTO Products 
VALUES ('cshp', 'Murach''s C#', 49.5);

INSERT INTO Products 
VALUES ('java', 'Murach''s Beginning Java 2', 49.5);

INSERT INTO Products 
VALUES ('jsps', 'Murach''s Java Servlets and JSP', 49.5);

INSERT INTO Products 
VALUES ('mcb2', 'Murach''s Mainframe COBOL', 59.5);

INSERT INTO Products 
VALUES ('sqls', 'Murach''s SQL for SQL Server', 49.5);

INSERT INTO Products 
VALUES ('zjcl', 'Murach''s OS/390 and z/OS JCL', 62.5);


CREATE TABLE Customers
(
    CustomerID INT, 
    FirstName VARCHAR(50), 
    LastName VARCHAR(50), 
    EmailAddress VARCHAR(50)
);

INSERT INTO Customers 
VALUES (3, 'John', 'Smith', 'johnsmith@hotmail.com');
    	
INSERT INTO Customers 
VALUES (4, 'Frank', 'Jones', 'frankjones@yahoo.com');

INSERT INTO Customers 
VALUES (5, 'Cynthia', 'Green', 'seagreen@levi.com');

INSERT INTO Customers 
VALUES (6, 'Wendy', 'Kowolski', 'wendyk@warners.com');


CREATE TABLE Invoices
(
    InvoiceID INT, 
    CustomerID INT, 
    InvoiceNumber VARCHAR(50), 
    InvoiceDate DATE, 
    InvoiceTotal DOUBLE
);

INSERT INTO Invoices 
VALUES (1, 3, '10500M', '2004-10-25', 495.0);

INSERT INTO Invoices 
VALUES (2, 4, '10501M', '2004-10-25', 59.5);

INSERT INTO Invoices 
VALUES (4, 5, '10502M', '2004-10-25', 99.0);

INSERT INTO Invoices 
VALUES (5, 6, '10503M', '2004-10-25', 112.0);

INSERT INTO Invoices 
VALUES (6, 4, '10504M', '2004-11-18', 99.0);

INSERT INTO Invoices 
VALUES (7, 3, '10505M', '2004-11-18', 297.5);


CREATE TABLE LineItems
(
    LineItemID INT, 
    CustomerID INT, 
    ProductCode VARCHAR(10), 
    Quantity INT
);

INSERT INTO LineItems 
VALUES (1, 1, 'java', 5);
    	
INSERT INTO LineItems 
VALUES (2, 1, 'jsps', 5);

INSERT INTO LineItems 
VALUES (3, 2, 'mcb2', 1);

INSERT INTO LineItems 
VALUES (7, 4, 'cshp', 1);

INSERT INTO LineItems 
VALUES (8, 4, 'zjcl', 2);

INSERT INTO LineItems 
VALUES (9, 6, 'sqls', 1);

INSERT INTO LineItems 
VALUES (10, 6, 'java', 1);

INSERT INTO LineItems 
VALUES (11, 7, 'mcb2', 5);


DISCONNECT;