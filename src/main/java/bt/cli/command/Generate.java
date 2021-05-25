package bt.cli.command;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Arguments;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.OptionType;
import com.github.rvesse.airline.annotations.restrictions.AllowedRawValues;
import com.github.rvesse.airline.annotations.restrictions.Pattern;
import com.github.rvesse.airline.annotations.restrictions.Required;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

@Command(name = "generate", description = "Generates Java Smart Contract code")
public class Generate implements Runnable {

    private final static String RAW = "raw";
    private final static String NFT = "nft";

    @Required()
    @AllowedRawValues(allowedValues = {RAW,NFT})
    @Option(
            type = OptionType.COMMAND,
            name = { "-t", "--type" },
            description = "The type of the contract",
            title = "Contract Type:" + RAW + "|" + NFT
    )
    private String type = RAW;

    @Option(
            type = OptionType.COMMAND,
            name = { "-n", "--name" },
            description = "The name of the output file"
    )
    @Pattern(pattern = "^[A-Z][\\a-zA-Z]+[\\$\\w]*$")
    private String name = "MyContract";

    public static void main(String[] args) {
        SingleCommand<Generate> parser = SingleCommand.singleCommand(Generate.class);
        Generate cmd = parser.parse(args);
        cmd.run();
    }

    public String getName(String nameArg) {
        return StringUtils.remove(WordUtils.capitalizeFully(nameArg, '_'), "_");
    }

    public void run() {
        System.out.println("Type is " + this.type);
        System.out.println("Name is " + this.name);
    }
}