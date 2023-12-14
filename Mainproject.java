import java.util.Scanner;

public class Mainproject {
    public static Scanner input = new Scanner(System.in);
    public static String[] destinasi = { "Labuan Bajo", "Lombok", "Kepulauan Seribu", "Banda Neira", "Belitung",
            "Bangka", "Danau Toba", "Gili", "Karimunjawa", "Wakatobi" };
    public static String[] destinasiKhususOlahraga = { "Ancol", "Manta Rhei Dive Center", "DSM Dive-Gili Trawangan",
            "EcoTravel Bukit Lawangan", "Adventure Scuba Diving Bali" };
    public static String[] kapal = { "Yatch Catamaran 1.2", "Utopian Catamaran", "Kapal Mancing Ryan", "Pinissi Boat",
            "Yatch Azimuth", "Yatch Catamaran FeadShip", "Yacth Accura 49 Luxury" };
    public static String[] paketWisata = { "Paket 1", "Paket 2", "Paket 3" },
            paketOlahraga = { "Paket 1", "Paket 2", "Paket 3" };
    public static String[] fiturPaket = {
            "Fitur; -untuk 2 orang, -Hotel Bintang 5, -Menginap 2 Malam, -4 Tempat Wisata Include",
            "Fitur; -untuk 4 orang, -Hotel Bintang 5, -Menginap 3 Malam, -6 Tempat Wisata Include", },
            fiturPaketOlahraga = {
                    "Fitur; -untuk 2 orang, -Jetski, -Kano",
                    "Fitur; -untuk 4 orang, -Ski air, -Flyboard, -Polo air" };
    public static int[] hargaPaketWisata = { 5000000, 13000000 };
    public static int[] hargaPaketOlahraga = { 4500000, 12000000 };
    public static int[] hargaKapal = { 40000000, 24000000, 200000, 44000000, 56000000, 50000000, 90000000 };
    public static int[] kapalPilihan = new int[20], paketWisataPilihan = new int[30], banyakOrangPaket3 = new int[5],
            banyakTempatWisataPaket3 = new int[5], banyakHariPaket3 = new int[5], hargaTotal = new int[9],
            hargaTotalOlahraga = new int[10], banyakOrangPaket3Olahraga = new int[10],
            banyakHariPaket3Olahraga = new int[20], banyakJenisOlahragaPaket3 = new int[10],
            paketPilihanOlahraga = new int[10];

    public static int kapalAv = 7, wisataAv = 20, olahragaAv = 10, jenisPembayaran;
    public static String[] destinasiPilihanWisata = new String[20], destinasiPilihanKapal = new String[10],
            destinasiPilihanOlahraga = new String[20];
    public static String[] hari = new String[10], hariWisata = new String[20], hariOlahraga = new String[20];
    public static int[] bulan = new int[10], tahun = new int[10], tanggal = new int[10], bulanWisata = new int[20],
            tahunWisata = new int[20], tanggalWisata = new int[20], tahunOlahraga = new int[20],
            tanggalOlahraga = new int[20], bulanOlahraga = new int[20];
    public static int tiketCounterKapal = 0, tiketCounterWisata = 0, tiketCounterOlahraga = 0;
    public static boolean ticketEligibility = false, menuCheck = false;
    public static String namaLogin;
    public static String[] keywordsForHari = { "senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu" };

    public static void main(String[] args) {// metode main atau yg utama

        System.out.println("APLIKASI TIKET SEWA KAPAL DAN PARIWISATA AIR");
        System.out.println("==============================================");

        do {
            System.out.print("LOGIN NAMA ANDA : ");
            namaLogin = input.nextLine();
            System.out.println("");
            if (isValidName(namaLogin))
                System.out.println("Maaf apa yang anda inputkan bukanlah nama");

        } while (isValidName(namaLogin));

        mainMenu();

        System.out.println("Program selesai");

    }

