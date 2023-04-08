/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5_2;

/**
 *
 * @author Hp
 */
public class Film {
    
    private int id;
    private String nama;
    private String genre;
    private byte[] image;
    
    public Film(int id, String nama, String genre, byte[]image){
        
        this.id = id;
        this.nama = nama;
        this.genre = genre;
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

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
