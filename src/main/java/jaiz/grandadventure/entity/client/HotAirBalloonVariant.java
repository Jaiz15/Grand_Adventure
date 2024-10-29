package jaiz.grandadventure.entity.client;

import java.util.Arrays;
import java.util.Comparator;

public enum HotAirBalloonVariant {
    RED(0),
    PURPLE(1),
    BLUE(2),
    GREEN(3),
    ORANGE(4),
    PINK(5);

    private static final HotAirBalloonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HotAirBalloonVariant::getId)).toArray(HotAirBalloonVariant[]::new);
    private final int id;

    HotAirBalloonVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static HotAirBalloonVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
