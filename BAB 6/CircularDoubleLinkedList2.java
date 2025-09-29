class NodeCDLL {
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;

    NodeCDLL(Object data) {
        this.data = data;
        this.sebelum = null;
        this.setelah = null;
    }
}

public class CircularDoubleLinkedList2 {

    private NodeCDLL pAwal, pAkhir;
    private int jumlah; 
    public CircularDoubleLinkedList2() {
        pAwal = null;
        pAkhir = null;
        jumlah = 0;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL(data);
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.sebelum = pBaru;
            pBaru.setelah = pBaru;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
        }
        jumlah++;
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL(data);
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.sebelum = pBaru;
            pBaru.setelah = pBaru;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAwal.sebelum = pBaru;
            pAkhir = pBaru;
        }
        jumlah++;
    }

    public void hapusData(Object dtHapus) {
        if (pAwal == null) return; 

        NodeCDLL kini = pAwal;
        boolean ketemu = false;
        int i = 0;

        while (!ketemu && i < jumlah) {
            if (kini.data.equals(dtHapus)) {
                ketemu = true;
            } else {
                kini = kini.setelah;
            }
            i++;
        }

        if (!ketemu) return; 

        if (jumlah == 1 && kini == pAwal) {
            pAwal = null;
            pAkhir = null;
            jumlah = 0;
            return;
        }

        NodeCDLL prev = kini.sebelum;
        NodeCDLL next = kini.setelah;

        prev.setelah = next;
        next.sebelum = prev;

        if (kini == pAwal) {
            pAwal = next;
        }
        if (kini == pAkhir) {
            pAkhir = prev;
        }

        jumlah--;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        if (pAwal == null) {
            System.out.println("List kosong.");
            return;
        }
        NodeCDLL pCetak = pAwal;
        int i = 0;
        while (i < jumlah) {
            System.out.print(pCetak.data);
            if (i < jumlah - 1) System.out.print(" -> ");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList2 cdll = new CircularDoubleLinkedList2();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");

        cdll.SisipDataDiAkhir(new Integer(100));
        cdll.cetak("setelah sisip di akhir 100");

        cdll.hapusData(new Integer(8));
        cdll.cetak("setelah hapus data 8");

        cdll.hapusData(new Integer(90));
        cdll.cetak("setelah hapus data 90");
    }
}
