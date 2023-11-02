package application.demo3;

import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        JLanguageTool langTool = new JLanguageTool(Languages.getLanguageForShortCode("en-US"));
        // comment in to use statistical ngram data:
        //langTool.activateLanguageModelRules(new File("/data/google-ngram-data"));
        List<RuleMatch> matches = langTool.check("A sentence with a error in the Hitchhiker's Guide tot he Galaxy");
        for (RuleMatch match : matches) {
            System.out.println("Potential error at characters " +
                    match.getFromPos() + "-" + match.getToPos() + ": " +
                    match.getMessage());
            System.out.println("Suggested correction(s): " +
                    match.getSuggestedReplacements());
        }
    }
}
