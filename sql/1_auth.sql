INSERT INTO auth_user_comp (id) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_impl (id, allowedPermissions, name, email) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','admin','admin@user.com'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Adit','adit@user.com'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Brando','brando@user.com')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_passworded (id, record_id, password) VALUES
('1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b')
ON CONFLICT DO NOTHING;

INSERT INTO auth_role_comp (id) VALUES
('15f6727e-66f8-484f-b77f-83eeec82cd10'),
('25f6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO auth_role_impl (id, name, allowedPermissions) VALUES
('15f6727e-66f8-484f-b77f-83eeec82cd10','administrator','administrator'),
('25f6727e-66f8-484f-b77f-83eeec82cd10','Customer','home,CreateOrder,ReadOrder,ReadEvent,ReadPackage,ReadBlog,ReadCartItem,CheckoutCart')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_comp (id) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10'),
('2af6727e-66f8-484f-b77f-83eeec82cd10'),
('3af6727e-66f8-484f-b77f-83eeec82cd10')
ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_impl (id, authRole, authUser) VALUES
('1af6727e-66f8-484f-b77f-83eeec82cd10','15f6727e-66f8-484f-b77f-83eeec82cd10','1ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3af6727e-66f8-484f-b77f-83eeec82cd10','25f6727e-66f8-484f-b77f-83eeec82cd10','3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT DO NOTHING;

INSERT INTO customer_comp (customerid, name, email, modulesequence, objectname) VALUES
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Adit','adit@user.com','customer_impl','OnlineTicketing.customer.core.CustomerImpl'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca','Brando','brando@user.com','customer_impl','OnlineTicketing.customer.core.CustomerImpl')
ON CONFLICT DO NOTHING;

INSERT INTO customer_impl (customerid) VALUES
('2ea9ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3ea9ff33-6dd2-4c0a-b113-a90ee32a01ca')
ON CONFLICT DO NOTHING;