    public static boolean isValidName(String nama) {// metode untuk mengecek nama orang pas lagi login aplikasi

        for (int i = 0; i < nama.length(); i++) {
            char karakter = nama.charAt(i);
            if (!Character.isLetter(karakter)) {
                if (!(karakter == ' ')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mainMenu() {// metode menu utama

        int menu;

        do {

            do {
                System.out.println("");
                System.out.println("Menu : ");
                System.out.println("1. Sewa Kapal");
                System.out.println("2. Paket Wisata");
                System.out.println("3. Olahraga Air");
                System.out.println("4. Tiket Anda");
                System.out.println("5. Keluar");
                System.out.println("");
                System.out.print("masukkan menu anda (1 - 5) : ");
                menu = input.nextInt();
                input.nextLine();

                if (menu < 1 || menu > 5)
                    System.out.println("maaf, inputan anda salah");

            } while (menu < 1 || menu > 5);

            if (menu == 5) {
                System.out.println("program tiket selesai");
                menuCheck = true;

            } else if (menu == 4) {

                tiketAnda(ticketEligibility);
                menuCheck = false;

            } else if (menu == 3) {
                olahragaAir();
                menuCheck = false;
                ticketEligibility = true;

            } else if (menu == 2) {

                paketWisata();
                menuCheck = false;
                ticketEligibility = true;

            } else if (menu == 1) {
                sewaKapal();
                menuCheck = false;
                ticketEligibility = true;

            }

        } while (menuCheck == false);

    }

    public static void sewaKapal() {// metode untuk persewaan kapal di menu 1
        boolean inputMatches = false;
        if (tiketCounterKapal == kapalAv) {
            System.out.println("maaf kecukupan tiket sewa kapal sudah habis");
        } else {
            System.out.println("--------------------SEWA KAPAL-----------------");
            System.out.println("TUJUAN DESTINASI : ");
            System.out.println("   -Tempat Destinasi :");
            for (int i = 0; i < destinasi.length; i++)
                System.out.println("     " + (i + 1) + ". " + destinasi[i]);

            System.out.println();

            while (!inputMatches) {
                System.out.print("pilih tempat destinasi anda (bukan nomor): ");
                destinasiPilihanKapal[tiketCounterKapal] = input.nextLine();
                for (String keyword : destinasi) {
                    if (destinasiPilihanKapal[tiketCounterKapal].equalsIgnoreCase(keyword))
                        inputMatches = true;
                }
                if (inputMatches == false)
                    System.out.println("inputan anda salah");
            }
            System.out.println();
            System.out.println("JADWAL PELAYARAN : ");// JADWAL PELAYARAN

            while (inputMatches) {
                System.out.print("    -Masukkan nama hari : ");
                hari[tiketCounterKapal] = input.nextLine();
                for (String keyword : keywordsForHari) {// check keywords
                    if (hari[tiketCounterKapal].equalsIgnoreCase(keyword))
                        inputMatches = false;
                }
                if (inputMatches == true)
                    System.out.println("inputan anda bukan nama hari");
            }

            while (!inputMatches) {
                System.out.print("    -Masukkan tanggal (angka) : ");
                tanggal[tiketCounterKapal] = input.nextInt();

                if (tanggal[tiketCounterKapal] < 32 && tanggal[tiketCounterKapal] > 0) {
                    inputMatches = true;
                } else {
                    System.out.println("inputan anda salah");
                }
            }

            while (inputMatches) {
                System.out.print("    -Masukkan bulan (angka) : ");
                bulan[tiketCounterKapal] = input.nextInt();

                if (bulan[tiketCounterKapal] < 13 && bulan[tiketCounterKapal] > 0) {
                    inputMatches = false;
                } else {
                    System.out.println("inputan anda salah");
                }
            }

            System.out.print("    -Masukkan tahun : ");
            tahun[tiketCounterKapal] = input.nextInt();
            System.out.println();
            System.out.println("JENIS KAPAL : ");
            System.out.println("    -jenis kapal :");
            for (int i = 0; i < kapal.length; i++) {
                System.out.print("     " + (i + 1) + ". " + kapal[i] + " : ");
                System.out.println(hargaKapal[i]);
            }

            while (!inputMatches) {
                System.out.print("    pilihlah 1 kapal (nomor): ");
                kapalPilihan[tiketCounterKapal] = input.nextInt();

                if (kapalPilihan[tiketCounterKapal] > 0 && kapalPilihan[tiketCounterKapal] <= kapal.length) {
                    System.out.println(
                            "    Kapal yang anda pilih adalah : " + kapal[kapalPilihan[tiketCounterKapal] - 1]);
                    System.out.println(
                            "    Harga                        : Rp " + hargaKapal[kapalPilihan[tiketCounterKapal] - 1]);
                    System.out.print("    apakah inputan anda sudah benar ? (iya/tidak) : ");
                    String checkPembayaran = input.next();
                    if (checkPembayaran.equalsIgnoreCase("iya")) {
                        inputMatches = true;
                    } else if (checkPembayaran.equalsIgnoreCase("tidak")) {

                    } else {
                        System.out.println("inputan anda salah tapi kami anggap tidak");
                    }
                } else {
                    System.out.println("inputan anda salah");
                }
            }
            System.out.println();
            System.out.println("HARGA : ");

            System.out.println("    -Harga total : ");
            System.out.println("     Rp " + hargaKapal[kapalPilihan[tiketCounterKapal] - 1]);
            System.out.println();
            System.out.println("    -Jenis pembayaran : ");
            System.out.println("        1. Kartu debit");
            System.out.println("        2. Cash");
            System.out.println("        3. Gopay");

            while (inputMatches) {
                System.out.print("          Pilih salah satu jenis pembayaran (nomor) : ");
                jenisPembayaran = input.nextInt();
                if (jenisPembayaran > 0 && jenisPembayaran < 4) {
                    inputMatches = false;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            System.out.println("Selamat, tiket anda telah keluar, untuk melihat tiket silahkan lihat menu ke 4");
            tiketCounterKapal++;
        }
    }

    public static void tiketAnda(boolean ticketEligibility) {// metode untuk melihat tiket pembeli
        boolean inputMatches = false;
        int jenisTkt = 0;
        if (ticketEligibility == false) {
            System.out.println("Tiket anda masih kosong");
            System.out.println("Maaf, anda harus memesan tiket terlebih dahulu");
            return;

        }
        System.out.println("PILIH JENIS TIKET : ");
        System.out.println("1. Tiket Sewa Kapal");
        System.out.println("2. Tiket Paket Wisata");
        System.out.println("3. Tiket Olahraga Air");
        System.out.println();
        while (!inputMatches) {
            System.out.print("Masukkan jenis tiket anda (nomor) : ");
            jenisTkt = input.nextInt();

            if (jenisTkt > 0 && jenisTkt < 4) {
                inputMatches = true;
            } else {
                System.out.println("Inputan anda salah");
            }
        }

        if (jenisTkt == 1) {
            for (int i = 0; i < tiketCounterKapal; i++) {
                System.out.println("Tiket ke " + (i + 1));
                System.out.println();
                System.out.println("============================================");
                System.out.println("Nama Penyewa : " + namaLogin);
                System.out.println("Hari/Tanggal/Tahun : " + hari[i] + " / " + tanggal[i] + " / " + tahun[i]);
                System.out.println("Jenis Kapal : " + kapal[kapalPilihan[i] - 1]);
                System.out.println("Destinasi : " + destinasiPilihanKapal[i]);
                System.out.println("Harga Total : Rp " + hargaKapal[kapalPilihan[i] - 1]);
                System.out.println("=============================================");
                System.out.println();
            }
        } else if (jenisTkt == 2) {
            for (int i = 0; i < tiketCounterWisata; i++) {
                System.out.println("Tiket ke " + (i + 1));
                System.out.println();
                System.out.println("=============================================");
                System.out.println("Nama Pembeli : " + namaLogin);
                System.out.println(
                        "Hari/Tanggal/Tahun : " + hariWisata[i] + " / " + tanggalWisata[i] + " / " + tahunWisata[i]);
                System.out.println("Jenis Paket : " + paketWisataPilihan[i]);
                if (paketWisataPilihan[i] == 3) {
                    System.out.println("Banyak Orang : " + banyakOrangPaket3[i]);
                    System.out.println("Banyak Hari " + banyakHariPaket3[i]);
                    System.out.println("Banyak Objek Wisata Dikunjungi : " + banyakTempatWisataPaket3[i]);
                }
                System.out.println("Destinasi : " + destinasiPilihanWisata[i]);
                System.out.println("Harga total : " + hargaTotal[i]);
                System.out.println("================================================");
            }

        } else if (jenisTkt == 3) {
            for (int i = 0; i < tiketCounterOlahraga; i++) {
                System.out.println("Tiket ke " + (i + 1));
                System.out.println();
                System.out.println("=============================================");
                System.out.println("Nama pembeli : " + namaLogin);
                System.out.println(
                        "Hari/Tanggal/Tahun : " + hariOlahraga[i] + "/" + tanggalOlahraga[i] + "/" + tahunOlahraga[i]);
                System.out.println("Jenis Paket : " + paketPilihanOlahraga[i]);
                if (paketPilihanOlahraga[i] == 3) {
                    System.out.println("Banyak Orang : " + banyakOrangPaket3Olahraga[i]);
                    System.out.println("Banyak Hari : " + banyakHariPaket3Olahraga[i]);
                    System.out.println("Banyak Jenis Olahraga Air : " + banyakOrangPaket3Olahraga[i]);
                }
                System.out.println("Destinasi : " + destinasiKhususOlahraga[i]);
                System.out.println("Harga total : " + hargaTotalOlahraga[i]);
                System.out.println("================================================");
            }
            // munculin tiket anggi
        }

    }

    public static void paketWisata() {
        boolean inputMatches = false;
        if (tiketCounterWisata == wisataAv) {
            System.out.println("Tiket paket wisata sudah habis");

        } else {
            System.out.println("--------------------PAKET WISATA-----------------");
            System.out.println("TUJUAN DESTINASI : ");
            System.out.print("    -Tempat destinasi : ");
            for (int i = 0; i < destinasi.length; i++)
                System.out.println("     " + (i + 1) + ". " + destinasi[i]);
            System.out.println();
            while (!inputMatches) {
                System.out.print("    Pilih tempat wisata anda : ");
                destinasiPilihanWisata[tiketCounterWisata] = input.nextLine();
                for (String keyword : destinasi) {
                    if (destinasiPilihanWisata[tiketCounterWisata].equalsIgnoreCase(keyword))
                        inputMatches = true;
                }
                if (inputMatches == false)
                    System.out.println("Inputan anda salah");
            }
            System.out.println();
            System.out.println("PAKET WISATA : ");
            System.out.println("    Paket 1");
            System.out.println("    Paket 2");
            System.out.println("    Paket 3");
            while (inputMatches) {
                System.out.print("    Pilih paket wisata (nomor) : ");
                paketWisataPilihan[tiketCounterWisata] = input.nextInt();
                input.nextLine();
                if (paketWisataPilihan[tiketCounterWisata] > 0 && paketWisataPilihan[tiketCounterWisata] < 4)
                    inputMatches = false;
                else
                    System.out.println("Inputan anda salah ");
            }
            while (!inputMatches) {
                if (paketWisataPilihan[tiketCounterWisata] == 1) {
                    System.out.println("    " + fiturPaket[0]);

                } else if (paketWisataPilihan[tiketCounterWisata] == 2) {
                    System.out.println("    " + fiturPaket[1]);
                } else if (paketWisataPilihan[tiketCounterWisata] == 3) {
                    System.out.println(
                            "Fitur; didalam paket ini anda akan menentukan banyak orang, banyak tempat wisata, banyak hari");
                    System.out.println();
                    do {
                        System.out.print("    Berapa banyak orang yang ingin anda bawa : ");
                        banyakOrangPaket3[tiketCounterWisata] = input.nextInt();
                        if (banyakOrangPaket3[tiketCounterWisata] < 1)
                            System.out.println("Banyak orang harus lebih dari 1");

                    } while (banyakOrangPaket3[tiketCounterWisata] < 1);
                    do {
                        System.out.print("    Berapa banyak hari yang ingin anda pakai : ");
                        banyakHariPaket3[tiketCounterWisata] = input.nextInt();
                        if (banyakHariPaket3[tiketCounterWisata] < 1)
                            System.out.println("banyak hari harus lebih dari 1");
                    } while (banyakHariPaket3[tiketCounterWisata] < 1);
                    do {
                        System.out.print("    Berapa banyak objek wisata yang anda ingin kunjungi : ");
                        banyakTempatWisataPaket3[tiketCounterWisata] = input.nextInt();
                        input.nextLine();
                        if (banyakTempatWisataPaket3[tiketCounterWisata] < 1)
                            System.out.println("Banyak objek wisata harus lebih dari 1");
                    } while (banyakTempatWisataPaket3[tiketCounterWisata] < 1);
                    input.nextLine();
                }
                System.out.print("    Apakah paket di atas sudah benar (iya/tidak): ");
                String check = input.nextLine();
                if (check.equalsIgnoreCase("iya"))
                    inputMatches = true;
                else if (check.equalsIgnoreCase("tidak"))
                    System.out.println();
                else
                    System.out.println("Inputan anda salah tetapi kami anggap itu tidak");
            }
            System.out.println("JADWAL PAKET WISATA : ");
            while (inputMatches) {
                System.out.print("    -Masukkan nama hari : ");
                hariWisata[tiketCounterWisata] = input.nextLine();
                for (String keyword : keywordsForHari) {// check keywords
                    if (hariWisata[tiketCounterWisata].equalsIgnoreCase(keyword))
                        inputMatches = false;
                }
                if (inputMatches == true)
                    System.out.println("Inputan anda bukan nama hari");
            }
            while (!inputMatches) {
                System.out.print("    -Masukkan tanggal (angka) : ");
                tanggalWisata[tiketCounterWisata] = input.nextInt();
                if (tanggalWisata[tiketCounterWisata] < 32 && tanggalWisata[tiketCounterWisata] > 0) {
                    inputMatches = true;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            while (inputMatches) {
                System.out.print("    -Masukkan bulan (angka) : ");
                bulanWisata[tiketCounterWisata] = input.nextInt();
                if (bulanWisata[tiketCounterWisata] < 13 && bulanWisata[tiketCounterWisata] > 0) {
                    inputMatches = false;
                } else {
                    System.out.println("inputan anda salah");
                }
            }
            System.out.print("    -Masukkan tahun : ");
            tahunWisata[tiketCounterWisata] = input.nextInt();
            System.out.println();
            System.out.println("HARGA : ");
            if (paketWisataPilihan[tiketCounterWisata] == 3) {
                hargaTotal[tiketCounterWisata] = 5000000 * banyakHariPaket3[tiketCounterWisata]
                        * banyakOrangPaket3[tiketCounterWisata] * banyakTempatWisataPaket3[tiketCounterWisata];
                System.out.println("    -Harga total : " + hargaTotal[tiketCounterWisata]);
                System.out.println("    -Jenis pembayaran : ");
                System.out.println("      1. Kartu debit");
                System.out.println("      2. Cash  ");
                System.out.println("      3. Gopay ");
            } else {
                System.out.println("    -Harga total : Rp " + hargaPaketWisata[paketWisataPilihan[tiketCounterWisata]]);
                System.out.println("     -Jenis pembayaran : ");
                System.out.println("      1. Kartu debit");
                System.out.println("      2. Cash");
                System.out.println("      3. Gopay");
                hargaTotal[tiketCounterWisata] = hargaPaketWisata[paketWisataPilihan[tiketCounterWisata]];
            }
            while (!inputMatches) {
                System.out.print("          Pilih salah satu jenis pembayaran (nomor) : ");
                jenisPembayaran = input.nextInt();
                if (jenisPembayaran > 0 && jenisPembayaran < 4) {
                    inputMatches = true;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            System.out.println("Selamat, tiket anda telah keluar, untuk melihat tiket silahkan lihat menu ke 4");
            tiketCounterWisata++;
        }
    }

    public static void olahragaAir() {
        boolean inputMatches = false;

        if (tiketCounterOlahraga == olahragaAv) {
            System.out.println("Kecukupan tiket sudah habis");
        } else {
            System.out.println("--------------------OLAHRAGA AIR-----------------");
            System.out.println("TUJUAN DESTINASI : ");
            System.out.println("    -Tempat destinasi : ");
            for (int i = 0; i < destinasiKhususOlahraga.length; i++)
                System.out.println("     " + (i + 1) + ". " + destinasiKhususOlahraga[i]);
            System.out.println();
            while (!inputMatches) {
                System.out.print("    Pilih tempat olahraga air anda: ");
                destinasiKhususOlahraga[tiketCounterOlahraga] = input.nextLine();
                for (String keyword : destinasiKhususOlahraga) {
                    if (destinasiKhususOlahraga[tiketCounterOlahraga].equalsIgnoreCase(keyword))
                        inputMatches = true;
                }
                if (inputMatches == false)
                    System.out.println("Inputan anda salah");
            }
            System.out.println();
            System.out.println("PAKET OLAHRAGA AIR: ");
            System.out.println("    Paket 1");
            System.out.println("    Paket 2");
            System.out.println("    Paket 3");
            while (inputMatches) {
                System.out.print("    Pilih paket olahraga air (nomor) : ");
                paketPilihanOlahraga[tiketCounterOlahraga] = input.nextInt();
                input.nextLine();
                if (paketPilihanOlahraga[tiketCounterOlahraga] > 0 && paketPilihanOlahraga[tiketCounterOlahraga] < 4)
                    inputMatches = false;
                else
                    System.out.println("Inputan anda salah ");
            }
            while (!inputMatches) {
                if (paketPilihanOlahraga[tiketCounterOlahraga] == 1) {
                    System.out.println(" " + fiturPaketOlahraga[1]);
                } else if (paketPilihanOlahraga[tiketCounterOlahraga] == 2) {
                    System.out.println(" " + fiturPaketOlahraga[2]);
                } else if (paketPilihanOlahraga[tiketCounterOlahraga] == 3) {
                    System.out.println(
                            "Fitur; didalam paket ini akan menentukan banyak orang, banyak olahraga air, banyak hari");
                    System.out.println();
                    do {
                        System.out.print("    Berapa banyak orang yang ingin menggunakannya : ");
                        banyakOrangPaket3Olahraga[tiketCounterOlahraga] = input.nextInt();
                        if (banyakOrangPaket3Olahraga[tiketCounterOlahraga] < 1)
                            System.out.println("Banyak orang harus lebih dari 1");
                    } while (banyakOrangPaket3Olahraga[tiketCounterOlahraga] < 1);
                    do {
                        System.out.print("    Berapa hari anda ingin menggunakannya : ");
                        banyakHariPaket3Olahraga[tiketCounterOlahraga] = input.nextInt();
                        if (banyakHariPaket3Olahraga[tiketCounterOlahraga] < 1)
                            System.out.println("Banyak hari harus lebih dari 1");
                    } while (banyakHariPaket3Olahraga[tiketCounterOlahraga] < 1);
                    do {
                        System.out.print("    Berapa banyak jenis olahraga air yang ingin anda pakai : ");
                        banyakJenisOlahragaPaket3[tiketCounterOlahraga] = input.nextInt();
                        if (banyakJenisOlahragaPaket3[tiketCounterOlahraga] < 1)
                            System.out.println("Banyak orang harus lebih dari 1");
                    } while (banyakJenisOlahragaPaket3[tiketCounterOlahraga] < 1);
                    input.nextLine();
                }
                System.out.print("    Apakah paket di atas sudah benar (iya/tidak): ");
                String check = input.nextLine();
                if (check.equalsIgnoreCase("iya"))
                    inputMatches = true;
                else if (check.equalsIgnoreCase("tidak"))
                    System.out.println();
                else
                    System.out.println("Inputan anda salah tetapi kami anggap itu tidak");
            }
            System.out.println("JADWAL PAKET OLAHRAGA AIR : ");
            while (inputMatches) {
                System.out.print("    -Masukkan nama hari : ");
                hariOlahraga[tiketCounterOlahraga] = input.nextLine();
                for (String keyword : keywordsForHari) {
                    if (hariOlahraga[tiketCounterOlahraga].equalsIgnoreCase(keyword))
                        inputMatches = false;
                }
                if (inputMatches == true)
                    System.out.println("Inputan anda bukan nama hari");
            }
            while (!inputMatches) {
                System.out.print("    -Masukkan tanggal (angka) : ");
                tanggalOlahraga[tiketCounterOlahraga] = input.nextInt();
                if (tanggalOlahraga[tiketCounterOlahraga] < 32 && tanggalOlahraga[tiketCounterOlahraga] > 0) {
                    inputMatches = true;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            while (inputMatches) {
                System.out.print("    -Masukkan bulan (angka) : ");
                bulanOlahraga[tiketCounterOlahraga] = input.nextInt();
                if (bulanOlahraga[tiketCounterOlahraga] < 13 && bulanOlahraga[tiketCounterOlahraga] > 0) {
                    inputMatches = false;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            System.out.print("    -Masukkan tahun : ");
            tahunOlahraga[tiketCounterOlahraga] = input.nextInt();
            System.out.println();
            System.out.println("HARGA : ");
            if (paketPilihanOlahraga[tiketCounterOlahraga] == 3) {
                hargaTotalOlahraga[tiketCounterOlahraga] = 4500000 * banyakHariPaket3Olahraga[tiketCounterOlahraga]
                        * banyakOrangPaket3Olahraga[tiketCounterOlahraga]
                        * banyakJenisOlahragaPaket3[tiketCounterOlahraga];
                System.out.println("    -Harga total : " + hargaTotalOlahraga[tiketCounterOlahraga]);
                System.out.println("    -Jenis pembayaran : ");
                System.out.println("    1. Kartu debit");
                System.out.println("    2. Cash ");
                System.out.println("    3. Gopay ");
            } else {
                System.out.println(
                        "    -Harga total : " + hargaPaketOlahraga[paketPilihanOlahraga[tiketCounterOlahraga]]);
                System.out.println("    -Jenis pembayaran : ");
                System.out.println("    1. Kartu debit");
                System.out.println("    2. Cash");
                System.out.println("    3. Gopay");
                hargaTotalOlahraga[tiketCounterOlahraga] = hargaPaketOlahraga[paketPilihanOlahraga[tiketCounterOlahraga]];
            }
            while (!inputMatches) {
                System.out.print("    Pilih salah satu jenis pembayaran (nomor) : ");
                jenisPembayaran = input.nextInt();
                if (jenisPembayaran > 0 && jenisPembayaran < 4) {
                    inputMatches = true;
                } else {
                    System.out.println("Inputan anda salah");
                }
            }
            System.out.println("Selamat, tiket anda telah keluar, untuk melihat tiket silahkan lihat menut ke 4");
        }
        tiketCounterOlahraga++;
    }
}