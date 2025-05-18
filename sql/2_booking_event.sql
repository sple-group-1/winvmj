INSERT INTO bookingitem_comp (id, bookingtype, modulesequence, objectname) VALUES
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event',null,'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event','bookingitem_impl, bookingitem_event','OnlineTicketing.bookingitem.core.BookingItemImpl'),
('7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event',null,'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event','bookingitem_impl, bookingitem_event','OnlineTicketing.bookingitem.core.BookingItemImpl'),
('9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','event',null,'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('10a9ff33-6dd2-4c0a-b113-a90ee32a01ca','event','bookingitem_impl, bookingitem_event','OnlineTicketing.bookingitem.core.BookingItemImpl'),
('11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','event',null,'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('12a9ff33-6dd2-4c0a-b113-a90ee32a01ca','event','bookingitem_impl, bookingitem_event','OnlineTicketing.bookingitem.core.BookingItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingitem_impl (id) VALUES
('6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('10a9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('12a9ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT DO NOTHING;

INSERT INTO bookingitem_event (id, title, description, imageurls, location, facilities, record_id, base_component_id, recordname) VALUES
('5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Garuda Wisnu Kencana Cultural Park','When in Bali, a visit to Garuda Wisnu Kencana (GWK) Cultural Park is a must.', null, 'Bali', 'Park, Show', '6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', '6ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Jakarta AQuarium Safari','Jakarta Aquarium & Safari is the largest indoor living planet in Indonesia, a signature of Taman Safari in collaboration with Aquaria KLCC, Malaysia.', null, 'Jakarta Barat', 'Souvenir Shop, Photo Spot/Photo Zone', '8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', '8ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Enchanting Valley Bogor','Step into a world of wonder at Enchanting Valley in Puncak, a nature-themed park where thrilling adventures meet breathtaking scenery.', null, 'Kabupaten Bogor', 'Park, Zoo, Playground', '10a9ff33-6dd2-4c0a-b113-a90ee32a01ca', '10a9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.event.BookingItemImpl'),
('11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','Jatim Park 1','Jatim Park 1 is a place filled with excitement and unforgettable adventures!', null, 'Malang', 'Amusement Park, Shows', '12a9ff33-6dd2-4c0a-b113-a90ee32a01ca', '12a9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'OnlineTicketing.bookingitem.event.BookingItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_comp (id, bookingtype, price, bookingitem_id, modulesequence, objectname) VALUES
('5af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('6af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('7af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 100000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('8af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 100000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('9af6727e-66f8-484f-b77f-83eeec82cd10', 'event', 125000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('10f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 125000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('11f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 175000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('12f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 175000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('13f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 135000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('14f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 135000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('15f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 225000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('16f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 225000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('17f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('18f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 150000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl'),
('19f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 180000,null, null, 'OnlineTicketing.bookingoption.packageoption.BookingOptionImpl'),
('20f6727e-66f8-484f-b77f-83eeec82cd10', 'event', 180000,null, 'bookingoption_impl, bookingoption_packageoption', 'OnlineTicketing.bookingoption.core.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_impl (id) VALUES
('6af6727e-66f8-484f-b77f-83eeec82cd10'),
('8af6727e-66f8-484f-b77f-83eeec82cd10'),
('10f6727e-66f8-484f-b77f-83eeec82cd10'),
('12f6727e-66f8-484f-b77f-83eeec82cd10'),
('14f6727e-66f8-484f-b77f-83eeec82cd10'),
('16f6727e-66f8-484f-b77f-83eeec82cd10'),
('18f6727e-66f8-484f-b77f-83eeec82cd10'),
('20f6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO bookingoption_packageoption (id, packagename, event_id, record_id, base_component_id, recordname) VALUES
('5af6727e-66f8-484f-b77f-83eeec82cd10', 'GWK Entrance Ticket','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','6af6727e-66f8-484f-b77f-83eeec82cd10', '6af6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('7af6727e-66f8-484f-b77f-83eeec82cd10', 'GWK at Night - Baraong Show','5ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','8af6727e-66f8-484f-b77f-83eeec82cd10', '8af6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('9af6727e-66f8-484f-b77f-83eeec82cd10', 'Regular Ticket','7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','10f6727e-66f8-484f-b77f-83eeec82cd10', '10f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('11f6727e-66f8-484f-b77f-83eeec82cd10', 'Premium Ticket','7ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','12f6727e-66f8-484f-b77f-83eeec82cd10', '12f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('13f6727e-66f8-484f-b77f-83eeec82cd10', 'Regular Ticket','9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','14f6727e-66f8-484f-b77f-83eeec82cd10', '14f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('15f6727e-66f8-484f-b77f-83eeec82cd10', 'Premium Ticket','9ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','16f6727e-66f8-484f-b77f-83eeec82cd10', '16f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('17f6727e-66f8-484f-b77f-83eeec82cd10', 'Regular Ticket','11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','18f6727e-66f8-484f-b77f-83eeec82cd10', '18f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl'),
('19f6727e-66f8-484f-b77f-83eeec82cd10', 'Premium Ticket','11a9ff33-6dd2-4c0a-b113-a90ee32a01ca','20f6727e-66f8-484f-b77f-83eeec82cd10', '20f6727e-66f8-484f-b77f-83eeec82cd10', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl')
ON CONFLICT DO NOTHING;

INSERT INTO order_comp (orderid, createdat, startdate, enddate, totalprice, quantity, bookingoption_id, customer_customerid, modulesequence, objectname) VALUES
('e2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP, '2025-08-10', '2025-08-10', 200000, 2, '7af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl'),
('f2e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '20 days', '2025-05-01', '2025-05-01', 450000, 3, '5af6727e-66f8-484f-b77f-83eeec82cd10', '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl'),
('f1e6727e-66f8-484f-b77f-83eeec82cd10', CURRENT_TIMESTAMP - INTERVAL '60 days', '2025-03-30', '2025-03-30', 350000, 2, '11f6727e-66f8-484f-b77f-83eeec82cd10', '3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'order_impl, order_event', 'OnlineTicketing.order.core.OrderImpl')
 ON CONFLICT DO NOTHING;

 INSERT INTO order_impl (orderid) VALUES
 ('e2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('f2e6727e-66f8-484f-b77f-83eeec82cd10'),
 ('f1e6727e-66f8-484f-b77f-83eeec82cd10')
 ON CONFLICT DO NOTHING;