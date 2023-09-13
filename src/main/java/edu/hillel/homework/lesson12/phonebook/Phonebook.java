package edu.hillel.homework.lesson12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private final List<Record> recordsList;

    public Phonebook() {
        recordsList = new ArrayList<>();
    }

    public void add(Record record) {
        if (!isUserWithSameNameAndPhoneNumberExist(record.getName(), record.getPhone())) {
            recordsList.add(record);
        }
    }

    public Record find(String name) {
        for (Record record : recordsList) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : recordsList) {
            if (record.getName().equalsIgnoreCase(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? null : foundRecords;
    }

    private boolean isUserWithSameNameAndPhoneNumberExist(String name, String phone) {
        for (Record r : recordsList) {
            if (r.getName().equalsIgnoreCase(name) && r.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (!recordsList.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < recordsList.size(); i++) {
                result
                        .append((i == 0) ? "[\n " : " ")
                        .append(recordsList.get(i))
                        .append((i < recordsList.size() - 1) ? ",\n" : "\n]");
            }
            return result.toString();
        }
        return null;
    }
}
