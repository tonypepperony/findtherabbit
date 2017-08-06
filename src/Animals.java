
public class Animals {
    String kind;
    int points;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    void action() throws InterruptedException {
        System.out.println("Action");
    }
}
