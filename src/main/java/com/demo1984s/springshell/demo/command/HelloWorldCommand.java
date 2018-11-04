package com.demo1984s.springshell.demo.command;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.*;

@ShellComponent
@ShellCommandGroup("Hello world Commands: ")
public class HelloWorldCommand {

    /** init status, default value is {@code false} */
    boolean isInit = false;

    /**
     * init commands
     *
     * @param isInit
     */
    @ShellMethod(value = "should call first", key = "init")
    public void init(@ShellOption(defaultValue = "false", help = "the value should be true") String isInit) {
        if ("true".equals(isInit)) {
            this.isInit = true;
        }
    }

    @ShellMethodAvailability("say")
    public Availability availability() {
        return isInit ? Availability.available() : Availability.unavailable(String.format("call %s first!", "init"));
    }

    /**
     * say something
     *
     * @param words
     * @return
     */
    @ShellMethod(value = "say something", key = "say")
    public String say(@ShellOption(defaultValue = "nothing", help = "say something") String words) {
        return String.format("You said: %s", words);
    }

}
