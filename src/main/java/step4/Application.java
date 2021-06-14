package step4;

import step4.domain.name.Names;
import step4.util.StringUtility;
import step4.view.InputView;

public class Application {

    public static void main(String[] args) {
        Names names = new Names(StringUtility.splitByComma(InputView.inputNames()));
    }
}
