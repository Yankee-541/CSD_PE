/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class main {
    public static void main(String[] args) {
        PersonList person = new PersonList();
        person.addFirst("he150020", "Dang",  20);
        person.addFirst("he150030", "Anh",  21);
        person.addFirst("he150040", "Khanh",  22);
        person.addLast("he150050", "Meow",  23);
        person.addLast("he150060", "Cua", 249);
        person.addLast("he150070", "Ing", 25);
        
        //(a) Kiểm tra tên bắt đầu bằng nguyên âm thì do nothing, không thì addfirst trong list
//        person.checkName("He150090 ","Ang", 26);
//       person.display();
       
       
//        person.deletePerson();
//        person.display();


    person.findDel("he150090", "huhuh",4);


//    e.    Tính độ tuổi trung bình của list
//    person.AvgAge();
   

    }
}
