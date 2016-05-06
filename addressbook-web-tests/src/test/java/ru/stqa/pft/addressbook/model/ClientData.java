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
                ", work='" + work + '\'' +
                ", fax='" + fax + '\'' +
                ", date='" + date + '\'' +
                ", annyversary='" + annyversary + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public ClientData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ClientData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ClientData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ClientData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientData withHome(String home) {
        this.home = home;
        return this;
    }


    public ClientData withWork(String work) {
        this.work = work;
        return this;
    }

    public ClientData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ClientData withDate(String date) {
        this.date = date;
        return this;
    }

    public ClientData withAnnyversary(String annyversary) {
        this.annyversary = annyversary;
        return this;
    }

    public ClientData withGroup(String group) {
        this.group = group;
        return this;
    }

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String company;
    private String address;
    private String home;
    private String work;
    private String fax;
    private String date;
    private String annyversary;
    private String group;
    private int id;

    public ClientData withId(int id) {
        this.id = id;
        return this;
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
