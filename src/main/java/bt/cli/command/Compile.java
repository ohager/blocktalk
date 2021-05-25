package bt.cli.command;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Arguments;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Required;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Command(name = "compile", description = "Compiles a Java Smart Contract into CIYAM code")
public class Compile implements Runnable {

    @Required
    @Option(name = { "-c", "--code" }, description = "The Java code to be compiled")
    private String code = "";


    public static void main(String[] args) {
        SingleCommand<Compile> parser = SingleCommand.singleCommand(Compile.class);
        Compile cmd = parser.parse(args);
        cmd.run();
    }

    public void run() {
        System.out.println("Code is " + this.code);
    }
}