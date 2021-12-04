package lapr.project.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;



public class Utils {

    private Utils() {
        //private constructor
    }

    public static String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    public static int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    public static void showList(List list, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }

    public static Object selectsObject(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    public static int selectsIndex(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }
}
