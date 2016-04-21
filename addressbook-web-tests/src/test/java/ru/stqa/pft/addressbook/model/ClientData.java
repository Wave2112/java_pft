package ru.stqa.pft.addressbook.model;

public class ClientData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String fax;
    private final String date;
    public final String annyversary;
    public final String group;


    public ClientData(String firstName, String middleName, String lastName, String nickName,
                      String company, String address, String home, String mobile,
                      String work, String fax, String date, String annyversary, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.date = date;
        this.annyversary = annyversary;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getFax() {
        return fax;
    }

    public String getDate() {
        return date;
    }

    public String getAnnyversary() {
        return date;
    }

    public String getGroup() {
        return group;
    }
}
