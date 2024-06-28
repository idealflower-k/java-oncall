package oncall.inpput;

import camp.nextstep.edu.missionutils.Console;
import oncall.model.worker.WorkList;
import oncall.model.worker.WorkerManger;

import java.util.ArrayList;

public class WorkerInput {

    private static WorkerInput instance;

    private final int minWorker = 5;
    private final int maxWorker = 35;
    private final int maxNameLen = 5;

    private WorkerInput() {
    }

    public static WorkerInput getInstance() {
        if (instance == null) {
            instance = new WorkerInput();
            return instance;
        }
        return instance;
    }

    public WorkerManger createWorkerManagerFromInput() {
        while (true) {
            try {
                ArrayList<String> weekList = getWeekFromInput();
                ArrayList<String> holiList = getHoliFromInput();

                WorkList workers = new WorkList(weekList, holiList);
                return new WorkerManger(workers);
            } catch (IllegalArgumentException exception) {
                System.out.println(EnumError.ERROR_HEADER.getMessage() + " " + EnumError.ERROR_BODY.getMessage());
            }
        }
    }

    private ArrayList<String> getHoliFromInput() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return input();
    }

    private ArrayList<String> getWeekFromInput() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return input();
    }

    private ArrayList<String> input() {
        ArrayList<String> list;

        String line = Console.readLine();
        String[] split = line.split(",");

        return getList(split);
    }

    private ArrayList<String> getList(String[] split) throws IllegalArgumentException {
        ArrayList<String> list;
        if (split.length < minWorker || split.length > maxWorker) {
            throw new IllegalArgumentException();
        }

        list = new ArrayList<>();
        for (String name : split) {
            if (name.length() > maxNameLen || !isDuplicate(list, name)) {
                throw new IllegalArgumentException();
            }
            list.add(name);
        }
        return list;
    }

    private boolean isDuplicate(ArrayList<String> list, String target) {
        for (String s : list) {
            if (s.equals(target)) {
                return false;
            }
        }
        return true;
    }
}
