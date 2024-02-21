package ladder.domain;

import java.util.Collections;
import java.util.List;
//TODO package 이동
public class RowLine {
    private static final int MIN_PEOPLE_NUMBER=1;
    private static final int MAX_PEOPLE_NUMBER=100;
    private final List<Boolean> connection = new ArrayList<>();

    public RowLine(int peopleNumber, LineGenerator generator) {
        validatePeopleNumber(peopleNumber);
        List<Boolean> generatedConnection = generator.getLine(peopleNumber);
        validateSuccessiveLine(generatedConnection);
        this.connection.addAll(generatedConnection);
    }

    private static void validatePeopleNumber(int peopleNumber) {
        if (peopleNumber < MIN_PEOPLE_NUMBER || peopleNumber > MAX_PEOPLE_NUMBER) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하의 사람 수 입니다.");
        }
    }

    public List<Boolean> getConnection() {
        return Collections.unmodifiableList(connection);
    }

    private void validateSuccessiveLine(List<Boolean> booleans) {
        Boolean flag = Boolean.FALSE;
        for (Boolean b : booleans) {
            if (flag && b) {
                throw new IllegalArgumentException("사다리 가로선이 연속되었습니다.");
            }
            flag = b;
        }
    }

}