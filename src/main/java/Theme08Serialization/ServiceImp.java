package Theme08Serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceImp implements Service {
    @Override
    public List<String> run(String item, double value, Date date)  {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 700; i++){
            String s = item + " " + value + " " +  ((date.getTime() + i));
            result.add(s);
        }
        return result;
    }

    @Override
    public List<String> work(String item) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            result.add(item + " - " + i);
        }
        try {
            System.out.println("Calculating in progress..");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Don't touch me!");
        }
        return result;
    }

    @Override
    public int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int result = number;
        do {
            result = result * (number - 1);
            number--;
        } while (number > 1);
        return result;
    }


}
