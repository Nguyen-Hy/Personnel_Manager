package baiTapPremium.L38.B1;

public class Personnel {

      class FullName{
         String fistName;
         String midName;
         String lastName;
    }


    private String id;
     FullName fullName;
    private String addr;
    private int age;
    private String phoneNumber;
    private float money;
    private int numOfYearXP;

    public Personnel() {
        id = "";
        fullName = new FullName();
        addr = "";
        age = 0;
        phoneNumber = "";
        money = 0.0f;
        numOfYearXP = 0;

    }

    public Personnel(String id, String fullname,
                     int age, String phoneNumber, String addr,
                     int numOfYearXP, float money) {
        this();
        this.id = id;
        this.setFullname(fullname);
        this.addr = addr;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.numOfYearXP = numOfYearXP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return this.fullName.fistName +  fullName.midName + fullName.lastName ;
    }

    public void setFullname(String fullName) {
        this.fullName.fistName = "";
        this.fullName.midName = "";
        this.fullName.lastName = "";

        if( fullName.length() < 1 ){
            var names = fullName.split(" ");

            this.fullName.midName = "";
            this.fullName.lastName = names[names.length-1];
            for( int i = 1; i < fullName.length()-1; i++ ){
                this.fullName.midName += names[i] + " ";
            }
        }else{
            this.fullName.fistName = fullName;
        }

    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getNumOfYearXP() {
        return numOfYearXP ;
    }

    public void setNumOfYearXP(int numOfYearXP) {
        this.numOfYearXP = numOfYearXP;
    }

}
