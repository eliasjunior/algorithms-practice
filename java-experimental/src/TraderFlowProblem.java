import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TraderFlowProblem {
    private static int calculationIntervalMillis;
    private final Map<Integer, Trade> privateTradeList = new HashMap<>();
    private final Map<Integer, Trade> publicTradeList = new HashMap<>();

    public TraderFlowProblem(int calculationIntervalMillis) {
        this.calculationIntervalMillis = calculationIntervalMillis;
    }

    public void onPrivateTrade(int price, int size, long timestampMillis) {
        //presume size is qtd as the exercise does not mention
        Trade trade = new Trade(price, size, timestampMillis);
        Trade inTrade = this.privateTradeList.get(price);
        if(inTrade != null) {
            trade.qty = trade.qty + 1;
        }
        this.privateTradeList.put(price, trade);
    }
    public void onPublicTrade(int price, int size, long timestampMillis) {
        Trade trade = new Trade(price, size, timestampMillis);
        Trade inTrade = this.publicTradeList.get(price);
        if(inTrade != null) {
            trade.qty = inTrade.qty + 1;
        }
        this.publicTradeList.put(price, trade);
    }

    public double calculateMissedVolumeFraction() {
        int sumPrivateMatched = 0;
        int sumPublicMatched = 0;
        for (Trade privateTrade:
                privateTradeList.values()) {
            Trade publicMatchedTrade = this.publicTradeList.get(privateTrade.price);

            if(publicMatchedTrade != null) {
                if(isInInterval(privateTrade.timestamp, publicMatchedTrade.timestamp)) {
                    //publicMatchedTrade.timestamp == privateTrade.timestamp, why the interval then ?
                    if(publicMatchedTrade.qty >= privateTrade.qty && publicMatchedTrade.timestamp == privateTrade.timestamp) {
                        int publicVol = publicMatchedTrade.price * publicMatchedTrade.qty;
                        int privateVol = privateTrade.price * privateTrade.qty;
                        sumPublicMatched +=  publicVol;
                        sumPrivateMatched += privateVol;
                    }
                }
            }

        }
        if(sumPublicMatched <= 0 || sumPrivateMatched <= 0) {
            return Double.NaN;
        }
        return roundUp5((double)sumPrivateMatched/(double)sumPublicMatched);
    }

    public static boolean isInInterval(long prevTimestampDate, long currentTimestampDate) {
        long diff = currentTimestampDate - prevTimestampDate;
        return diff <= calculationIntervalMillis;
    }

    private double roundUp5(double value) {
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(df.format(value));
    }

    private class Trade {
        private int price;
        private int qty;
        private long timestamp;

        public Trade(int price, int qty, long timestamp) {
            this.price = price;
            this.qty = qty;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        TraderFlowProblem traderFlowProblem = new TraderFlowProblem(2000);

        //private
        traderFlowProblem.onPrivateTrade(5, 9,  convertTimestamp("15 31 00 001"));
        traderFlowProblem.onPrivateTrade(5, 9,  convertTimestamp("15 31 00 001"));
        traderFlowProblem.onPrivateTrade(6, 10,  convertTimestamp("15 31 01 001"));

        //public
        traderFlowProblem.onPublicTrade(5, 19,  convertTimestamp("15 31 00 001"));
        traderFlowProblem.onPublicTrade(5, 19,  convertTimestamp("15 31 00 001"));

        traderFlowProblem.onPublicTrade(7, 99,  convertTimestamp("15 31 00 500"));
        traderFlowProblem.onPublicTrade(7, 99,  convertTimestamp("15 31 00 500"));

        traderFlowProblem.onPublicTrade(6, 20,  convertTimestamp("15 31 01 001"));
        traderFlowProblem.onPublicTrade(6, 20,  convertTimestamp("15 31 01 001"));

        System.out.println("Result " + traderFlowProblem.calculateMissedVolumeFraction());
    }

    /**
        Date format
        15:31:00 001
        15:31:00 500
     */
    private static long convertTimestamp(String strDate) {
        String [] units = strDate.split(" ");
        int hour =  Integer.parseInt(units[0]);
        int minute =  Integer.parseInt(units[1]);
        int second =  Integer.parseInt(units[2]);
        int nano =  Integer.parseInt(units[3]);

        LocalDateTime toDateTime = LocalDateTime.of(2021, 5, 29,hour, minute, second, nano);
        Timestamp timestamp = Timestamp.valueOf(toDateTime);
        return timestamp.getTime();
    }
}
