public class Customer {
    private String name;
    private  char gender;
    private  int age;
    private  String phone;
    private  String email;

    public Customer(){}

    @Override
    public String toString() {
//        String Chinese="[\u4e00-\u9fa5]";
////        Pattern p=Pattern.compile(Chinese);
////        Matcher m=p.matcher(name);
//        String[] t=name.split("");
//        float namelength=name.length();
//        for (int i = 0; i < name.length(); i++) {
//            if(t[i].matches(Chinese)){
//                 namelength+=0.5;
//            }
//        }
//        if(namelength*10%10>4){
//            namelength++;
//        }
//
//        if (namelength < 4) {
//            return name + "\t\t\t\t" + gender + "\t\t" + age + "\t\t" + phone + "\t\t" + email;
//        }
//        if (namelength > 8) {
//
//            return name + "\t\t" + gender + "\t\t" + age + "\t\t" + phone + "\t\t" + email;
//        }
//        return name + "\t\t\t" + gender + "\t\t" + age + "\t\t" + phone + "\t\t" + email;
        //return name   + gender + age  + phone  + email;
//        System.out.println("编号\t\t姓名\t\t\t\t性别\t\t年龄\t\t电话\t\t\t\t邮箱");
        formatToString(name,4);
        formatToString(String.valueOf(gender),2);
        formatToString(String.valueOf(age),2);
        formatToString(phone,4);
        formatToString(email,1);

        return "";
    }


    public boolean formatToString(String src,int tnums){
        String Chinese="[\u4e00-\u9fa5]";
        String[] t=name.split("");
        float namelength=name.length();
        for (int i = 0; i < name.length(); i++) {
            if(t[i].matches(Chinese)){
                namelength+=0.5;
            }
        }
        if(namelength*10%10>4){
            namelength++;
        }
        if(tnums==0){
            return true;
        }
        int c=1-(int)(namelength/4);
        if(tnums+c<0){
            return false;
        }
        System.out.print(src);
        for (int i = 0; i < tnums+c-1; i++) {
            System.out.print("\t");
        }
        return true;
    }


    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
