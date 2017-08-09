
public class Animals {
    String kind;
    int points;
    private boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

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
