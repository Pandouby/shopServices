INSERT INTO `User` (firstname, lastname, birthdate)
VALUES
    ('Aaron', 'Holenstein', '2002-07-12'),
    ('Silvan', 'Dubach', '2002-07-12'),
    ('Maurin', 'Schucan', '2002-07-12');
INSERT INTO `Product` (name, description, price)
VALUES
    ('Meth', 'Methamphetamine', 100),
    ('Dildo', 'Yves favourite item', 69.69),
    ('testProduct', 'Introducing our innovative testproduct! Designed with cutting-edge technology and precision engineering, this product is the perfect solution for your testing needs. With a sleek and modern design, it offers reliability and performance.', 100);
INSERT INTO `Product_Order` (order_time, user_id, product_id)
VALUES
    ('2023-12-07 08:46:05', 1, 3),
    ('2023-12-07 15:14:07', 2, 2),
    ('2023-12-06 23:50:58', 1, 1);