import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Token {
    private String tokenType;
    private Object value;

    public Token(String tokenType, Object value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Object getValue() {
        return value;
    }
}

public class Lexer {
    private String sourceCode;
    private int position;
    private Set<String> keywords = new HashSet<>();

    public Lexer(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
            StringBuilder sourceCodeBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sourceCodeBuilder.append(line).append("\n");
            }
            sourceCode = sourceCodeBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize the set of keywords
        String[] keywordArray = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
            "finally", "float", "for", "if", "goto", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while"};
        for (String keyword : keywordArray) {
            keywords.add(keyword);
        }
    }

    public void analyze() {
        while (position < sourceCode.length()) {
            char currentChar = sourceCode.charAt(position);
            if (currentChar == '"' || currentChar == '\'') {
                char stringDelimiter = currentChar;
                int endIndex = sourceCode.indexOf(stringDelimiter, position + 1);
                if (endIndex == -1) {
                    throw new RuntimeException("Unclosed string");
                }
                String stringLiteral = sourceCode.substring(position + 1, endIndex);
                position = endIndex + 1;
                System.out.println("STRING" + " : " + stringLiteral);
            } else if (Character.isLetter(currentChar) || currentChar == '_') {
                Pattern identifierPattern = Pattern.compile("[a-zA-Z_]\\w*");
                Matcher matcher = identifierPattern.matcher(sourceCode.substring(position));
                if (matcher.find()) {
                    String identifier = matcher.group();
                    position += identifier.length();
                    if (keywords.contains(identifier)) {
                        System.out.println("KEYWORD" + " : " + identifier);
                    } else {
                        System.out.println("IDENTIFIER" + " : " + identifier);
                    }
                }
            } else if (Character.isDigit(currentChar)) {
                Pattern numberPattern = Pattern.compile("\\d+");
                Matcher matcher = numberPattern.matcher(sourceCode.substring(position));
                if (matcher.find()) {
                    String numberStr = matcher.group();
                    position += numberStr.length();
                    int number = Integer.parseInt(numberStr);
                    System.out.println("NUMBER" + " : " + number);
                }
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' ||
                    currentChar == '/' || currentChar == '=' || currentChar == '<' || currentChar == '>') {
                Pattern operatorPattern = Pattern.compile("[+\\-*/=<>]+");
                Matcher matcher = operatorPattern.matcher(sourceCode.substring(position));
                if (matcher.find()) {
                    String operator = matcher.group();
                    position += operator.length();
                    System.out.println("OPERATOR" + " : " + operator);
                }
            } else if (Character.isWhitespace(currentChar)) {
                position++;
            } else {
                char punctuation = currentChar;
                position++;
                System.out.println("PUNCTUATION" + " : " + punctuation);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "Functions.java"; // Replace with the path to your Java file
        Lexer lexer = new Lexer(filePath);
        lexer.analyze();
    }
}
