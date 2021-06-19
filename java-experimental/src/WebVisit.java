import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WebVisit {
    private static HashSet<String> visitorsCounter = new HashSet<>();
    private static HashMap<String, VisitorSession> visitorSessions = new HashMap<>();

    /**
     * Given an {@link Iterable} of website hit data modeled as
     * {@link WebsiteVisit} analyze it and return the resulting page views,
     * unique visitors, and sessions.
     *
     * @param websiteVisits Input hit data.
     * @return A 3-element array of long corresponding to
     * 0: page views, 1: unique visitors, 2: view sessions
     * * WebsiteVisit {
     * * 1 12:00
     * * 1 12:10 **
     * * 1 12:45
     * * 2 12:00
     * * }
     */

    static long[] processPageViews(Iterable<WebsiteVisit> websiteVisits) {
        long totalOfVisits = 0;
        for (WebsiteVisit websiteVisit : websiteVisits) {
            totalOfVisits = totalOfVisits + 1;

            if (visitorsCounter.contains(websiteVisit.visitorId)) {
                VisitorSession currentVisSession = visitorSessions.get(websiteVisit.visitorId);
                long prevTimestamp = currentVisSession.timestamp;

                if (hasExpired(websiteVisit.timestamp, prevTimestamp)) {
                    currentVisSession.sessionCount = currentVisSession.sessionCount + 1;
                }
                currentVisSession.timestamp = websiteVisit.timestamp;

            } else {
                visitorsCounter.add(websiteVisit.visitorId);
                visitorSessions.put(websiteVisit.visitorId, new VisitorSession(websiteVisit.visitorId, websiteVisit.timestamp, 1));
            }

        }

        long totalSession = 0;
        for (VisitorSession visitorSession : visitorSessions.values()) {
            totalSession += visitorSession.sessionCount;
        }

        long[] result = {totalOfVisits, (long) visitorsCounter.size(), totalSession};

        return result;
    }

    static boolean hasExpired(long currentTimestamp, long prevTimestamp) {
        final long thirtyInSec = 30 * 60;
        final long diff = currentTimestamp - prevTimestamp;
        return diff > thirtyInSec;

    }


    static class VisitorSession {
        String visitorId;
        long timestamp;
        long sessionCount;

        VisitorSession(String visitorId, long timestamp, long sessionCount) {
            this.visitorId = visitorId;
            this.timestamp = timestamp;
            this.sessionCount = sessionCount;
        }
    }

    static class WebsiteVisit {

        private final String visitorId;
        private final long timestamp;

        WebsiteVisit(String visitorId, long timestamp) {
            this.visitorId = visitorId;
            this.timestamp = timestamp;
        }

        public String getVisitorId() {
            return visitorId;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }

    public static void main(String[] args) {

        List<WebsiteVisit> websiteVisits = new ArrayList<>();

        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 1235));
        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 1326));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 1353));
        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 1481));
        websiteVisits.add(new WebsiteVisit("EwIoSpTy6GsT", 1679));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 1730));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 1834));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 1954));
        websiteVisits.add(new WebsiteVisit("ebAwxkomoUzR", 2020));
        websiteVisits.add(new WebsiteVisit("EwIoSpTy6GsT", 2066));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 2113));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 2141));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 2288));
        websiteVisits.add(new WebsiteVisit("Z64rAEh2t1Mo", 2458));
        websiteVisits.add(new WebsiteVisit("rPrzirT844BE", 2617));
        websiteVisits.add(new WebsiteVisit("S81q57pLwunJ", 2756));
        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 2815));
        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 2899));
        websiteVisits.add(new WebsiteVisit("rPrzirT844BE", 2913));
        websiteVisits.add(new WebsiteVisit("JoJdC7xEhny1", 2970));
        websiteVisits.add(new WebsiteVisit("7jepQ0sXptbZ", 3036));
        websiteVisits.add(new WebsiteVisit("rPrzirT844BE", 3213));
        websiteVisits.add(new WebsiteVisit("Z64rAEh2t1Mo", 3371));
        websiteVisits.add(new WebsiteVisit("QqlNhvV49QWO", 3442));
        websiteVisits.add(new WebsiteVisit("JbU8YAEtT6Wb", 3576));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 3596));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 3769));
        websiteVisits.add(new WebsiteVisit("RLhvlqt6EdGg", 3825));
        websiteVisits.add(new WebsiteVisit("YugyB6mzxsQ2", 3985));
        websiteVisits.add(new WebsiteVisit("YugyB6mzxsQ2", 4045));
        websiteVisits.add(new WebsiteVisit("7jepQ0sXptbZ", 4194));
        websiteVisits.add(new WebsiteVisit("JoJdC7xEhny1", 4331));
        websiteVisits.add(new WebsiteVisit("mRIb1kI6qgKj", 4374));
        websiteVisits.add(new WebsiteVisit("s83pw3QRozal", 4451));
        websiteVisits.add(new WebsiteVisit("Z64rAEh2t1Mo", 4538));
        websiteVisits.add(new WebsiteVisit("AddfeWem55S8", 4652));
        websiteVisits.add(new WebsiteVisit("4l4R5gHSDiI2", 4755));
        websiteVisits.add(new WebsiteVisit("8q2XITAwRLxN", 4892));
        websiteVisits.add(new WebsiteVisit("8i2UBQSCHE4Z", 5091));
        websiteVisits.add(new WebsiteVisit("udxgYLxbCidM", 5156));
        websiteVisits.add(new WebsiteVisit("8biuwmsu8HeQ", 5158));
        websiteVisits.add(new WebsiteVisit("7jepQ0sXptbZ", 5180));
        websiteVisits.add(new WebsiteVisit("ziO05gYQvBlS", 5258));
        websiteVisits.add(new WebsiteVisit("4eOnfbNdZxPi", 5364));
        websiteVisits.add(new WebsiteVisit("2aHQ8YYBQU4w", 5391));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 5401));
        websiteVisits.add(new WebsiteVisit("tLrxYCk6eW6y", 5422));
        websiteVisits.add(new WebsiteVisit("fJhWoFofJmJV", 5564));
        websiteVisits.add(new WebsiteVisit("udxgYLxbCidM", 5656));
        websiteVisits.add(new WebsiteVisit("EwIoSpTy6GsT", 5813));
        websiteVisits.add(new WebsiteVisit("U7bGLSZPr8kC", 5824));
        websiteVisits.add(new WebsiteVisit("tVMcBG3JtFsO", 5837));
        websiteVisits.add(new WebsiteVisit("DeMPWtoLk7MK", 5935));
        websiteVisits.add(new WebsiteVisit("zSPRqmYbiMgS", 6005));
        websiteVisits.add(new WebsiteVisit("co1zpmGBlmRR", 6157));
        websiteVisits.add(new WebsiteVisit("9stDDr4kVwWV", 6212));
        websiteVisits.add(new WebsiteVisit("yKzIPgpPgx6e", 6295));
        websiteVisits.add(new WebsiteVisit("tVMcBG3JtFsO", 6455));
        websiteVisits.add(new WebsiteVisit("co1zpmGBlmRR", 6650));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 6739));
        websiteVisits.add(new WebsiteVisit("DeMPWtoLk7MK", 6907));
        websiteVisits.add(new WebsiteVisit("2zatCQsntMAg", 7006));
        websiteVisits.add(new WebsiteVisit("RvmUKIuUne97", 7116));
        websiteVisits.add(new WebsiteVisit("jMKz7H2PCloz", 7290));
        websiteVisits.add(new WebsiteVisit("B3AYFm64WHYY", 7404));
        websiteVisits.add(new WebsiteVisit("bymyzzCpVfaP", 7556));
        websiteVisits.add(new WebsiteVisit("BrgLyp7nXe0g", 7689));
        websiteVisits.add(new WebsiteVisit("8FiU0AI9yqbK", 7860));
        websiteVisits.add(new WebsiteVisit("QqlNhvV49QWO", 7880));
        websiteVisits.add(new WebsiteVisit("B1G2ThpwiYDE", 7992));
        websiteVisits.add(new WebsiteVisit("B3AYFm64WHYY", 8178));
        websiteVisits.add(new WebsiteVisit("kmMzjYYdDHpr", 8340));
        websiteVisits.add(new WebsiteVisit("vN9k02X30aCE", 8374));
        websiteVisits.add(new WebsiteVisit("im6J6JbfWIMt", 8448));
        websiteVisits.add(new WebsiteVisit("fIa4Gt8GAVYz", 8460));
        websiteVisits.add(new WebsiteVisit("TZ09YyoVoDyx", 8647));
        websiteVisits.add(new WebsiteVisit("9stDDr4kVwWV", 8650));
        websiteVisits.add(new WebsiteVisit("KOaqVdXNAt8d", 8689));
        websiteVisits.add(new WebsiteVisit("co1zpmGBlmRR", 8701));
        websiteVisits.add(new WebsiteVisit("L0qxqltsVMZT", 8782));
        websiteVisits.add(new WebsiteVisit("8biuwmsu8HeQ", 8934));
        websiteVisits.add(new WebsiteVisit("B1G2ThpwiYDE", 9121));
        websiteVisits.add(new WebsiteVisit("loJJqJeeoOXx", 9277));
        websiteVisits.add(new WebsiteVisit("f8ZUFAz3CfjX", 9280));
        websiteVisits.add(new WebsiteVisit("kmMzjYYdDHpr", 9420));
        websiteVisits.add(new WebsiteVisit("hGTFrpSSAXWx", 9476));
        websiteVisits.add(new WebsiteVisit("cBrFMDmKXYcB", 9553));
        websiteVisits.add(new WebsiteVisit("fIa4Gt8GAVYz", 9619));
        websiteVisits.add(new WebsiteVisit("u4XiIPXlVS3V", 9795));
        websiteVisits.add(new WebsiteVisit("ziO05gYQvBlS", 9811));
        websiteVisits.add(new WebsiteVisit("6wDyoz00S6Ru", 9944));
        websiteVisits.add(new WebsiteVisit("vN9k02X30aCE", 9968));
        websiteVisits.add(new WebsiteVisit("ydcm3DzmoxLR", 10060));
        websiteVisits.add(new WebsiteVisit("KOaqVdXNAt8d", 10246));
        websiteVisits.add(new WebsiteVisit("916rq07r66oK", 10445));
        websiteVisits.add(new WebsiteVisit("S81q57pLwunJ", 10636));
        websiteVisits.add(new WebsiteVisit("lG9CU9UiaEp3", 10691));
        websiteVisits.add(new WebsiteVisit("ljVmM1MUHkQT", 10841));
        websiteVisits.add(new WebsiteVisit("kmMzjYYdDHpr", 10964));
        websiteVisits.add(new WebsiteVisit("B3AYFm64WHYY", 11123));

        long [] res = processPageViews(websiteVisits);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}


