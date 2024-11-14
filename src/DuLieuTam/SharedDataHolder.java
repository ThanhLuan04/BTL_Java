package DuLieuTam;

public class SharedDataHolder {
    private static SharedData sharedData;

    public static void setSharedData(SharedData data) {
        sharedData = data;
    }

    public static SharedData getSharedData() {
        return sharedData;
    }
}


