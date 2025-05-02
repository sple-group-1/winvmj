package OnlineTicketing.bookingoption.packageoption;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingoption.core.BookingOptionDecorator;
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionComponent;

@Entity(name="bookingoption_packageoption")
@Table(name="bookingoption_packageoption")
public class BookingOptionImpl extends BookingOptionDecorator {

	protected String packageName;
	public BookingOptionImpl(
        super();
        this.objectName = BookingOptionImpl.class.getName();
    }
    
    public BookingOptionImpl(String packageName) {
    	super();
		this.packageName = packageName;
		this.objectName = BookingOptionImpl.class.getName();
    }
	
	public BookingOptionImpl(BookingOptionComponent record, String packageName) {
		super(record);
		this.packageName = packageName;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


}
