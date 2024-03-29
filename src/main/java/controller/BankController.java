package controller;

import view.InputView;
import view.OutputView;

public class BankController {
    private final InputView inputView;
    private final OutputView outputView;

    public BankController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
