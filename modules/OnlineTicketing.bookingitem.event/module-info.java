module OnlineTicketing.bookingitem.event {
	requires OnlineTicketing.bookingitem.core;
    exports OnlineTicketing.bookingitem.event;

	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens OnlineTicketing.bookingitem.event to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
