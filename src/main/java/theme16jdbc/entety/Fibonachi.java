package theme16jdbc.entety;

import javax.persistence.*;

@Entity
@Table(name = "fibonachi")
public class Fibonachi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "fibo")
    private int fibo;

    public Fibonachi() {
    }

    public Fibonachi(int number, int fibo) {
        this.number = number;
        this.fibo = fibo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFibo() {
        return fibo;
    }

    public void setFibo(int fibo) {
        this.fibo = fibo;
    }

    @Override
    public String toString() {
        return "Fibonachi{" +
                "id=" + id +
                ", number=" + number +
                ", fibo=" + fibo +
                '}';
    }
}
