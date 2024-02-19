package com.example.ebookmobilefe.command.AccessCmd;

import com.example.ebookmobilefe.command.ICommand;

public class LoginCommand implements ICommand {
    private Runnable action;
    public LoginCommand(Runnable action) {
        this.action = action;
    }
    @Override
    public void execute() {
        if (action != null) {
            action.run();
        }
    }

    public boolean canExecute() {
        return action != null;
    }
}
