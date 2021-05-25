package bt.cli;

import bt.cli.command.Generate;
import com.github.rvesse.airline.*;
import com.github.rvesse.airline.help.Help;

@com.github.rvesse.airline.annotations.Cli(
        name = "blocktalk",
        description = "Blocktalk - Signum Smart Contract Compiler Tool",
        defaultCommand = Help.class,
        commands = {Generate.class}
)
public class BlocktalkCli {
    public static void main(String[] args) throws Exception {
        Cli<Runnable> cli = new com.github.rvesse.airline.Cli<>(BlocktalkCli.class);
        Runnable cmd = cli.parse(args);
        cmd.run();
    }
}
