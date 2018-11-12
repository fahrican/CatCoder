import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddictiveGame {

    public static void main(String[] args) throws IOException {

        readFile();
    }

    private static void readFile() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\f.can\\IdeaProjects\\JavaTest\\src\\level1-3.in"));
        try {

            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

            String[] matrix = sb.toString().trim().split(" ");
            List<Integer> testList = saveNumbers(matrix);
            printNumbers(testList);

        } catch (IOException ioe) {

            System.out.println(ioe.getMessage());
        } finally {
            bufferedReader.close();
        }
    }

    private static List<Integer> saveNumbers(String[] numbers) {

        List<Integer> numbersList = new ArrayList<>();
        for (String number : numbers) {
            numbersList.add(Integer.parseInt(number));
        }
        return numbersList;
    }

    private static void printNumbers(List<Integer> numbers) {

        int columns = numbers.get(1);

        for (int i = 3; i < numbers.size(); i++) {

            Integer cellValue = numbers.get(i);
            int row = calculateRowNumber(cellValue, columns);
            int column = calculateColumn(cellValue, columns, row);
            System.out.print(row + " " + column + " ");
        }
    }

    private static Integer calculateRowNumber(Integer cellValue, Integer columns) {

        if (cellValue % columns == 0) {
            return cellValue / columns;
        }
        return cellValue / columns + 1;
    }

    private static int calculateColumn(int cellValue, int columns, int row) {

        return columns - (columns * row - cellValue);
    }
}
