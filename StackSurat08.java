import java.util.Scanner;

// 1. Class Surat
class Surat {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char jenisIzin;
    int durasi;

    public Surat() {
    }

    public Surat(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }

    public String getIdSurat() {
        return idSurat;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getKelas() {
        return kelas;
    }

    public char getJenisIzin() {
        return jenisIzin;
    }

    public int getDurasi() {
        return durasi;
    }

    public String toString() {
        return "ID Surat: " + idSurat + "\nNama Mahasiswa: " + namaMahasiswa + "\nKelas: " + kelas +
                "\nJenis Izin: " + jenisIzin + "\nDurasi: " + durasi + " hari";
    }
}

// 2. Class StackSurat
class StackSurat {
    private Surat[] stack;
    private int top;
    private int size;

    public StackSurat(int size) {
        this.size = size;
        this.stack = new Surat[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack surat penuh!");
        }
    }

    public Surat pop() {
        if (!isEmpty()) {
            Surat surat = stack[top];
            top--;
            return surat;
        } else {
            System.out.println("Stack surat kosong!");
            return null;
        }
    }

    public Surat peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack surat kosong!");
            return null;
        }
    }

    public Surat cariSurat(String namaMahasiswa) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].getNamaMahasiswa().equalsIgnoreCase(namaMahasiswa)) {
                return stack[i];
            }
        }
        return null;
    }
}

// 3. (Main Class)
public class StackSurat08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackSurat stackSurat = new StackSurat(10);

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat Izin");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("ID Surat: ");
                    String idSurat = scanner.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String namaMahasiswa = scanner.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scanner.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenisIzin = scanner.next().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Surat surat = new Surat(idSurat, namaMahasiswa, kelas, jenisIzin, durasi);
                    stackSurat.push(surat);
                    System.out.println("Surat izin berhasil diterima.");
                    break;
                case 2:
                    Surat suratDiproses = stackSurat.pop();
                    if (suratDiproses != null) {
                        System.out.println("Memproses surat izin:\n" + suratDiproses);
                    }
                    break;
                case 3:
                    Surat suratTerakhir = stackSurat.peek();
                    if (suratTerakhir != null) {
                        System.out.println("Surat izin terakhir:\n" + suratTerakhir);
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String namaCari = scanner.nextLine();
                    Surat suratCari = stackSurat.cariSurat(namaCari);
                    if (suratCari != null) {
                        System.out.println("Surat izin ditemukan:\n" + suratCari);
                    } else {
                        System.out.println("Surat izin tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}