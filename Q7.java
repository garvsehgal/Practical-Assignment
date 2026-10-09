public class Q7 {
    static int availableSeats = 2;

    static synchronized void bookSeat(String user, int seats) {
        if (seats <= availableSeats) {
            System.out.println(
                user + " booked " + seats + " seat(s) successfully"
            );
            availableSeats -= seats;
        } else {
            System.out.println(
                user + " booking failed. Not enough seats"
            );
        }
    }

    static class User1 extends Thread {
        public void run() {
            bookSeat("User1", 1);
        }
    }

    static class User2 extends Thread {
        public void run() {
            bookSeat("User2", 2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        User1 u1 = new User1();
        User2 u2 = new User2();

        u1.start();
        u1.join();

        u2.start();
        u2.join();
    }
}
