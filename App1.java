
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of mobiles:");
        int numberOfMobiles = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Mobilemap> mobileList = new ArrayList<>();
        System.out.println("Enter mobile details:");
        for (int i = 0; i < numberOfMobiles; i++) {
            
            String mobileDetail = scanner.nextLine();
            if(mobileDetail==null) {
            	mobileDetail=scanner.nextLine();
            }
            Mobilemap mobile = Mobilemap.createMobile(mobileDetail);
            mobileList.add(mobile);
        }

        System.out.println("Year            No. of Mobiles");
        Map<Date, Integer> yearWiseCount = Mobilemap.yearWiseCount(mobileList);

        SimpleDateFormat yearFormat = new SimpleDateFormat("MMM");
        for (Map.Entry<Date, Integer> entry : yearWiseCount.entrySet()) {
            String year = yearFormat.format(entry.getKey());
            System.out.format("%-15s %d\n", year, entry.getValue());
        }

        scanner.close();
    }
}