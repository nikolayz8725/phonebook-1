package javaschool.app;

public class Reminder extends Note {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return super.toString() + " " + time;
    }

}
