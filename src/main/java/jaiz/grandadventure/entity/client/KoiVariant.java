package jaiz.grandadventure.entity.client;

import java.util.Arrays;
import java.util.Comparator;

public enum KoiVariant {
    KOI_1(0),
    KOI_2(1),
    KOI_3(2),
    KOI_4(3),
    KOI_5(4),
    KOI_6(5),
    KOI_7(6),
    KOI_8(7),
    KOI_9(8),
    KOI_10(9);

    private static final KoiVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(KoiVariant::getId)).toArray(KoiVariant[]::new);
    private final int id;

    KoiVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static KoiVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
