#Use this on our database to have sample entities in the database
USE ebike;
#DROP TABLE invoice, ebike, rentstation, user, address;

#fill address
INSERT INTO address(address_city, address_postalcode, address_streetname, address_streetnumber, address_latitude, address_longitude )
VALUES ('Graz', 8020, 'Europaplatz', 6, 47.073068252434844, 15.417795002967065),
       ('Graz', 8010, 'Karmeliterplatz', 3, 47.07437348642562, 15.441010953231684),
       ('Graz', 8020, 'Fabriksgasse', 29, 47.05925813002857, 15.42649647049234);

#fill rentstation
INSERT INTO rentstation(address_id)
VALUES (1),
       (2),
       (3);
#fill ebike
INSERT INTO ebike(ebike_model, rentstation_id)
VALUES ('Turbo Vado SL', 1),
       ('RadRunner XD', 1),
       ('Propella 7-Speed', 1),
       ('Tern GSD S10', 3),
       ('RadWagon 4', 2),
       ('Batch E-Bike', 3);


#fill user
INSERT INTO user (user_password, user_email, user_firstname, user_lastname)
VALUES ('1234','maxMustermann@gmail.com', 'Max', 'Mustermann'),
       ('1234','AnnaBanana@gmx.de', 'Anna', 'Gelb'),
       ('1234','myBestMail@anonymous.com', 'ano', 'nymos'),
       ('1234','PetraMeier@gmail.com', 'Petra', 'Meier');


#fill invoice
INSERT INTO invoice(invoice_enddate, invoice_startdate, ebike_id, user_id)
VALUES ('2019-11-01 01:15:00', '2020-01-31 03:35:00', 2, 3),
       ('2020-01-11 16:13:00', '2020-01-31 13:15:00', 3, 1),
       ('2020-04-27 21:15:00', '2020-04-28 01:15:00', 2, 1),
       ('2020-04-04 01:15:00', '2020-05-31 21:19:00', 2, 3),
       ('2020-12-01 21:15:00', '2020-12-15 09:15:00', 4, 2),
       (null, '2020-12-31 05:15:00', 5, 4),
       ('2020-12-22 03:15:00', '2020-12-31 01:15:00', 6, 2),
       ('2020-12-11 22:00:00', '2020-12-31 13:21:00', 2, 3);

