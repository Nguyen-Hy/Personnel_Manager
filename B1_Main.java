package baiTapPremium.L38.B1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class B1_Main {

    public static void main(String[] args) throws IOException {

        var fileName = "E:\\FILE SAVE\\java\\JavaTutorial\\src\\baiTapPremium\\L38\\B1\\emp.txt";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personnel> personnelArrayList = new ArrayList<>();
//        personnelArrayList.addAll(readFile(fileName) );
        Personnel personnels = new Personnel();


        File file = new File("E:\\FILE SAVE\\java\\JavaTutorial\\src\\baiTapPremium\\L38\\B1\\emp.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter, true);
        Scanner scanner2 = new Scanner(file);


        var chosse = 0;
        do{
           var readFILE =  readFile(fileName);
           for( var i : readFILE ){
               System.out.printf("\n\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                       "Mã NV", "Họ & Tên", "Tuổi", "SĐT", "Địa Chỉ", "Kinh Nghiệm", "Tiền Lương");
               personnelInfor(i);
           }

            System.out.println("\n\n\t================== MENU ==================");
            System.out.println("\t|| 1. THÊM MỚI NHÂN VIÊN VÀO DANH SÁCH: ||");
            System.out.println("\t|| 2. HIỂN THỊ THÔNG TIN NHÂN VIÊN:     ||");
            System.out.println("\t|| 3. TÌM NHÂN VIÊN THEO TÊN:           ||");
            System.out.println("\t|| 4. XÓA NHÂN VIÊN THEO MÃ CHO TRƯỚC:  ||");
            System.out.println("\t|| 5. GHI DANH SÁCH NHÂN VUÊN RA FILE:  ||");
            System.out.println("\t|| 0. THOÁT CHƯƠNG TRÌNH:               ||");
            System.out.println("\t========================================== ");
            System.out.print("\tXIN MOI CHON: ");
            chosse = scanner.nextInt();
            scanner.nextLine();

            switch (chosse){
                case 1: {
                    var personnel = addGPersonnel(scanner, personnelArrayList);
                    personnelArrayList.add(personnel);
                    System.out.println("\n\t========== ThÊM NHÂN VIÊN THÀNH CÔNG ========== ");
                   break;
                }
                case 2: {
                    if( personnelArrayList.size() > 0 ){
                        showPersonnel(personnelArrayList);
                    }else{
                        System.out.println("\n\t========== DANH SÁCH NHÂN VIÊN RỖNG ==========");
                    }
                    break;
                }
                case 3: {
                    if( personnelArrayList.size() > 0 ){
                        findStudenByName(scanner, personnelArrayList);
                    }else{
                        System.out.println("\n\t========== DANH SÁCH NHÂN VIÊN RỖNG ==========");
                    }
                    break;
                }
                case 4: {
                    if( personnelArrayList.size() > 0 ){
                       var del = delPersonnel(personnelArrayList);
                       personnelArrayList.remove(del);
                    }else{
                        System.out.println("\n\t========== DANH SÁCH NHÂN VIÊN RỖNG ==========");
                    }
                    break;
                }
                case 5: {
                    if (personnelArrayList.size() > 0) {
                        var isSuccess = writeToFile(personnelArrayList, fileName);
                        if (isSuccess) {
                            System.out.println("==> Ghi file thành công! <==");
                        } else {
                           System. out.println("==> Ghi file thất bại! <==");
                        }
                    } else {
                       System. out.println("==> Danh sách nhân viên rỗng. Ghi file thất bại <==");
                    }
                    break;
                }
                case 0: {
                    System.out.println("\n\t========== THOÁT CHƯƠNG TRÌNH ==========");
                    break;
                }
            }

        }while( chosse != 0 );

        printWriter.close();
    }


    private static Personnel findPersonnelById( String name, ArrayList<Personnel> personnelArrayList ){
        for( var i : personnelArrayList){
            if( i.getId().equals(name) ){
                return i;
            }
        }
        return null;
    }

    private static Personnel delPersonnel( ArrayList<Personnel> personnelArrayList ){

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tNhập id nhân viên: ");
        var id = scanner.nextLine();

        var findId = findPersonnelById(id, personnelArrayList );

        if( findId != null ){
            System.out.println("\n\tXóa nhân viên thành công !");
            showPersonnel(personnelArrayList);
        }else{
            System.out.println("\n\tKhông tìm thấy tên sinh viên ");
        }
        return findId;
    }

    private static void showFile (Personnel personnel ){

        System.out.println(personnel.getId());
        System.out.println(personnel.getFullname());
        System.out.println(personnel.getAge());
        System.out.println(personnel.getPhoneNumber());
        System.out.println(personnel.getAddr());
        System.out.println(personnel.getNumOfYearXP());
        System.out.println(personnel.getMoney());

    }

    private static boolean writeToFile(ArrayList<Personnel> personnels,
                                       String fileName) {
//        var currentInFile = readEmpFromFile(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i <  personnels.size(); i++) {
                var emp = personnels.get(i);
//                if (!isExist(currentInFile, emp)) {
                    printWriter.print(emp.getId());
                    printWriter.print(emp.getFullname());
                    printWriter.print(emp.getAge());
                    printWriter.print(emp.getPhoneNumber());
                    printWriter.print(emp.getAddr());
                    printWriter.print(emp.getNumOfYearXP());
                    printWriter.print(emp.getMoney());
//                }
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static ArrayList<Personnel> readFile( String fileName ) throws FileNotFoundException {

        ArrayList<Personnel> personnels = new ArrayList<>();
        var file = new File(fileName);
        var scanner = new Scanner(file);

        while( scanner.hasNextLine() ){
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            var age = Integer.parseInt(scanner.nextLine());
            var phoneNumber = scanner.nextLine();
            var addr = scanner.nextLine();
            var numOfYearXP = Integer.parseInt(scanner.nextLine());
            var monney = Float.parseFloat(scanner.nextLine());
            Personnel personnel = new Personnel(id, name, age, phoneNumber, addr, numOfYearXP, monney);
            personnels.add(personnel);
        }
        scanner.close();
        return personnels;

    }

    private static boolean isExist(ArrayList<Personnel> personnelArrayList, Personnel personnel) {
        for (var item : personnelArrayList) {
            if (item.getId().compareTo(item.getId()) == 0) {
                return true;
            }
        }
        return false;
    }


    private static void findStudenByName( Scanner scanner, ArrayList<Personnel> personnelArrayList) {

        System.out.print("\n\tNhập tên nhân viên cần tìm: ");
        var name = scanner.nextLine();


      var names = findPersonnel(name, personnelArrayList);

      if( names != null ){
          showEquals();
          System.out.printf("\n\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                  "Mã NV", "Họ & Tên", "Tuổi", "SĐT", "Địa Chỉ", "Kinh Nghiệm", "Tiền Lương");
          personnelInfor(names);
      }else{
          System.out.println("\n\t========== KHÔNG TÌM THẤY NHÂN VIÊN ==========");
      }

    }

    private static void showEquals() {
        System.out.println("===============================================================================================================");
    }

    private static Personnel findPersonnel( String name, ArrayList<Personnel> personnelArrayList ){
//        Personnel personnel = new Personnel();
//        Personnel.FullName fullName1 = personnel.new FullName();
//        fullName1.lastName = "";
        for( var i : personnelArrayList ){
            if( i.getFullname().equalsIgnoreCase(name) ){
                return i;
            }
        }
        return null;
    }

    private static void showPersonnel(ArrayList<Personnel> personnelArrayList) {

        System.out.printf("\n\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                "Mã NV", "Họ & Tên", "Tuổi", "SĐT", "Địa Chỉ", "Kinh Nghiệm", "Tiền Lương");
        for( var i : personnelArrayList ){
            personnelInfor(i);
        }
    }

    private static void personnelInfor(Personnel personnel ) {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                personnel.getId(), personnel.getFullname(), personnel.getAge(), personnel.getPhoneNumber()
                , personnel.getAddr(), personnel.getNumOfYearXP()  , personnel.getMoney());
    }


    private static Personnel addGPersonnel(Scanner scanner, ArrayList<Personnel> personnelArrayList) {

        System.out.print("\n\n\tNhập mã nhân viên: ");
        var id = scanner.nextLine();

        System.out.print("\n\tNhập họ tên: ");
        var fullName = scanner.nextLine();

        System.out.print("\n\tNhập tuổi: ");
        var age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\n\tNhập số điện thoại: ");
        var phoneNumber = scanner.nextLine();

        System.out.print("\n\tNhập địa chỉ: ");
        var addr = scanner.nextLine();

        System.out.print("\n\tNhập Số Năm Kinh Nghiệm: ");
        var numOfYearXP = scanner.nextInt();

        System.out.print("\n\tNhập Mức Lương: ");
        var monney = scanner.nextFloat();

        return new Personnel(id, fullName, age, phoneNumber, addr, numOfYearXP, monney);

    }


}
