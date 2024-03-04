package com.example.ebookmobilefe.command.AccessCmd;

@FunctionalInterface
public interface SubmitLoginCommand {
    void execute(String username, String password);
}
