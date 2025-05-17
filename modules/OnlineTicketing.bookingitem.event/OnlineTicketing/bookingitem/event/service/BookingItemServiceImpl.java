package OnlineTicketing.bookingitem.event;

import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.RuntimeException;
import vmj.routing.route.exceptions.*;
import java.nio.charset.StandardCharsets;

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

		byte[] fileContent = uploadedFile.get("content");

		int fileSize = fileContent.length;

		if (fileSize > 15000000)
			throw new FileSizeException(15.0, ((double) fileSize) / 1000000, "megabyte");

		// Check for PNG or JPEG
		boolean isPng = fileContent[0] == (byte)0x89 && fileContent[1] == 0x50 && fileContent[2] == 0x4E && fileContent[3] == 0x47;
		boolean isJpeg = fileContent[0] == (byte)0xFF && fileContent[1] == (byte)0xD8;

		if (!isPng && !isJpeg) {
			throw new FileTypeException("Image (PNG or JPEG)");
		}

		String base64Encoded  = Base64.getEncoder().encodeToString(fileContent);
		byte[] imageUrls = base64Encoded.getBytes(StandardCharsets.UTF_8);

		String facilities = (String) requestBody.get("facilities");
		String description = (String) requestBody.get("description");

		BookingItem bookingItem = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.core.BookingItemImpl", "event");
        BookingItem event = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.event.BookingItemImpl", bookingItem, title, location, imageUrls, facilities, description);
		
        bookingItemRepository.saveObject(bookingItem);
		bookingItemRepository.saveObject(event);
		
		return event;
	}

	public BookingItem updateBookingItem(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("eventId");
		UUID id = UUID.fromString(idStr);

		String title = (String) requestBody.get("title");
		String location = (String) requestBody.get("location");
		Map<String, byte[]> uploadedFile = (HashMap<String, byte[]>) requestBody.get("imageUrls");

		byte[] fileContent = uploadedFile.get("content");

		int fileSize = fileContent.length;

		if (fileSize > 15000000)
			throw new FileSizeException(15.0, ((double) fileSize) / 1000000, "megabyte");

		boolean isPng = fileContent[0] == (byte)0x89 && fileContent[1] == 0x50 && fileContent[2] == 0x4E && fileContent[3] == 0x47;
		boolean isJpeg = fileContent[0] == (byte)0xFF && fileContent[1] == (byte)0xD8;

		if (!isPng && !isJpeg) {
			throw new FileTypeException("Image (PNG or JPEG)");
		}

		String base64Encoded  = Base64.getEncoder().encodeToString(fileContent);
		byte[] imageUrls = base64Encoded.getBytes(StandardCharsets.UTF_8);

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
