package oncall.model.calendar;

public enum DayEnum {
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일");

    private final String koreanName;

    DayEnum(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public static boolean containsKoreaName(String target) {
        for (DayEnum value : values()) {
            if (value.getKoreanName().equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static DayEnum getByKoreaName(String koreanName) throws IllegalArgumentException {
        for (DayEnum value : values()) {
            if (value.getKoreanName().equals(koreanName)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

    public DayEnum next(DayEnum day) {
        DayEnum[] values = DayEnum.values();
        int nextIdx = (this.ordinal() + 1) % values.length;
        return values[nextIdx];
    }
}
