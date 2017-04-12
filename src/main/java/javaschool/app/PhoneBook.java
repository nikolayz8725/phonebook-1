package javaschool.app;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.util.*;

public class PhoneBook implements ShellDependent {
    private Map<Integer, Record> recordList = new HashMap<>();

    @Command
    public void createPerson(String name, String email, String... phones) {
        Person r = new Person();
        r.setName(name);
        r.setEmail(email);
        r.addPhones(phones);
        recordList.put(r.getId(), r);
    }

    @Command
    public void createNote(String name, String txt) {
        Note note = new Note();
        note.setNote(txt);
        note.setName(name);
        recordList.put(note.getId(), note);
    }

    @Command
    public void createReminder(String name, String txt, String time) {
        Reminder rem = new Reminder();
        rem.setName(name);
        rem.setNote(txt);
        rem.setTime(time);
        recordList.put(rem.getId(), rem);
    }

    @Command
    public Collection<Record> list() {
        return recordList.values();
    }

    @Command
    public void addPhone(int id, String phone) {
        Record r = recordList.get(id);
        if (r instanceof Person) {
            Person p = (Person) r;
            p.addPhones(phone);
        }
    }

    @Command
    public Record show(int id) {
        return recordList.get(id);
    }

    @Command
    public void edit(int id) throws IOException {
        Record r = recordList.get(id);

        ShellFactory.createSubshell("#" + id, theShell, "Edit record", r)
                .commandLoop();
    }

    @Command
    public List<Record> find(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordList.values()) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    private Shell theShell;

    public void cliSetShell(Shell theShell) {
        this.theShell = theShell;
    }
}
