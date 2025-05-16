package OnlineTicketing.bookingitem.event;

import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.lang.RuntimeException;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.bookingitem.BookingItemFactory;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItemServiceDecorator;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;

public class BookingItemServiceImpl extends BookingItemServiceDecorator {
    private BookingItemFactory bookingItemFactory = new BookingItemFactory();

    public BookingItemServiceImpl (BookingItemServiceComponent record) {
        super(record);
    }

	public BookingItem createBookingItem(Map<String, Object> requestBody) {
		String title = (String) requestBody.get("title");
		String location = (String) requestBody.get("location");
		Map<String, byte[]> uploadedFile = (HashMap<String, byte[]>) requestBody.get("imageUrls");
		
        String imageUrls = "data:" + (new String(uploadedFile.get("type"))).split(" ")[1].replaceAll("\\s+", "")
                + ";base64," + Base64.getEncoder().encodeToString(uploadedFile.get("content"));
        int fileSize = uploadedFile.get("content").length;
        if (fileSize > 4000000)
            throw new FileSizeException(4.0, ((double) fileSize) / 1000000, "megabyte");
        try {
            String type = URLConnection
                    .guessContentTypeFromStream(new ByteArrayInputStream(uploadedFile.get("content")));
            if (type == null || !type.startsWith("image"))
                throw new FileTypeException("image");
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

		imageUrls = "a";

		String facilities = (String) requestBody.get("facilities");
		String description = (String) requestBody.get("description");

		BookingItem bookingItem = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.core.BookingItemImpl", "event");
        BookingItem event = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.event.BookingItemImpl", bookingItem, title, location, imageUrls, facilities, description);
		
        bookingItemRepository.saveObject(bookingItem);
		bookingItemRepository.saveObject(event);

		return event;
	}

	public BookingItem updateBookingItem(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		String title = (String) requestBody.get("title");
		String location = (String) requestBody.get("location");
		Map<String, byte[]> uploadedFile = (HashMap<String, byte[]>) requestBody.get("imageUrls");
		
        String imageUrls = "data:" + (new String(uploadedFile.get("type"))).split(" ")[1].replaceAll("\\s+", "")
                + ";base64," + Base64.getEncoder().encodeToString(uploadedFile.get("content"));
        int fileSize = uploadedFile.get("content").length;
        if (fileSize > 4000000)
            throw new FileSizeException(4.0, ((double) fileSize) / 1000000, "megabyte");
        try {
            String type = URLConnection
                    .guessContentTypeFromStream(new ByteArrayInputStream(uploadedFile.get("content")));
            if (type == null || !type.startsWith("image"))
                throw new FileTypeException("image");
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

		String facilities = (String) requestBody.get("facilities");
		String description = (String) requestBody.get("description");

		BookingItem savedBookingItem = getBookingItem(id);
        UUID recordBookingItemId = (((BookingItemDecorator) savedBookingItem).getRecord()).getId();

        BookingItem bookingItem = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.core.BookingItemImpl", recordBookingItemId, "event");
        BookingItem event = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.event.BookingItemImpl", id, bookingItem, title, location, imageUrls, facilities, description);
		bookingItem.setBookingType((String) requestBody.get("bookingType"));

		bookingItemRepository.updateObject(bookingItem);
		bookingItemRepository.updateObject(event);

		bookingItem = bookingItemRepository.getObject(id);

		return bookingItem;

	}

	public BookingItem getBookingItem(UUID id) {
		return record.getBookingItem(id);
	}

	public List<BookingItem> getAllBookingItem() {
		List<BookingItem> list = bookingItemRepository.getAllObject("bookingitem_event");
		return list;
	}

	public List<BookingItem> deleteBookingItem(UUID id) {
		bookingItemRepository.deleteObject(id);
		return getAllBookingItem();
	}    
}
