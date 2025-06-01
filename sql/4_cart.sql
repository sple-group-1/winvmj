INSERT INTO cart_comp (id, total, customer_customerid, modulesequence, objectname) VALUES
('3d0c98d4-3e48-4d4f-8df2-f15c7a3ea229', 1000000, '2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'cart_impl', 'OnlineTicketing.cart.core.CartImpl'),
('4d0c98d4-3e48-4d4f-8df2-f15c7a3ea229', 0, '3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca', 'cart_impl', 'OnlineTicketing.cart.core.CartImpl')
ON CONFLICT DO NOTHING;

INSERT INTO cart_impl (id) VALUES 
('3d0c98d4-3e48-4d4f-8df2-f15c7a3ea229'),
('4d0c98d4-3e48-4d4f-8df2-f15c7a3ea229')
ON CONFLICT DO NOTHING;

INSERT INTO cartitem_comp (id, amount, enddate, quantity, startdate, bookingoption_id, cart_id, modulesequence, objectname) VALUES
('f2c3f5a7-2a14-4a7d-a408-5a8b82df178e', 100000, '2025-5-13', 10, '2025-5-1', '6af6727e-66f8-484f-b77f-83eeec82cd10', '3d0c98d4-3e48-4d4f-8df2-f15c7a3ea229', 'cartitem_impl', 'OnlineTicketing.cart.core.CartItemImpl')
ON CONFLICT DO NOTHING;

INSERT INTO cartitem_impl (id) VALUES
('f2c3f5a7-2a14-4a7d-a408-5a8b82df178e')
ON CONFLICT DO NOTHING;

