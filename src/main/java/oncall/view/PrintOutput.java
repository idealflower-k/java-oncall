package oncall.view;

import oncall.model.Output.Output;

import java.util.ArrayList;

public class PrintOutput {
    public PrintOutput() {
    }

    public static void printOutput(ArrayList<Output> outputs) {
        for (Output output : outputs) {
            int month = output.getMonth();
            int dayNum = output.getDayNum();
            String day = output.getDay().getKoreanName();
            boolean isHoliday = output.isHoliday();
            String worker = output.getWorker();
            System.out.print(month + "월" + " " + dayNum + "일 " + day);
            if (isHoliday) {
                System.out.print("(휴일)");
            }
            System.out.println(" " + worker);
        }
    }
}
