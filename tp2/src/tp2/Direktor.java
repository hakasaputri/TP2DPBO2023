/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5_2;

/**
 *
 * @author Hp
 */
public class Direktor {
    
    private int id;
    private String nama;
    private int jumlah;
    private String email;
    private byte[] image;
    
    public Direktor(){
        
    }
    
    public Direktor(int id, String nama, int jumlah, String email, byte[]image){
        
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.email = email;
        this.image = image;
    }
    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
        
        public int getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
