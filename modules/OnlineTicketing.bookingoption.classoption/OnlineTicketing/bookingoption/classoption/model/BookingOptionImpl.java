package OnlineTicketing.bookingoption.classoption;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingoption.core.BookingOptionDecorator;
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionComponent;

@Entity(name="bookingoption_classoption")
@Table(name="bookingoption_classoption")
public class BookingOptionImpl extends BookingOptionDecorator {

	public String class;
	public BookingOptionImpl(
        super();
        this.objectName = BookingOptionImpl.class.getName();
    }
    
    public BookingOptionImpl(String class) {
    	super();
		this.class = class;
		this.objectName = BookingOptionImpl.class.getName();
    }
	
	public BookingOptionImpl(BookingOptionComponent record, String class) {
		super(record);
		this.class = class;
		this.objectName = BookingOptionImpl.class.getName();
	}



}
