package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shivparmar01 on 08-02-2016. A hotel manager has to process N advance bookings of rooms for the next
 * season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether
 * there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log
 * N) .
 * 
 * Input:
 *
 * First list for arrival time of booking. Second list for departure time of booking. Third is K which denotes count of
 * rooms.
 * 
 * Output:
 * 
 * A boolean which tells whether its possible to make a booking. Return 0/1 for C programs. O -> No there are not enough
 * rooms for N booking. 1 -> Yes there are enough rooms for N booking. Example :
 * 
 * Input : Arrivals : [1 3 5] Departures : [2 6 8] K : 1
 * 
 * Return : False / 0
 * 
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class Hotel {
    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(40, 18));
        ArrayList<Integer> departure = new ArrayList<Integer>(Arrays.asList(40, 43));
        int K = 9;

        System.out.println(new Hotel().hotel(arrive, departure, K));
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int[] room = new int[K];
        boolean booked = true;
        int arrival;
        int departure;
        ArrayList<Booking> bookings = new ArrayList<>(arrive.size());
        for (int i = 0; i < arrive.size(); i++) {
            bookings.add(new Booking(arrive.get(i), depart.get(i)));
        }
        Collections.sort(bookings);

        for (int i = 0; i < bookings.size(); i++) {
            booked = false;
            arrival = bookings.get(i).getArrival();
            departure = bookings.get(i).getDeparture();
            for (int j = 0; j < room.length; j++) {
                if (arrival == departure) {
                    booked = true;
                    break;
                }
                if (room[j] <= arrival) {
                    room[j] = departure;
                    booked = true;
                    break;
                }
            }
            if (!booked) {
                return booked;
            }
        }
        return booked;
    }

    class Booking implements Comparable<Booking> {
        private int arrival;
        private int departure;

        public Booking(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        /**
         * @return departure The departure
         */
        public int getDeparture() {
            return departure;
        }

        /**
         * @param departure
         *            The departure to set
         */
        public void setDeparture(int departure) {
            this.departure = departure;
        }

        @Override
        public String toString() {
            return "Booking{" + "arrival=" + arrival + ", departure=" + departure + '}';
        }

        @Override
        public int compareTo(Booking o) {
            return this.getArrival() - o.getArrival();
        }

        /**
         * @return arrival The arrival
         */
        public int getArrival() {
            return arrival;
        }

        /**
         * @param arrival
         *            The arrival to set
         */
        public void setArrival(int arrival) {
            this.arrival = arrival;
        }
    }
}
