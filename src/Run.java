import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Run {
    public static void main(String[] args) throws Exception {
//        ANTLRInputStream input = new ANTLRInputStream(System.in);
String st="";
InputStream is=System.in;
Reader r=new InputStreamReader(is);
System.out.println("REPL input:");
while(!st.equals("q")){
    try{
 BufferedReader br=new BufferedReader(r);
 st=br.readLine();
////////////////////////////////////////////////////////////////////////////
//String file = "D:\\NetBeansProjects\\firstAntlr\\build\\classes\\test.ko";
//CharStream cs = new ANTLRFileStream(file);
///////////////////////////////////////////////////////////////////////////
CharStream input = new ANTLRInputStream(st);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.input();

        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        
        if(!st.equals("q")){
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
        }
    }catch(Exception e){
      e.printStackTrace();
    }
}
    }
}
