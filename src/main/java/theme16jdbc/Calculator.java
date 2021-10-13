package theme16jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import theme16jdbc.entety.Fibonachi;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public List<Integer> fibonachi(int n) {
        List<Integer> result = new ArrayList<>();
        if (n > 46 || n < 0) {
            System.out.println("Number is out of range: '0 - 46'");
            return result;
        } else {
            if (n < 2) {
                result.add(0, 0);
                result.add(1, 1);
                return result;
            }
            result.add(0, 0);
            result.add(1, 1);
            for (int i = 2; i <= n; i++) {
                result.add(i, result.get(i - 1) + result.get(i - 2));
            }


            return result;
        }
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        List<Integer> listFibo = calculator.fibonachi(46);
        System.out.println(listFibo);


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Fibonachi.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            for (int i = 0; i < listFibo.size(); i++) {
                Fibonachi fibonachi = new Fibonachi(i, listFibo.get(i));
                session.save(fibonachi);
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }
}

