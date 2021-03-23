#Use this on our database to have sample entities in the database
USE ebike;

#fill address
INSERT INTO address(address_id, address_city, address_postalcode, address_streetname, address_streetnumber)
VALUES
       (1, 'Graz', 8020, 'Mühlgasse', 54),
       (2, 'Graz', 8020, 'Babenbergerstraße', 11),
       (3, 'Graz', 8020, 'Europaplatz', 6),
       (4, 'Graz', 8010, 'Girardigasse', 3),
       (5, 'Wien', 1040, 'Weyringergasse', 4),
       (6, 'Wien', 1040, 'Viktorgasse', 18),
       (7, 'Wien', 1080, 'Schönborngasse', 4),
       (8, 'Wien', 1180, 'Riglergasse', 1),
       (9, 'Wien', 1100, 'Alxingergasse', 21)
;

#fill rentstation
INSERT INTO rentstation(rentstation_id,rentstation_capacity, address_id)
VALUES
(1,20,3),
(2,10,8),
(3,5,9)
;
#fill ebike
INSERT INTO ebike(ebike_id, ebike_model, rentstation_id)
VALUES
(1,'Turbo Vado SL', 1),
(2, 'RadRunner XD', 1),
(3, 'Propella 7-Speed', 1),
(4, 'Tern GSD S10', 3),
(5, 'RadWagon 4', 2),
(6, 'Batch E-Bike', 3)
;

#fill user
INSERT INTO user(user_id, user_email, user_firstname, user_lastname, address_id)
VALUES
(1,'maxMustermann@gmail.com', 'Max', 'Mustermann', 2),
(2, 'AnnaBanana@gmx.de', 'Anna', 'Gelb', 1),
(3, 'myBestMail@anonymous.com', 'ano', 'nymos', 4),
(4, 'PetraMeier@gmail.com', 'Petra', 'Meier', 6)
;

#fill invoice
INSERT INTO invoice(invoice_id, invoice_enddate, invoice_startdate, ebike_id, user_id)
VALUES
(1, '2019-11-01 01:15:00', '2020-01-31 03:35:00', 2, 3),
(2, '2020-01-11 16:13:00', '2020-01-31 13:15:00', 3, 1),
(3, '2020-04-27 21:15:00', '2020-04-28 01:15:00', 2, 1),
(4, '2020-04-04 01:15:00', '2020-05-31 21:19:00', 2, 3),
(5, '2020-12-01 21:15:00', '2020-12-15 09:15:00', 4, 2),
(6, '2020-12-18 11:15:00', '2020-12-31 05:15:00', 5, 4),
(7, '2020-12-22 03:15:00', '2020-12-31 01:15:00', 6, 2),
(8, '2020-12-11 22:00:00', '2020-12-31 13:21:00', 2, 3)
;