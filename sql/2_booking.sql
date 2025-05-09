INSERT INTO bookingitem_comp (id, bookingtype, modulesequence, objectname) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','hotel',null,'OnlineTicketing.bookingitem.hotel.BookingItemImpl'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','hotel','bookingitem_impl, bookingitem_hotel','OnlineTicketing.bookingitem.core.BookingItemImpl'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','flight',null,'OnlineTicketing.bookingitem.flight.BookingItemImpl'),
('4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','flight','bookingitem_impl, bookingitem_flight','OnlineTicketing.bookingitem.core.BookingItemImpl'),
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event',null,'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event','bookingitem_impl, bookingitem_event','OnlineTicketing.bookingitem.core.BookingItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingitem_impl (id) VALUES
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_comp (id, bookingtype, price, bookingitem_id, modulesequence, objectname) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10', 'hotel', 5000000,'1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', null, 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('2af6727e-66f8-484f-b77f-83eeec82cd10', 'hotel', 5000000,'2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'bookingoption_impl, bookingoption_roomoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('3af6727e-66f8-484f-b77f-83eeec82cd10', 'flight', 10000000,'3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', null, 'OnlineTicketing.bookingoption.classoption.BookingOptionImpl'),
('4af6727e-66f8-484f-b77f-83eeec82cd10', 'flight', 10000000,'4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'bookingoption_impl, bookingoption_classoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('5af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 3000000,'5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('6af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 3000000,'6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_impl (id) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10'),
('2af6727e-66f8-484f-b77f-83eeec82cd10'),
('3af6727e-66f8-484f-b77f-83eeec82cd10'),
('4af6727e-66f8-484f-b77f-83eeec82cd10'),
('5af6727e-66f8-484f-b77f-83eeec82cd10'),
('6af6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO order_comp (orderid, createdat, startdate, enddate, totalprice, quantity, bookingoption_id, customer_customerid, modulesequence, objectname) VALUES
('a2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP, '2025-07-01', '2025-07-03', 15000000, 3, '2af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_hotel', 'OnlineTicketing.order.core.OrderImpl'),
('b2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '60 days', '2025-03-01', '2025-03-02', 10000000, 2, '2af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_hotel', 'OnlineTicketing.order.core.OrderImpl'),
('c2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP, '2025-06-15', '2025-06-15', 20000000, 2, '4af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_flight', 'OnlineTicketing.order.core.OrderImpl'),
('d2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '40 days', '2025-04-01', '2025-04-01', 10000000, 1, '4af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_flight', 'OnlineTicketing.order.core.OrderImpl'),
('e2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP, '2025-08-10', '2025-08-10', 6000000, 2, '6af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl'),
('f2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '20 days', '2025-05-01', '2025-05-01', 3000000, 1, '6af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl')
 ON CONFLICT DO NOTHING;

 INSERT INTO order_impl (orderid) VALUES
 ('a2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('b2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('c2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('d2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('e2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('f2e6727e-66f8-484f-b77f-83eeec82cd10')
 ON CONFLICT DO NOTHING;