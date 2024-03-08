package com.cabbooking;

import com.cabbooking.repository.DriverRepositoryImpl;
import com.cabbooking.repository.UserRepositoryImpl;
import com.cabbooking.service.CabBookingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabbookingApplication.class, args);
		final DriverRepositoryImpl driverRepositoryImpl = new DriverRepositoryImpl();
		final UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		final CabBookingServiceImpl cabBookingService = new CabBookingServiceImpl(userRepositoryImpl, driverRepositoryImpl);
		try {
			cabBookingService.addUser("Abhishek", "M", 23);
			cabBookingService.addUser("Rahul", "M", 29);
			cabBookingService.addUser("Nandini", "F", 22);

			cabBookingService.addDriver("Driver1", "M", "Swift, KA-01-12345", new int[]{10, 1});
			cabBookingService.addDriver("Driver2", "M", "Swift, KA-01-12345", new int[]{11, 10});
			cabBookingService.addDriver("Driver3", "M", "Swift, KA-01-12345", new int[]{5, 3});

			System.out.println("Finding ride for Abhishek: " + cabBookingService.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}));
			System.out.println("Finding ride for Rahul: " + cabBookingService.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3}));
			System.out.println("Finding ride for Nandini: " + cabBookingService.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4}));

			cabBookingService.chooseRide("Rahul", "Driver1");
		} catch (final Exception e){
			System.err.println("An error occurred: " + e.getMessage());
		}

	}

}
