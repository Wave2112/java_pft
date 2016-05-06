package ru.stqa.pft.addressbook.model;

public class ContactData {

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

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }


    public ContactData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withDate(String date) {
        this.date = date;
        return this;
    }

    public ContactData withAnnyversary(String annyversary) {
        this.annyversary = annyversary;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String company;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String fax;
    private String date;
    private String annyversary;
    private String group;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
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

    public String getHomePhone() {
        return home;
    }

    public String getWorkPhone() {
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

    public String getMobilePhone() {
        return mobile;
    }
}
