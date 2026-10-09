public class Q8 {
    static class PrinterJob implements Runnable {
        int jobNumber;
        String student;

        PrinterJob(int jobNumber, String student) {
            this.jobNumber = jobNumber;
            this.student = student;
        }

        public void run() {
            System.out.println(
                "Printing job " + jobNumber + " by " + student
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrinterJob(1, "Student A"));
        Thread t2 = new Thread(new PrinterJob(2, "Student B"));
        Thread t3 = new Thread(new PrinterJob(3, "Student C"));

        t1.start();
        t2.start();
        t3.start();
    }
}
