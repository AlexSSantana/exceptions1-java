package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(input.next());

		if (checkOut.before(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Resevertion: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(input.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else if (checkOut.before(checkIn)) {

			} else {
				reservation.updatesDates(checkIn, checkOut);
				System.out.println("Resevertion: " + reservation);
			}

		}

		input.close();
	}

}
