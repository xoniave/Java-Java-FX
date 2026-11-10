package SEMESTER_1.UAS.Selyn;

import java.util.Scanner;

public class Paragraph {
    public static void searching (String [] paragrah){
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine().toLowerCase();

        for (int i = 0; i < paragrah.length ; i++) {
            if (paragrah[i].toLowerCase().contains(target)){
                System.out.println(paragrah[i]);
            }
        }
    }
    public static void replace (String [] paragrah){
        Scanner scan = new Scanner(System.in);
        String target1 = scan.nextLine();
        String replacing = scan.nextLine();
        for (int i = 0; i < paragrah.length ; i++) {
            if (paragrah[i].toLowerCase().contains(target1)){
                System.out.println(paragrah[i]);

                paragrah[i] = paragrah[i].toLowerCase().replace(target1,replacing);

                System.out.println(paragrah[i]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pilihan = 0;
        String[] paragrah = {
                "Bahasa Pemrograman Java-Java adalah bahasa pemrograman yang populer dan banyak digunakan di berbagai platform, \n" +
                        "terutama dalam aplikasi bisnis dan web. Diperkenalkan pada tahun 1995, Java dirancang \n"
                        +
                        "agar sederhana, portabel, dan aman dengan slogan \"Write Once, Run Anywhere\". Java Virtual \n" +
                        "Machine (JVM) memungkinkan kode Java berjalan di berbagai sistem operasi seperti Windows, \n" +
                        "Mac, dan Linux.",
                "Konsep OOP di Java-Java berorientasi pada objek, di mana konsep seperti enkapsulasi, pewarisan, polimorfisme, \n" +
                        "dan abstraksi memainkan peran penting. Konsep-konsep ini membuat kode lebih terstruktur,\n" +
                        "mudah dipelihara, dan dapat digunakan kembali. Penggunaan OOP di Java membantu pengembang \n" +
                        "menciptakan aplikasi yang lebih efisien dan terorganisir.",
                "Java dalam Pengembangan Android-Java adalah bahasa utama dalam pengembangan aplikasi Android, meskipun Kotlin kini juga \n" +
                        "banyak digunakan. Android SDK berbasis Java, sehingga pemahaman dasar Java sangat penting \n" +
                        "bagi pengembang Android. Dokumentasi dan komunitas yang luas membuat Java mudah dipelajari \n" +
                        "oleh pemula maupun profesional di bidang Android.",
                "Framework Java untuk Pengembangan Web-Framework populer untuk pengembangan web berbasis Java antara lain Spring, Hibernate, \n" +
                        "dan Struts. Spring Boot memudahkan pengembangan aplikasi web yang cepat, sementara Hibernate \n" +
                        "memungkinkan pengelolaan database yang lebih sederhana dengan Object-Relational Mapping (ORM). \n" +
                        "Framework-framework ini membuat pengembangan web lebih cepat, aman, dan mudah dipelihara.",
                "Manfaat dan Tantangan dalam Menggunakan Java-Java dikenal stabil dan aman serta didukung oleh komunitas besar, sehingga cocok untuk \n" +
                        "aplikasi enterprise. Namun, sintaks yang verbose dan performa yang sedikit lebih lambat \n"
                        +
                        "dibandingkan bahasa lain menjadi tantangan tersendiri. Meski begitu, keandalan dan skalabilitasnya \n" +
                        "membuat Java tetap populer di berbagai industri."

        };
        do {
            System.out.println("1. Searching");
            System.out.println("2. Replace");
            System.out.println("3. Search Judul");

            pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    searching(paragrah);
                    break;
                case 2 :
                    replace(paragrah);
                    break;
                case 3 :
                    break;

            }

        }while (pilihan != 0);
    }
}