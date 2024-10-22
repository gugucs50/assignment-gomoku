public class hanoi {
    public static void main(String[] args) {
        int x = 2;
        String pilMain = "Main", pilMem = "Mem", pilEnd = "End";
        sort(x, pilMain, pilEnd, pilMem);
    }

    public static void sort(int hoop, String main, String end, String mem) {
        if (hoop == 1) {
            System.out.printf("\nThe disk 1 is moved from %s to %s.", main, end);
            return;
        }
        
        sort(hoop - 1, main, mem, end);
        System.out.printf("\nThe disk %d is moved from %s to %s.", hoop, main, end);
        sort(hoop - 1, mem, end, main);
    }
}
