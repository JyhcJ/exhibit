import java.io.*;
import java.util.Scanner;

public class CustomerView {
    public static void main(String[] args) {

        methods fun = new methods();
        while (true) {
            fun.enterMainMenu();
        }
    }

    static class methods {
        final int totalCustomer = 10;
        CustomerList CL = new CustomerList(totalCustomer);
        Scanner s = new Scanner(System.in);
        int jc;
        CMUtility input = new CMUtility();

        public void enterMainMenu() {
            jc = 0;
            for (int i = 0; i < totalCustomer; i++) {
                Customer temp = CL.getCustomer(i);
                if (temp != null) {
                    jc++;
                }
            }
            CL.total = jc;
            System.out.println("------------------------客户信息管理软件-------------------------");
            System.out.println("\t\t\t\t\t\t1.添加客户");
            System.out.println("\t\t\t\t\t\t2.修改客户");
            System.out.println("\t\t\t\t\t\t3.删除客户");
            System.out.println("\t\t\t\t\t\t4.客户列表");
            System.out.println("\t\t\t\t\t\t5.退出");
            System.out.println("\t\t\t\t\t\t请选择(1-5)");
            char select = input.readMenuSelection();
            switch (select) {
                case '1': {
                    addNewCustomer();
                    break;
                }
                case '2': {
                    modifyCustomer();
                    break;
                }
                case '3': {
                    deleteCustomer();
                    break;
                }
                case '4': {
                    listAllCustomers();
                    break;
                }
                case '5': {
                    IO io = new IO();
                    io.createIO();
                    System.exit(0);
                    break;
                }
            }
        }

        private void addNewCustomer() {
            if (jc >= totalCustomer) {
                System.out.println("数组保存的数据已经达到最大值10,无法再继续添加了");
                System.out.println("----------------------------添加退出----------------------------");
                return;
            }

            Customer addCustomer = new Customer();
            System.out.println("----------------------------添加客户----------------------------");
            System.out.print("姓名:");
            addCustomer.setName(input.readString(12));
            System.out.print("性别:");
            addCustomer.setGender(input.readChar());
            System.out.print("年龄:");
            addCustomer.setAge(input.readInt());
            //s.nextLine();
            System.out.print("电话:");
            addCustomer.setPhone(input.readString(11));
            System.out.print("邮箱:");
            addCustomer.setEmail(input.readString(16));
            if (CL.addCustomer(addCustomer)) {
                System.out.println("----------------------------添加完成----------------------------");
            } else {
                System.out.println("----------------------------添加失败----------------------------");
            }
        }

        private void modifyCustomer() {
            Customer modCustomer = new Customer();
            if (jc <= 0) {
                System.out.println("你的输入有误或者已经没有数据能修改了");
                return;
            }
            System.out.println("----------------------------修改客户----------------------------");
            System.out.println("请选择待修改客户编号(-1退出):");

//            int num = s.nextInt();
//            s.nextLine();


            int num = input.readInt();
            int index = num - 1;
            if (num == -1) {
                System.out.println("----------------------------修改退出----------------------------");
                return;
            }
            if (num > 10 || num < 1) {
                System.out.println("输入不正确");
                return;
            }
            if (CL.customers[index] == null) {
                System.out.println("没有找到编号为:" + (index + 1) + "的数据,可能没有定义这条数据");
                System.out.println("----------------------------修改退出----------------------------");
                return;
            }
            String temp;
            Integer tempInt;
            System.out.print("姓名(" + CL.customers[index].getName() + "):");
            //temp = s.nextLine();
            temp = input.readString(8, CL.customers[index].getName());
            modCustomer.setName(temp);
//            if ("".equals(temp)) {
//                modCustomer.setName(CL.customers[index].getName());
//            } else {
//                modCustomer.setName(temp);
//            }


            System.out.print("性别(" + CL.customers[index].getGender() + "):");
            char tempC = input.readChar(CL.customers[index].getGender());
            modCustomer.setGender(tempC);
//            temp = s.nextLine();
//            if ("".equals(temp)) {
//                modCustomer.setGender(CL.customers[index].getGender());
//            } else {
//                modCustomer.setGender(temp.charAt(0));
//            }

            System.out.print("年龄(" + CL.customers[index].getAge() + "):");

//            tempInt=s.nextInt();
//            s.nextLine();
            int tempI = input.readInt(CL.customers[index].getAge());
            modCustomer.setAge(tempI);
//            temp = s.nextLine();
//            if ("".equals(temp)) {
//                modCustomer.setAge(CL.customers[index].getAge());
//            } else {
//                modCustomer.setAge(Integer.parseInt(temp));
//            }

            System.out.print("电话(" + CL.customers[index].getPhone() + "):");
            temp = input.readString(15, CL.customers[index].getPhone());
            modCustomer.setPhone(temp);
//            temp = s.nextLine();
//            if ("".equals(temp)) {
//                modCustomer.setPhone(CL.customers[index].getPhone());
//            } else {
//                modCustomer.setPhone(temp);
//            }

            System.out.print("邮箱(" + CL.customers[index].getEmail() + "):");
            temp = input.readString(20, CL.customers[index].getEmail());
            modCustomer.setEmail(temp);
//            temp = s.nextLine();
//            if ("".equals(temp)) {
//                modCustomer.setEmail(CL.customers[index].getEmail());
//            } else {
//                modCustomer.setEmail(temp);
//            }

            if (CL.replaceCustomer(index, modCustomer)) {
                System.out.println("----------------------------修改完成----------------------------");
            } else {
                System.out.println("----------------------------修改失败----------------------------");
            }
        }

