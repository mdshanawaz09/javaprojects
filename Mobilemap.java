
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mobilemap {
    private String referenceId;
    private String modelName;
    private Double displaySize;
    private Double price;
    private Date launchedDate;

    public Mobilemap() {
    }

    public Mobilemap(String referenceId, String modelName, Double displaySize, Double price, Date launchedDate) {
        this.referenceId = referenceId;
        this.modelName = modelName;
        this.displaySize = displaySize;
        this.price = price;
        this.launchedDate = launchedDate;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Double displaySize) {
        this.displaySize = displaySize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getLaunchedDate() {
        return launchedDate;
    }

    public void setLaunchedDate(Date launchedDate) {
        this.launchedDate = launchedDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return String.format("%-15s %s\n", dateFormat.format(launchedDate), modelName);
    }

    public static Mobilemap createMobile(String detail) throws ParseException {
        String[] mobileDetails = detail.split(",");
        String referenceId = mobileDetails[0];
        String modelName = mobileDetails[1];
        Double displaySize = Double.parseDouble(mobileDetails[2]);
        Double price = Double.parseDouble(mobileDetails[3]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date launchedDate = dateFormat.parse(mobileDetails[4]);
        return new Mobilemap(referenceId, modelName, displaySize, price, launchedDate);
    }

    public static Map<Date, Integer> yearWiseCount(List<Mobilemap> mobileList) {
        Map<Date, Integer> countMap = new TreeMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");

        for (Mobilemap mobile : mobileList) {
            Date year = null;
            try {
                year = dateFormat.parse(dateFormat.format(mobile.getLaunchedDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            countMap.put(year, countMap.getOrDefault(year, 0) + 1);
        }

        return countMap;
    }
}