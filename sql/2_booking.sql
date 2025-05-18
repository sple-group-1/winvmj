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

INSERT INTO bookingitem_hotel (id, title, imageurls, location, facilities, record_id, base_component_id, recordname) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Aston Manila', 'https://picsum.photos/seed/random123/600/400', 'Manila', 'spa', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.hotel.BookingItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingitem_event (id, title, description, imageurls, location, facilities, record_id, base_component_id, recordname) VALUES
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Garuda Wisnu Kencana Cultural Park','When in Bali, a visit to Garuda Wisnu Kencana (GWK) Cultural Park is a must/', null, 'Bali', 'Park, Show', '6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', '6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.event.BookingItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_comp (id, bookingtype, price, bookingitem_id, modulesequence, objectname) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10', 'hotel', 5000000,'1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', null, 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('2af6727e-66f8-484f-b77f-83eeec82cd10', 'hotel', 5000000,'2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'bookingoption_impl, bookingoption_roomoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('3af6727e-66f8-484f-b77f-83eeec82cd10', 'flight', 10000000,'3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', null, 'OnlineTicketing.bookingoption.classoption.BookingOptionImpl'),
('4af6727e-66f8-484f-b77f-83eeec82cd10', 'flight', 10000000,'4ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'bookingoption_impl, bookingoption_classoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('5af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('6af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('7af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 100000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('8af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 100000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_impl (id) VALUES
('2af6727e-66f8-484f-b77f-83eeec82cd10'),
('4af6727e-66f8-484f-b77f-83eeec82cd10'),
('6af6727e-66f8-484f-b77f-83eeec82cd10'),
('8af6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_roomoption (id, roomtype, record_id, base_component_id, recordname) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10', 'vip', '2af6727e-66f8-484f-b77f-83eeec82cd10', '2af6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_packageoption (id, packagename, event_id, record_id, base_component_id, recordname) VALUES
('5af6727e-66f8-484f-b77f-83eeec82cd10', 'GWK Entrance Ticket','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','6af6727e-66f8-484f-b77f-83eeec82cd10', '6af6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('7af6727e-66f8-484f-b77f-83eeec82cd10', 'GWK at Night - Baraong Show','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','8af6727e-66f8-484f-b77f-83eeec82cd10', '8af6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO order_comp (orderid, createdat, startdate, enddate, totalprice, quantity, bookingoption_id, customer_customerid, modulesequence, objectname) VALUES
('e2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP, '2025-08-10', '2025-08-10', 200000, 2, '7af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl'),
('f2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '20 days', '2025-05-01', '2025-05-01', 450000, 3, '5af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl')
 ON CONFLICT DO NOTHING;

 INSERT INTO order_impl (orderid) VALUES
 ('e2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('f2e6727e-66f8-484f-b77f-83eeec82cd10')
 ON CONFLICT DO NOTHING;