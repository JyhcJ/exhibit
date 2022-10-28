public class CustomerList {
    Customer[] customers;
    int total=0;

    public CustomerList(int totalCustomer){
        customers=new Customer[totalCustomer];
        customers[0]= new Customer("尹海川",'男',21,"18123446221","544699595@qq.com");
        customers[1]= new Customer("yhciknml",'男',21,"18123446221","544699595@qq.com");
        customers[2]= new Customer("Wolf",'?',5,"-----","513323");
        customers[3]= new Customer("余颖",'女',21," ⚆_⚆？","555222000555");
        customers[4]= new Customer("Johnjacker",'女',66," ⚆_⚆？","555222000555");
        customers[5]= new Customer("V",'男',40," (｡•ˇ‸ˇ•｡) ","(*>.<*)");
        customers[6]= new Customer("德吉那姆",'男',18," (｡•ˇ‸ˇ•｡) ","(*>.<*)");
        customers[8]= new Customer("学家纳尔布",'男',23,"3521057","ihageyou@0707");
        customers[9]= new Customer("巴勃罗·迭戈",'女',76,"010-2311432","woyaoduiqiaaaHOW");
    }

    public boolean addCustomer(Customer customer){
        for(int i=0;i<customers.length;i++){
            if(customers[i]==null){
                customers[i]=customer;
                return true;
            }
        }
        return false;
    }

    public boolean replaceCustomer(int index,Customer cust){
        if(index>=0 && index<customers.length){
            customers[index]=cust;
            return true;
        }
        else {return false;}
    }

    public boolean deleteCustomer(int index){
        if(index>=0 && index<customers.length){
            if(customers[index]==null){
                System.out.println("没有找到编号为"+(index+1)+"的数据");
                return false;
            }
            else{
            customers[index]=null;
            return true;}
        }
        else {return false;}
    }



    public  Customer[] getAllCustomers(){
        return customers;
    }

    public Customer getCustomer(int index){
        return  customers[index];
    }
}