        private void deleteCustomer() {
            System.out.println("----------------------------删除客户----------------------------");
            if (CL.total == 0) {
                System.out.println("数组中已经没有数据可以删除了");
                System.out.println("----------------------------删除退出----------------------------");
                return;
            }
            System.out.println("请选择待删除客户编号(-1退出):");
//            int num = s.nextInt();
//            s.nextLine();

            int num=input.readInt();

            int index = num - 1;
            if (num == -1) {
                System.out.println("----------------------------删除退出----------------------------");
                return;
            }
            if (num > 10 || num < 1) {
                System.out.println("输入不正确");
                return;
            }

            if (CL.customers[index] == null) {
                System.out.println("没有找到编号为:" + (index + 1) + "的数据,可能没有定义这条数据");
                return;
            }
            System.out.println("确认是否删除(Y/N):");
            //char confirm = s.nextLine().charAt(0);

            char confirm= input.readChar();
            if (confirm == 'Y' || confirm == 'y') {
                if (CL.deleteCustomer(index)) {
                    System.out.println("----------------------------删除完成----------------------------");
                    return;
                } else {
                    System.out.println("----------------------------删除失败----------------------------");
                }

            }
            System.out.println("----------------------------删除取消----------------------------");

        }

        private void listAllCustomers() {
            System.out.println("----------------------------客户列表----------------------------");
            System.out.println("编号\t\t姓名\t\t\t\t性别\t\t年龄\t\t电话\t\t\t\t邮箱");

//            System.out.printf("%-8.8s","编号");
//            System.out.printf("%-16.16s","姓名");
//            System.out.printf("%-12.12s","性别");
//            System.out.printf("%-16.16s","年龄");
//            System.out.printf("%-20.20s","电话");
//            System.out.printf("%-20.20s","邮箱");
//            System.out.println();
//            for (Customer temp : CL.getAllCustomers()) {
//                if(temp!=null)
//                {
//                    System.out.println(temp.toString());
//                }
//            }
            for (int i = 0; i < totalCustomer; i++) {
                Customer temp = CL.getCustomer(i);
                if (temp != null) {
                    //
//                    System.out.print(i+1+"\t\t");
//                    System.out.println(temp.toString());
                    //
//                    System.out.println(i+1+"\t\t"+temp.toString());
                    System.out.print(i + 1 + "\t\t");
                    System.out.printf("%-16s", temp.getName());
                    System.out.printf("%-8s", temp.getGender());
                    System.out.printf("%-12s", temp.getAge());
                    System.out.printf("%-16s", temp.getPhone());
                    System.out.printf("%-20s", temp.getEmail());
                    System.out.println();
                }

            }
            System.out.println("共找到" + jc + "条数据");
            System.out.println("--------------------------客户列表完成--------------------------");
        }

    }

    static class IO {
        void createIO() {

            try {
                FileWriter fw = new FileWriter("c:/Customer.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                FileReader fr = new FileReader("c:/Customer.txt");
                BufferedReader br = new BufferedReader(fr);


                methods fun = new methods();
                // for(int i=0;i<fun.CL.total;i++){}
                for (Customer temp : fun.CL.getAllCustomers()) {
                    if (temp != null) {
                        bw.write(temp.toString());
                        bw.newLine();
                        bw.flush();
                    }
                }
                bw.close();
                br.close();
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}