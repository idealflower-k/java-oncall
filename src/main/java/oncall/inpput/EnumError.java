package oncall.inpput;

public enum EnumError {
    ERROR_HEADER ("[ERROR]"),
    ERROR_BODY ("유효하지 않은 입력 값입니다.다시 입력해 주세요.");

    private final String message;

    EnumError(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }

}
