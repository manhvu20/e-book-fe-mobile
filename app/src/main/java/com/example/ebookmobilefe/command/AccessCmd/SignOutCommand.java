package com.example.ebookmobilefe.command.AccessCmd;

import com.example.ebookmobilefe.command.ICommand;

public class SignOutCommand implements ICommand {
    private Runnable action;
    public SignOutCommand(Runnable action) {
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
