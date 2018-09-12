/**
 * @author : SreeGayathri.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {

    private String movieName;
    private String showDate;
    private String[] seats;

    Show(final String mviename, final String shwdate, final String[] seats1) {
        this.movieName = mviename;
        this.showDate = shwdate;
        this.seats = seats1;
    }
    public String getMovieName() {
        return this.movieName;
    }
    public String getShowDate() {
        return this.showDate;
    }
    public String[] getSeats() {
        return this.seats;
    }
    public String printExceptTickets() {
        String s = "";
        s += movieName + "," + showDate;
        return s;
    }
    public String toString() {
        String s = "";
        s += movieName + "," + showDate + ",";
        s += Arrays.toString(seats).replace(", ", ",");
        return s;
    }
}


class Patron {

    private String patronname;

    private String mobileNumber;

    private String[] bookedseats;


    Patron(final String name,
        final String phnnum, final String[] booked) {
        this.patronname = name;
        this.mobileNumber = phnnum;
        this.bookedseats = booked;
    }

    public String getPatronname() {
        return this.patronname;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String[] getBookedseats() {
        return this.bookedseats;
    }

    public String toString() {
        String s = "";
        return s;
    }
}


class BookYourShow {

    private Show[] shows;
    private Patron[] patrons;
    private int showsize;
    private int patronsize;

    private static final int TEN = 10;

    BookYourShow() {
        shows = new Show[TEN];
        patrons = new Patron[TEN];
        showsize = 0;
        patronsize = 0;
    }

    public void showresize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
    }

    public void patronresize() {
        patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }

    public void addAShow(final Show nshow) {
        if (showsize == shows.length) {
            showresize();
        }
        shows[showsize++] = nshow;
    }


    public void addAPatron(final Patron npatron) {
        if (patronsize == patrons.length) {
            patronresize();
        }
        patrons[patronsize++] = npatron;
    }

    public Show getAShow(final String movieName, final String showDate) {
        for (int i = 0; i < showsize; i++) {
            if (shows[i].getMovieName().equals(movieName)
                && shows[i].getShowDate().equals(showDate)) {
                return shows[i];
            }
        }
        return null;
    }

    public void bookAShow(final String movieName,
        final String showDate, final Patron p) {
        addAPatron(p);
        Show availableshow = getAShow(movieName, showDate);
        if (availableshow != null) {
            String[] seats = availableshow.getSeats();
            String[] bookedseats = p.getBookedseats();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < bookedseats.length; j++) {
                    if (seats[i].equals(bookedseats[j])
                        && !seats[i].equals("N/A")) {
                        seats[i] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }

    public String printTickets(final String movieName,
        final String showDate, final String mobileNumber) {
        Show show = getAShow(movieName, showDate);
        String str = "Invalid";
        if (show != null) {
            str = "No show";
            for (int j = 0; j < patronsize; j++) {
                str = "Invalid";
                if (patrons[j].getMobileNumber().
                    equals(mobileNumber)) {
                    str = mobileNumber + " "
                    + movieName + " " + showDate;
                    return str;
                }
            }
        }
        return str;
    }

    public void showAll() {
        for (int i = 0; i < showsize; i++) {
            System.out.println(shows[i]);
        }
    }
}

public final class Solution {

    private Solution() {

    }

    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.printExceptTickets());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                System.out.println(bys.printTickets(
                    check[1], tokens[1], tokens[2]));
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
