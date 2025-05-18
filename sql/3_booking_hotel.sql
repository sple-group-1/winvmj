insert into public.bookingitem_comp (id, bookingtype, objectname, modulesequence)
values  ('bfaa5c1d-2a54-489a-845f-ff6885e87e60', 'HOTEL', 'OnlineTicketing.bookingitem.core.BookingItemImpl', 'bookingitem_impl, bookingitem_hotel'),
        ('ab2b9f39-6025-4d15-9308-56676facb945', 'HOTEL', 'OnlineTicketing.bookingitem.hotel.BookingItemImpl', null),
        ('63481fd5-884f-4c0b-ad07-73986515906b', 'HOTEL', 'OnlineTicketing.bookingitem.core.BookingItemImpl', 'bookingitem_impl, bookingitem_hotel'),
        ('ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'HOTEL', 'OnlineTicketing.bookingitem.hotel.BookingItemImpl', null);

insert into public.bookingitem_impl (id)
values  ('bfaa5c1d-2a54-489a-845f-ff6885e87e60'),
        ('63481fd5-884f-4c0b-ad07-73986515906b');

insert into public.bookingitem_hotel (facilities, imageurl, location, title, id, record_id, recordname, base_component_id)
values  ('Parking, Spa, etc', 'https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/20020708-cba6d863056a1910b400710aacab716f.jpeg?_src=imagekit&tr=dpr-2,c-at_max,f-jpg,fo-auto,h-332,pr-true,q-80,w-480', 'Jalan MH Thamrin No. 1, Thamrin, Jakarta Pusat, Jakarta, Indonesia, 10310', 'Hotel Indonesia Kempinski Jakarta V1', 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'bfaa5c1d-2a54-489a-845f-ff6885e87e60', 'OnlineTicketing.bookingitem.core.BookingItemImpl', 'bfaa5c1d-2a54-489a-845f-ff6885e87e60'),
        ('Parking, Spa, etc', 'https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/20052530-6ec94a2936b1dee2212d9f5bf63359b9.jpeg?_src=imagekit&tr=dpr-2,c-at_max,f-jpg,h-360,pr-true,q-80,w-640', 'District 8, SCBD, Lot 28, Jakarta, Kebayoran Baru, Senayan, Jakarta, Indonesia, 12190', 'The Langham, Jakarta', 'ab2b9f39-6025-4d15-9308-56676facb945', '63481fd5-884f-4c0b-ad07-73986515906b', 'OnlineTicketing.bookingitem.core.BookingItemImpl', '63481fd5-884f-4c0b-ad07-73986515906b');


insert into public.bookingoption_comp (id, bookingtype, objectname, price, bookingitem_id, modulesequence)
values  ('3386e734-b900-4914-818d-d1748035d843', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 4300000, 'ab2b9f39-6025-4d15-9308-56676facb945', null),
        ('f6d251de-b2ef-40c4-af4b-4dfb1f159617', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 4300000, 'ab2b9f39-6025-4d15-9308-56676facb945', 'bookingoption_impl, bookingoption_roomoption'),
        ('677d5b9c-c4a9-4fb4-bcec-621122d2c86e', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 4400000, 'ab2b9f39-6025-4d15-9308-56676facb945', null),
        ('f4f92925-d194-4cbe-a5a6-d7e8576d0cf1', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 3200000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', null),
        ('83c8be6c-d25c-478a-a986-f9a06ccbf1b6', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 3200000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'bookingoption_impl, bookingoption_roomoption'),
        ('22af8047-883d-4888-bb9b-faa80349e6d6', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 4400000, 'ab2b9f39-6025-4d15-9308-56676facb945', 'bookingoption_impl, bookingoption_roomoption'),
        ('31c7ba44-cf8f-4cb2-959e-fa9099cdf721', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 3400000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', null),
        ('deef225c-6453-4965-9fb3-36e9bb638f32', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 3400000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'bookingoption_impl, bookingoption_roomoption'),
        ('e410fd71-2c0f-42f0-8e7e-bbc46e6f3cf4', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 3700000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', null),
        ('866d1620-7087-4613-8915-4d782592e1df', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 3700000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'bookingoption_impl, bookingoption_roomoption'),
        ('b63a0dd6-fd87-43e2-a06c-015e9d1a727f', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 4500000, 'ab2b9f39-6025-4d15-9308-56676facb945', null),
        ('f84d18aa-ab49-462f-893a-fe607aad064d', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 4500000, 'ab2b9f39-6025-4d15-9308-56676facb945', 'bookingoption_impl, bookingoption_roomoption'),
        ('69a54726-2a59-49b2-85c7-ca15364491a3', 'HOTEL', 'OnlineTicketing.bookingoption.roomoption.BookingOptionImpl', 4200000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', null),
        ('5f6bcc3e-deb7-4930-a117-cb09ee6e4f2a', 'HOTEL', 'OnlineTicketing.bookingoption.core.BookingOptionComponent', 4200000, 'ab0ddf1e-3c9e-4f80-878b-d2079ec00b04', 'bookingoption_impl, bookingoption_roomoption');


insert into public.bookingoption_impl (id)
values  ('83c8be6c-d25c-478a-a986-f9a06ccbf1b6'),
        ('deef225c-6453-4965-9fb3-36e9bb638f32'),
        ('866d1620-7087-4613-8915-4d782592e1df'),
        ('5f6bcc3e-deb7-4930-a117-cb09ee6e4f2a'),
        ('f6d251de-b2ef-40c4-af4b-4dfb1f159617'),
        ('22af8047-883d-4888-bb9b-faa80349e6d6'),
        ('f84d18aa-ab49-462f-893a-fe607aad064d');

insert into public.bookingoption_roomoption (roomtype, id, record_id, recordname, base_component_id)
values  ('Deluxe King', 'f4f92925-d194-4cbe-a5a6-d7e8576d0cf1', '83c8be6c-d25c-478a-a986-f9a06ccbf1b6', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', '83c8be6c-d25c-478a-a986-f9a06ccbf1b6'),
        ('Deluxe King View', '31c7ba44-cf8f-4cb2-959e-fa9099cdf721', 'deef225c-6453-4965-9fb3-36e9bb638f32', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', 'deef225c-6453-4965-9fb3-36e9bb638f32'),
        ('Grand Deluxe King View', 'e410fd71-2c0f-42f0-8e7e-bbc46e6f3cf4', '866d1620-7087-4613-8915-4d782592e1df', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', '866d1620-7087-4613-8915-4d782592e1df'),
        ('Executive Grand Deluxe Balcony', '69a54726-2a59-49b2-85c7-ca15364491a3', '5f6bcc3e-deb7-4930-a117-cb09ee6e4f2a', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', '5f6bcc3e-deb7-4930-a117-cb09ee6e4f2a'),
        ('Deluxe Cityscape Twin', '3386e734-b900-4914-818d-d1748035d843', 'f6d251de-b2ef-40c4-af4b-4dfb1f159617', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', 'f6d251de-b2ef-40c4-af4b-4dfb1f159617'),
        ('Deluxe Twin With Views', '677d5b9c-c4a9-4fb4-bcec-621122d2c86e', '22af8047-883d-4888-bb9b-faa80349e6d6', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', '22af8047-883d-4888-bb9b-faa80349e6d6'),
        ('Deluxe King', 'b63a0dd6-fd87-43e2-a06c-015e9d1a727f', 'f84d18aa-ab49-462f-893a-fe607aad064d', 'OnlineTicketing.bookingoption.core.BookingOptionImpl', 'f84d18aa-ab49-462f-893a-fe607aad064d');