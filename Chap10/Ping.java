import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Ping {
public static void commands(ArrayList<String> commandList) {
try {
ProcessBuilder processBuilder = new ProcessBuilder(commandList);
Process process = processBuilder.start();
BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
String line;
while ((line = reader.readLine()) != null) {
System.out.println(line);
}
int exitCode = process.waitFor();
System.out.println("\nPing command exited with code: " +
exitCode);
} catch (Exception e) {
System.out.println("Error executing command: " +
e.getMessage());
e.printStackTrace();
}
}
public static void main(String[] args) {
ArrayList<String> command = new ArrayList<>();
command.add("ping");
command.add("www.google.com");
commands(command);
}
}