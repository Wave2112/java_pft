package ru.stqa.pft.addressbook.model;

public class ClientData {

    @Override
    public String toString() {
        return "ClientData{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                ", work='" + work + '\'' +
                ", fax='" + fax + '\'' +
                ", date='" + date + '\'' +
                ", annyversary='" + annyversary + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

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
    private final String annyversary;
    private final String group;
    private int id;


    public ClientData(int id, String firstName, String middleName, String lastName, String nickName,
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
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientData that = (ClientData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

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
        this.id = 0;
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
    public int getId() {
        return id;
    }
}
