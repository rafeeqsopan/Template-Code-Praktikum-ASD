class NodeCSLL {
    Object data;
    NodeCSLL setelah;

    NodeCSLL(Object data) {
        this.data = data;
        this.setelah = null;
    }
}

public class CircularSingleLinkedList {


    private NodeCSLL pAwal, pAkhir;
    private int jumlah; 

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = 0;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCSLL pBaru = new NodeCSLL(data);
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.setelah = pBaru; 
        } else {
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
        }
        jumlah++;
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCSLL pBaru = new NodeCSLL(data);
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.setelah = pBaru;
        } else {
            pAkhir.setelah = pBaru;
            pBaru.setelah = pAwal;
            pAkhir = pBaru;
        }
        jumlah++;
    }

    public void hapusData(Object dtHapus) {
        if (pAwal == null) return; 

        NodeCSLL pSbl = null, pKini = pAwal;
        boolean ketemu = false;
        int i = 0;

        while (!ketemu && i < jumlah) {
            if (pKini.data.equals(dtHapus)) {
                ketemu = true;
            } else {
                pSbl = pKini;
                pKini = pKini.setelah;
            }
            i++;
        }

        if (!ketemu) return; 

        if (jumlah == 1 && pKini == pAwal) {
            pAwal = null;
            pAkhir = null;
            jumlah = 0;
            return;
        }

        if (pSbl == null) {
            NodeCSLL pHapus = pAwal;
            pAwal = pKini.setelah;
            pAkhir.setelah = pAwal;
        } else {
            pSbl.setelah = pKini.setelah;
            if (pAkhir == pKini) {
                pAkhir = pSbl;
            }
        }
        jumlah--;
    }

    public void hapusSatuDataDiAwal() {
        if (pAwal == null) return; 

        if (jumlah == 1) {
            pAwal = null;
            pAkhir = null;
            jumlah = 0;
            return;
        }

        pAwal = pAwal.setelah;
        pAkhir.setelah = pAwal;
        jumlah--;
    }

    public void hapusSatuDataDiAkhir() {
        if (pAwal == null) return;

        if (jumlah == 1) {
            pAwal = null;
            pAkhir = null;
            jumlah = 0;
            return;
        }

        NodeCSLL prev = pAwal;
        while (prev.setelah != pAkhir) {
            prev = prev.setelah;
        }
        prev.setelah = pAwal;
        pAkhir = prev;
        jumlah--;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        if (pAwal == null) {
            System.out.println("List kosong.");
            return;
        }
        NodeCSLL pCetak = pAwal;
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
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        csll.SisipDataDiAwal(new Integer(50));
        csll.SisipDataDiAwal(new Integer(60));
        csll.SisipDataDiAwal(new Integer(70));
        csll.SisipDataDiAwal(new Integer(8));
        csll.SisipDataDiAwal(new Integer(9));
        csll.SisipDataDiAwal(new Integer(90));
        csll.SisipDataDiAwal(new Integer(19));
        csll.cetak("csll Asal");
        csll.hapusData(new Integer(8));
        csll.cetak("csll stl 8 dihapus");
        csll.hapusData(new Integer(90));
        csll.cetak("csll stl 90 dihapus");

        csll.SisipDataDiAkhir(new Integer(100));
        csll.cetak("setelah sisip di akhir 100");
        csll.hapusSatuDataDiAwal();
        csll.cetak("setelah hapus satu di awal");
        csll.hapusSatuDataDiAkhir();
        csll.cetak("setelah hapus satu di akhir");
    }
}
