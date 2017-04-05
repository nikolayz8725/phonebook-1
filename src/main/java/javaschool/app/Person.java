package javaschool.app;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person extends Record {
    private String email;
    private final List<String> phones = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)|| email.contains(str);


    }

    @Command
    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }

    @Command
    public void addPhones(String... phones) {
        this.phones.addAll(Arrays.asList(phones));
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + email + " " + phones;
    }

}
