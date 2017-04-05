package javaschool.app;

import asg.cliche.Command;

public abstract class Record {
    private static int count = 0;
    private int id;
    private String name;

    public Record() {
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Command
    public void setName(String name) {
        this.name = name;
    }

    public boolean contains(String str) {
        return name.contains(str);
    }


}
