package cubes.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table
public class Category {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	@Size(min=3, max=20, message="min 3, max 20 characters")
	private String name;
	@Column
	private String description;
	@Column
	private String image;
	@Column
	private boolean isOnMainPage;
	@Transient
	private List <Product> productsOnMainPage;

	@Transient
	private long count;
	
    public Category() {
 
    }
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Product> getProductsOnMainPage() {
		return productsOnMainPage;
	}

	public void setProductsOnMainPage(List<Product> productsOnMainPage) {
		this.productsOnMainPage = productsOnMainPage;
	}
	
	
	
	
	
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+ id +") - " + name;
	}

}
